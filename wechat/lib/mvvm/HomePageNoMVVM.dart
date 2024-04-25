import 'package:flutter/material.dart';
import 'package:wechat/mvvm/network.dart';
import 'package:wechat/tools/ThemeColors.dart';

class HomePageNoMVVM extends StatefulWidget {
  @override
  _HomePageNoMVVMState createState() => _HomePageNoMVVMState();
}

class _HomePageNoMVVMState extends State<HomePageNoMVVM> {
  bool _loading = true;
  String _text;

  @override
  void initState() {
    super.initState();
    loadData();
  }

  void loadData() {
    NetWork.query().then((String text) {
      setState(() {
        _loading = false;
        _text = text;
      });
    }).catchError((error) {
      setState(() {
        _loading = false;
        _text = error.toString();
      });
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: new AppBar(
        title: new Text('Plugin', style: new TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
      ),
      body: Center(
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.center,
          children: <Widget>[
            RaisedButton(
              child: Text("点击重新获取网络数据"),
              onPressed: () {
                loadData();
              },
            ),
            Offstage(
              offstage: !_loading,
              child: CircularProgressIndicator(),
            ),
            Expanded(
              child: SingleChildScrollView(
                child: Text("${_text ?? ""}"),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
