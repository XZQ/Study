import 'package:flutter/material.dart';
import 'package:wechat/tools/Log.dart';
import 'package:wechat/tools/ThemeColors.dart';

class GoStatelessWidget extends StatelessWidget {
  GoStatelessWidget() {
    Log.e("TAG", "GoStatelessWidget 构造");
  }

  @override
  Widget build(BuildContext context) {
    Log.e("TAG", "GoStatelessWidget build");

    return Scaffold(
      appBar: new AppBar(
        title: new Text('GoStatelessWidget  生命周期', style: new TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
        elevation: 0.0,
      ),
      body: new Container(),
    );
  }
}
