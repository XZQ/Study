import 'package:flutter/material.dart';
import 'package:wechat/principle/wrapstatefulwidget.dart';
import 'package:wechat/tools/ThemeColors.dart';

//https://blog.csdn.net/yuanjinsong123/article/details/87857915
//https://lizhaoxuan.github.io/2019/01/02/Flutter-%E4%BD%A0%E8%BF%98%E5%9C%A8%E6%BB%A5%E7%94%A8StatefulWidget%E5%90%97/#more
class StatelessfulState extends StatefulWidget {
  final String _name;

  StatelessfulState(this._name);

  @override
  State<StatefulWidget> createState() {
    // print("TAG, StatelessfulState:" + _name + "  build");
    return CustomerState("CustomerState");
  }
}

class CustomerState extends State<StatelessfulState> {
  String _name;

  CustomerState(this._name) {
    // print("TAG, CustomerState:" + _name + "  构造");
  }

  int _customerStatelessText = 0;

  @override
  Widget build(BuildContext context) {
    // print("TAG, " + _name + "  build");
    return Scaffold(
      appBar: AppBar(
        title: Text('过度绘制', style: TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
        elevation: 0.0,
      ),
      body: Container(
        color: Colors.lightGreen,
        width: MediaQuery.of(context).size.width,
        child: Column(
          children: <Widget>[
            SizedBox(
              height: 20,
            ),
            Container(
              color: Colors.lightGreen,
              child: new CustomerStateless("BBBB", "BBBB"),
            ),
            SizedBox(
              height: 20,
            ),
            Flexible(
              flex: 1,
              child: CustomerStateful(
                  "AAAA", "AAAA:" + _customerStatelessText.toString()),
            ),
            SizedBox(
              height: 20,
            ),
            Container(
              child: GestureDetector(
                onTap: () {
                  print("Click");
                  setState(() {
                    _customerStatelessText++;
                  });
                },
                child: Text("Click"),
              ),
            ),
            SizedBox(
              height: 20,
            ),
            // WrapStatefulWidget("CCCC")
          ],
        ),
      ),
    );
  }
}

class CustomerStateful extends StatefulWidget {
  final String _text;
  final String _name;

  CustomerStateful(this._name, this._text) {
    print("CustomerStateful= " + _name + "  构造");
  }
  @override
  _CustomerStatefulState createState() => _CustomerStatefulState();
}

class _CustomerStatefulState extends State<CustomerStateful> {
  @override
  Widget build(BuildContext context) {
    print("CustomerStateful= " + widget._name + "  build");
    return Text(widget._text);
    // return Row(
    //   mainAxisAlignment: MainAxisAlignment.center,
    //   crossAxisAlignment: CrossAxisAlignment.center,
    //   children: <Widget>[
    //     CustomerStateless("TTTT", "tttt"),
    //     Padding(
    //       padding: EdgeInsets.only(left: 50),
    //     ),
    //     CustomerStateless("YYYY", "yyyy"),
    //   ],
    // );
  }
}

//
class CustomerStateless extends StatelessWidget {
  final String _text;
  final String _name;

  CustomerStateless(this._name, this._text) {
    print("CustomerStateless= " + _name + "  构造");
  }

  @override
  Widget build(BuildContext context) {
    print("CustomerStateless= " + _name + "  build");
    // if (_name == "BBB") {
    //   print("我是一个耗时方法，耗时2s");
    // }
    return Text(_text);
  }
}
