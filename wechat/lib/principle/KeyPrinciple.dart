import 'package:flutter/material.dart';
import 'package:wechat/tools/ThemeColors.dart';
import 'package:random_color/random_color.dart';
import 'package:wechat/tools/common/log_util.dart';

// https://juejin.im/post/5ca2152f6fb9a05e1a7a9a26?utm_source=gold_browser_extension
class KeyPrinciple extends StatefulWidget {
  @override
  _KeyPrincipleState createState() => _KeyPrincipleState();
}

class _KeyPrincipleState extends State<KeyPrinciple> {
  //
  List<Widget> widgets = [
    // StatefulContainer(key: UniqueKey()),
    // StatefulContainer(key: UniqueKey()),

    // StatefulContainer(),
    // StatefulContainer(),

    StatelessContainer(),
    StatelessContainer()
  ];

  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('深入浅出Keys', style: TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
        elevation: 0.0,
      ),
      body: Center(
        child: Row(
          mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: widgets,
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: switchWidget,
        child: Icon(Icons.undo),
      ),
    );
  }

  void switchWidget() {
    widgets.insert(0, widgets.removeAt(1));
    setState(() {
      LogUtil.e("XZQ");
    });
  }
}

class StatefulContainer extends StatefulWidget {
  //
  StatefulContainer({Key key}) : super(key: key);

  @override
  _StatefulContainerState createState() => _StatefulContainerState();
}

class _StatefulContainerState extends State<StatefulContainer> {
  final Color color = RandomColor().randomColor();

  @override
  Widget build(BuildContext context) {
    return Container(
      margin: EdgeInsets.all(10),
      width: 100,
      height: 100,
      color: color,
    );
  }
}

class StatelessContainer extends StatelessWidget {
  final Color color = RandomColor().randomColor();

  Widget build(BuildContext context) {
    // return  Scaffold(
    //   // appBar:  AppBar(
    //   //   title:  Text('深入浅出Keys', style:  TextStyle(color: Colors.white)),
    //   //   backgroundColor: ThemeColors.currentColorTheme,
    //   //   elevation: 0.0,
    //   // ),
    //   body:  Container(
    //     width: 100,
    //     height: 100,
    //     color: ThemeColors.currentColorTheme,
    //   ),
    // );
    return Container(
      margin: EdgeInsets.all(10),
      width: 100,
      height: 100,
      color: color,
    );
  }
}
