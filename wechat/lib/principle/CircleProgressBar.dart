import 'package:flutter/material.dart';
import 'package:wechat/tools/ThemeColors.dart';

//https://blog.csdn.net/yumi0629/article/details/83688075
class CircleProgressBar extends StatefulWidget {
  @override
  _CircleProgressBarState createState() => _CircleProgressBarState();
}

class _CircleProgressBarState extends State<CircleProgressBar> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: new AppBar(
        title: new Text('CircleProgressBar',
            style: new TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
      ),
      body: new Container(),
    );
  }
}
