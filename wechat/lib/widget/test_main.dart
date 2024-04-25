import 'package:flutter/material.dart';
import 'package:wechat/tools/ThemeColors.dart';
import 'package:wechat/widget/test_widget.dart';

class TestMain extends StatefulWidget {
  @override
  _TestMainState createState() => _TestMainState();
}

class _TestMainState extends State<TestMain> {
  bool isShow = true;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Element', style: TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
      ),
      body: Center(
          child: Column(
        children: <Widget>[
          Padding(padding: EdgeInsets.all(10)),
          isShow ? TestWidget() : Container(),
        ],
      )),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          setState(() {
            isShow = !isShow;
          });
        },
        child: Icon(Icons.ac_unit),
      ),
    );
  }
}
