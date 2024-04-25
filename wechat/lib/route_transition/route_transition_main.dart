import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:wechat/route_transition/fade.route.dart';
import 'package:wechat/route_transition/rotation_route.dart';
import 'package:wechat/route_transition/scale_rotate_route.dart';
import 'package:wechat/route_transition/scale_route.dart';
import 'package:wechat/route_transition/screen.dart';
import 'package:wechat/route_transition/size_route.dart';
import 'package:wechat/route_transition/slide_right_route.dart';
import 'package:wechat/tools/ThemeColors.dart';

//https://juejin.im/post/5ceb6179f265da1bc23f55d0?utm_source=gold_browser_extension
class RouteTransitionMain extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: new AppBar(
        title: new Text('路由动画', style: new TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
        elevation: 0.0,
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: <Widget>[
            // RaisedButton(
            //   child: Text("EnterExitRoute"),
            //   onPressed: () {
            //     Navigator.push(context, new EnterExitRoute(page: Screen()));
            //   },
            //   textTheme: ButtonTextTheme.normal,
            //   textColor: Colors.blue,
            //   color: Color(0xFF82B1FF),
            // ),
            RaisedButton(
              child: Text("FadeRoute"),
              onPressed: () {
                Navigator.push(context, new FadeRoute(page: Screen()));
              },
              textTheme: ButtonTextTheme.normal,
              textColor: Colors.blue,
              color: Color(0xFF82B1FF),
            ),
            RaisedButton(
              child: Text("RotationRoute"),
              onPressed: () {
                Navigator.push(context, new RotationRoute(page: Screen()));
              },
              textTheme: ButtonTextTheme.normal,
              textColor: Colors.blue,
              color: Color(0xFF82B1FF),
            ),
            RaisedButton(
              child: Text("ScaleRotateRoute"),
              onPressed: () {
                Navigator.push(context, new ScaleRotateRoute(page: Screen()));
              },
              textTheme: ButtonTextTheme.normal,
              textColor: Colors.blue,
              color: Color(0xFF82B1FF),
            ),
            RaisedButton(
              child: Text("ScaleRoute"),
              onPressed: () {
                Navigator.push(context, new ScaleRoute(page: Screen()));
              },
              textTheme: ButtonTextTheme.normal,
              textColor: Colors.blue,
              color: Color(0xFF82B1FF),
            ),
            RaisedButton(
              child: Text("SizeRoute"),
              onPressed: () {
                Navigator.push(context, new SizeRoute(page: Screen()));
              },
              textTheme: ButtonTextTheme.normal,
              textColor: Colors.blue,
              color: Color(0xFF82B1FF),
            ),
            RaisedButton(
              child: Text("SlideRightRoute"),
              onPressed: () {
                Navigator.push(context, new SlideRightRoute(page: Screen()));
              },
              textTheme: ButtonTextTheme.normal,
              textColor: Colors.blue,
              color: Color(0xFF82B1FF),
            ),
          ],
        ),
      ),
    );
  }
}
