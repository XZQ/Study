import 'package:flutter/material.dart';
import 'package:wechat/tools/ThemeColors.dart';

//https://juejin.im/post/5c56c1256fb9a049dd80bc9a?utm_source=gold_browser_extension

class WrapStatelessWidget extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: new AppBar(
        title: new Text('过度绘制', style: new TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
      ),
      body: Container(
        color: Colors.green,
        width: MediaQuery.of(context).size.width,
        child: Column(
          children: <Widget>[
            SizedBox(
              height: 20,
            ),
            CustomerStatelessWidget("NNNN", "NNNN"),
            SizedBox(
              height: 20,
            ),
            CustomerStatefulWidget("MMMM")
          ],
        ),
      ),
    );
  }
}

class CustomerStatefulWidget extends StatefulWidget {
  final String _name;

  CustomerStatefulWidget(this._name);

  @override
  State<StatefulWidget> createState() {
    return CustomerState("CustomerStateA");
  }
}

class CustomerState extends State<CustomerStatefulWidget> {
  String _name;

  CustomerState(this._name) {
    print("TAG, " + _name + "  构造");
  }
  int _customerStatelessText = 0;

  @override
  Widget build(BuildContext context) {
    print("TAG, " + _name + "  build");
    return Container(
      child: Column(
        children: <Widget>[
          CustomerStatelessWidget(
              "MMMM", "MMMM:" + _customerStatelessText.toString()),
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

class CustomerStatelessWidget extends StatelessWidget {
  final String _text;
  final String _name;

  CustomerStatelessWidget(this._name, this._text) {
    print("TAG, " + _name + "  构造");
  }

  @override
  Widget build(BuildContext context) {
    print("TAG, " + _name + "  build");
    // if (_name == "MMMM") {
//      for (int i = 0; i < 1000000; i++) {
//        print("for:" + i.toString());
//      }
    // print("我是一个耗时方法，耗时2s");
    // }
    return Text(_text);
  }
}
