import 'package:flutter/material.dart';
import 'package:wechat/tools/ThemeColors.dart';

//https://juejin.im/post/5cb41b8bf265da0369028ac9?utm_source=gold_browser_extension
class SharedPreference extends StatefulWidget {
  @override
  _SharedPreferenceState createState() => _SharedPreferenceState();
}

class _SharedPreferenceState extends State<SharedPreference> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: new AppBar(
        title: new Text('SharedPreference',
            style: new TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
      ),
      body: new Container(),
    );
  }
}
