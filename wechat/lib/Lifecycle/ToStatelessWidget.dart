import 'package:flutter/material.dart';
import 'package:wechat/tools/Log.dart';
import 'package:wechat/tools/ThemeColors.dart';

class ToStatelessWidget extends StatelessWidget with WidgetsBindingObserver {
  ToStatelessWidget() {
    Log.e("TAG", "ToStatelessWidget 构造");
  }

  @override
  Widget build(BuildContext context) {
    Log.e("TAG", "ToStatelessWidget build");

    return Scaffold(
      appBar: AppBar(
        title: Text('ToStatelessWidget', style: TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
        elevation: 0.0,
      ),
      body: Container(),
    );
  }
}
