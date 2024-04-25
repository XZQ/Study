import 'package:flutter/material.dart';
import 'package:wechat/router/page2.dart';
import 'package:wechat/tools/ThemeColors.dart';

class RouterApp extends StatefulWidget {
  @override
  _RouterAppState createState() => _RouterAppState();
}

class _RouterAppState extends State<RouterApp> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('RouterApp', style: new TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
      ),
      body: Center(
        child: Column(
          children: <Widget>[
            RaisedButton(
              child: Text("跳转"),
              onPressed: () {
                Navigator.push(
                    context, MaterialPageRoute(builder: (ctx) => Page2()));
              },
            ),
          ],
        ),
      ),
    );
  }
}
