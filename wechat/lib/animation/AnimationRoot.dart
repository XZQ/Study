import 'package:flutter/material.dart';
import 'package:wechat/animation/AnimantionTrnas.dart';
import 'package:wechat/animation/AnimationNormal.dart';
import 'package:wechat/animation/AnimationOne.dart';
import 'package:wechat/animation/AnimationPage.dart';
import 'package:wechat/animation/AnimationThree.dart';
import 'package:wechat/animation/AnimationTwo.dart';
import 'package:wechat/animation/CurveAnimationt.dart';
import 'package:wechat/animation/FrameAnimationImage.dart';
import 'package:wechat/tools/ThemeColors.dart';

class AnimationRoot extends StatefulWidget {
  createState() => AnimationRootState();
}

class AnimationRootState extends State<AnimationRoot> {
  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: new AppBar(
        title: new Text('动画'),
        backgroundColor: ThemeColors.currentColorTheme,
        elevation: 0.0,
      ),
      body: new ListView(
        children: <Widget>[
          _animationbase(context),
          _animationOne(context),
          _curveAnimationt(context),
          _aimationTwo(context),
          _aimationThree(context),
          _aimationPage(context),
          _frameAnimationImage(context),
          _transAnimationImage(context),
        ],
      ),
    );
  } //

  //动画
  Widget _transAnimationImage(BuildContext context) {
    return new Container(
      padding: const EdgeInsets.only(top: 1.0),
      height: 50.0,
      child: new ListTile(
        leading: new Icon(Icons.airline_seat_recline_normal),
        title: new Text("平移动画"),
        onTap: () {
          Navigator.push(context, new MaterialPageRoute(builder: (ctx) {
            return new AnimantionTrnas();
          }));
        },
      ),
    );
  }

  //动画
  Widget _frameAnimationImage(BuildContext context) {
    return new Container(
      padding: const EdgeInsets.only(top: 1.0),
      height: 50.0,
      child: new ListTile(
        leading: new Icon(Icons.airline_seat_recline_normal),
        title: new Text("逐帧动画"),
        onTap: () {
          Navigator.push(context, new MaterialPageRoute(builder: (ctx) {
            return new FrameAnimationImage();
          }));
        },
      ),
    );
  }

  //动画
  Widget _aimationPage(BuildContext context) {
    return new Container(
      padding: const EdgeInsets.only(top: 1.0),
      height: 50.0,
      child: new ListTile(
        leading: new Icon(Icons.airline_seat_recline_normal),
        title: new Text("Curves"),
        onTap: () {
          Navigator.push(context, new MaterialPageRoute(builder: (ctx) {
            return new AnimationPage();
          }));
        },
      ),
    );
  }

  //动画
  Widget _aimationThree(BuildContext context) {
    return new Container(
      padding: const EdgeInsets.only(top: 1.0),
      height: 50.0,
      child: new ListTile(
        leading: new Icon(Icons.airline_seat_legroom_normal),
        title: new Text("动画特效"),
        onTap: () {
          Navigator.push(context, new MaterialPageRoute(builder: (ctx) {
            return new AnimationThree();
          }));
        },
      ),
    );
  }

  //动画
  Widget _aimationTwo(BuildContext context) {
    return new Container(
      padding: const EdgeInsets.only(top: 1.0),
      height: 50.0,
      child: new ListTile(
        leading: new Icon(Icons.airline_seat_flat_angled),
        title: new Text("平滑"),
        onTap: () {
          Navigator.push(context, new MaterialPageRoute(builder: (ctx) {
            return new AnimationTwo();
          }));
        },
      ),
    );
  }

  //曲线动画，动画插值，
  Widget _curveAnimationt(BuildContext context) {
    return new Container(
      height: 50.0,
      child: new ListTile(
        leading: new Icon(Icons.crop_square),
        title: new Text("曲线动画，动画插值"),
        onTap: () {
          Navigator.push(context, new MaterialPageRoute(builder: (ctx) {
            return new CurveAnimationt();
          }));
        },
      ),
    );
  }

  //动画
  Widget _animationOne(BuildContext context) {
    return new Container(
      padding: const EdgeInsets.only(top: 1.0),
      height: 50.0,
      child: new ListTile(
        leading: new Icon(Icons.announcement),
        title: new Text("动画"),
        onTap: () {
          Navigator.push(context, new MaterialPageRoute(builder: (ctx) {
            return new AnimationOne();
          }));
        },
      ),
    );
  }

  //动画基础知识
  Widget _animationbase(BuildContext context) {
    return new Container(
      padding: const EdgeInsets.only(top: 1.0),
      height: 50.0,
      child: new ListTile(
        leading: new Icon(Icons.camera),
        title: new Text("动画基础知识"),
        onTap: () {
          Navigator.push(context, new MaterialPageRoute(builder: (ctx) {
            return new AnimationNormal();
          }));
        },
      ),
    );
  }
}
