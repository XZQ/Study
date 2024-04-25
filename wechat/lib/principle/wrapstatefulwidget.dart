import 'package:flutter/material.dart';

class WrapStatefulWidget extends StatefulWidget {
  final String _name;

  WrapStatefulWidget(this._name);

  @override
  State<StatefulWidget> createState() {
    // print("XZQ, WrapStatefulWidget:" + _name + "  build");
    return WarpCustomerState("WrapStatefulWidget");
  }
}

class WarpCustomerState extends State<WrapStatefulWidget> {
  String _name;

  WarpCustomerState(this._name) {
    // print("XZQ, " + _name + "  构造");
  }
  int _customerStatelessText = 0;

  @override
  Widget build(BuildContext context) {
    // print("XZQ, WarpCustomerState:" + _name + "  build");
    return Container(
      child: Column(
        children: <Widget>[
          SizedBox(
            height: 20,
          ),
          WarpStatelessWidget(
              "CCCC", "CCCC:" + _customerStatelessText.toString()),
          SizedBox(
            height: 20,
          ),
          GestureDetector(
            onTap: () {
              print("Click");
              _customerStatelessText++;
              setState(() {});
            },
            child: Text("Click"),
          )
        ],
      ),
    );
  }
}

class WarpStatelessWidget extends StatelessWidget {
  final String _text;
  final String _name;

  WarpStatelessWidget(this._name, this._text) {
    print("XZQ, WarpStatelessWidget: " + _name + "  构造");
  }

  @override
  Widget build(BuildContext context) {
    print("XZQ, WarpStatelessWidget: " + _name + "  build");
    if (_name == "CCCC") {
      print("我是一个耗时方法，耗时2s");
    }
    return Text(_text);
  }
}
