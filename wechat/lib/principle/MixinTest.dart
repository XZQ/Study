import 'package:flutter/material.dart';
import 'package:wechat/tools/ThemeColors.dart';

class MixinTest extends StatefulWidget {
  @override
  _MixinTestState createState() => _MixinTestState();
}

class _MixinTestState extends State<MixinTest> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Flutter Mixin'),
        backgroundColor: ThemeColors.currentColorTheme,
      ),
      body: Container(alignment: Alignment.center, child: Text('data')),
    );
  }
}
