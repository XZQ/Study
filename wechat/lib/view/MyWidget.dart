import 'package:flutter/material.dart';
import 'package:wechat/page/GradientButtonRoute.dart';
import 'package:wechat/page/LearnMaterial.dart';
import 'package:wechat/tools/ThemeColors.dart';
import 'package:wechat/view/CustomPaintRoute.dart';
import 'package:wechat/view/GradientCircularProgressRoute.dart';
import 'package:wechat/view/TurnBoxRoute.dart';

class MyWidget extends StatefulWidget {
  @override
  _MyWidgetState createState() => _MyWidgetState();
}

class _MyWidgetState extends State<MyWidget> {
  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: new AppBar(
        elevation: 0.0,
        title: new Text('TurnBox', style: new TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
      ),
      body: new Column(
        children: <Widget>[
          _gradientkWidget(context),
          _learnMaterialWidget(context),
          _turnBoxlWidget(context),
          _GradientCircularProgressIndicator(context),
          _CustomPaintRoute(context),
        ],
      ),
    );
  }

  Widget _CustomPaintRoute(BuildContext context) {
    return new Container(
      padding: const EdgeInsets.only(top: 1.0),
      height: 50.0,
      child: new ListTile(
        leading: new Icon(Icons.watch_later),
        title: new Text("五子棋"),
        onTap: () {
          Navigator.push(context, new MaterialPageRoute(builder: (ctx) {
            return new CustomPaintRoute();
          }));
        },
      ),
      color: Colors.white,
    );
  }

  //  TurnBox
  Widget _GradientCircularProgressIndicator(BuildContext context) {
    return new Container(
      padding: const EdgeInsets.only(top: 0.5),
      child: new Container(
        height: 50.0,
        child: new ListTile(
          leading: new Icon(Icons.check_circle_outline),
          title: new Text("圆形渐变进度条"),
          onTap: () {
            Navigator.push(context, new MaterialPageRoute(builder: (ctx) {
              return new GradientCircularProgressRoute();
            }));
          },
        ),
        color: Colors.white,
      ),
      color: Colors.grey[200],
    );
  }

  //  TurnBox
  Widget _turnBoxlWidget(BuildContext context) {
    return new Container(
      padding: const EdgeInsets.only(top: 0.5),
      child: new Container(
        height: 50.0,
        child: new ListTile(
          leading: new Icon(Icons.refresh),
          title: new Text("turnBox"),
          onTap: () {
            Navigator.push(context, new MaterialPageRoute(builder: (ctx) {
              return new TurnBoxRoute();
            }));
          },
        ),
        color: Colors.white,
      ),
      color: Colors.grey[200],
    );
  }

//  边框
  Widget _learnMaterialWidget(BuildContext context) {
    return new Container(
      padding: const EdgeInsets.only(top: 0.5),
      child: new Container(
        height: 50.0,
        child: new ListTile(
          leading: new Icon(Icons.sync_disabled),
          title: new Text("边框"),
          onTap: () {
            Navigator.push(context, new MaterialPageRoute(builder: (ctx) {
              return new LearnMaterial();
            }));
          },
        ),
        color: Colors.white,
      ),
      color: Colors.grey[200],
    );
  }

// 自定义按钮
  Widget _gradientkWidget(BuildContext context) {
    return new Container(
      padding: const EdgeInsets.only(top: 0.5),
      child: new Container(
        height: 50.0,
        child: new ListTile(
          leading: new Icon(Icons.sentiment_very_satisfied),
          title: new Text("自定义按钮"),
          onTap: () {
            Navigator.push(context, new MaterialPageRoute(builder: (ctx) {
              return new GradientButtonRoute();
            }));
          },
        ),
        color: Colors.white,
      ),
      color: Colors.grey[200],
    );
  }
}
