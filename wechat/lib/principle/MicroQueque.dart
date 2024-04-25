import 'package:flutter/material.dart';
import 'package:wechat/tools/ThemeColors.dart';

//https://juejin.im/post/5cadacdb6fb9a068a03ae550?utm_source=gold_browser_extension
class MicroQueque extends StatefulWidget {
  @override
  _MicroQuequeState createState() => _MicroQuequeState();
}

class _MicroQuequeState extends State<MicroQueque> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: new AppBar(
        title: new Text('Queue', style: new TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
      ),
      body: new Container(),
    );
  }
}
