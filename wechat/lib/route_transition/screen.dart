import 'package:flutter/material.dart';
import 'package:wechat/tools/ThemeColors.dart';

class Screen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.blue,
      appBar: new AppBar(
        title: new Text('动画', style: new TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
        elevation: 0.0,
      ),
      body: Center(
        child: Text("XZQ"),
      ),
    );
  }
}
