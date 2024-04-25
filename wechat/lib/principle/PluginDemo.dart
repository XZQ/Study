import 'package:flutter/material.dart';
import 'package:wechat/tools/ThemeColors.dart';

class PluginDemo extends StatefulWidget {
  @override
  _PluginDemoState createState() => _PluginDemoState();
}

class _PluginDemoState extends State<PluginDemo> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: new AppBar(
        title: new Text('Plugin', style: new TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
      ),
      body: new Container(),
    );
  }
}
