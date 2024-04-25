import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:wechat/tools/ThemeColors.dart';

/**
 *
 * https://juejin.im/post/6862150535043252237
 *
 * https://juejin.im/post/6844904179014582286
 *
 *
 * https://pub.flutter-io.cn/packages/provider
 *
 *
 */
class Provider4App extends StatefulWidget {
  @override
  _Provider4AppState createState() => _Provider4AppState();
}

class _Provider4AppState extends State<Provider4App> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Provider4', style: TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
      ),
      body: Column(
        children: <Widget>[
          Padding(padding: EdgeInsets.all(10)),
        ],
      ),
    );
  }
}
