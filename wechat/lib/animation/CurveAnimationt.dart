import 'package:flutter/material.dart';
import 'package:wechat/tools/ThemeColors.dart';

class CurveAnimationt extends StatefulWidget {
  @override
  _CurveAnimationtState createState() => _CurveAnimationtState();
}

class _CurveAnimationtState extends State<CurveAnimationt> with SingleTickerProviderStateMixin {
  AnimationController controller; //动画控制器
  CurvedAnimation curved; //曲线动画，动画插值，
  bool forward = true;
  Animation opacity;

  @override
  void initState() {
    super.initState();
    controller = new AnimationController(vsync: this, duration: const Duration(seconds: 2));
    curved = new CurvedAnimation(parent: controller, curve: Curves.bounceOut);
  }

  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: new AppBar(
        title: new Text('曲线动画', style: new TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
      ),
      body: new Center(
        child: new RotationTransition(
          turns: curved,
          child: new FlutterLogo(
            size: 200,
          ),
        ),
      ),
      floatingActionButton: new FloatingActionButton(
        onPressed: () {
          if (forward) {
            controller.forward();
          } else {
            controller.reverse();
          }
          forward = !forward;
        },
        tooltip: "fade",
        child: new Icon(Icons.track_changes),
      ),
    );
  }

  @override
  void dispose() {
    controller.dispose();
    super.dispose();
  }
}
