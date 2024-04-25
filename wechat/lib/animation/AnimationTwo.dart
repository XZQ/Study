import 'dart:math';
import 'dart:ui';
import 'package:flutter/material.dart';
import 'package:wechat/animation/Bar.dart';
import 'package:wechat/tools/ThemeColors.dart';

class AnimationTwo extends StatefulWidget {
  @override
  _AnimationTwoState createState() => _AnimationTwoState();
}

class _AnimationTwoState extends State<AnimationTwo>
    with SingleTickerProviderStateMixin {
  AnimationController _controller;
  final random = new Random();
  int dataSet = 50;
  BarTween tween;

  void changeData() {
    setState(() {
      dataSet = random.nextInt(100);
      tween = new BarTween(
        tween.evaluate(_controller),
        new Bar.random(random),
      );
      _controller.forward(from: 0.0);
    });
  }

  @override
  void initState() {
    super.initState();
    _controller = new AnimationController(
        duration: const Duration(milliseconds: 2000), vsync: this);
    tween = new BarTween(new Bar.empty(), new Bar.random(random));
    _controller.forward();
  }

  @override
  void dispose() {
    _controller.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: new AppBar(
        title: new Text('动画', style: new TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
        elevation: 0.0,
      ),
      body: Center(
        child: new CustomPaint(
            size: new Size(0, 60),
            painter: new BarChartPainter(tween.animate(_controller))),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: changeData,
        child: new Icon(Icons.refresh),
      ),
    );
  }
}

// class BarChartPainter extends CustomPainter {
//   static const barWidth = 6.0;
//   final Animation<double> animation;

//   BarChartPainter(Animation<double> animation)
//       : animation = animation,
//         super(repaint: animation);

//   @override
//   void paint(Canvas canvas, Size size) {
//     final barHeight = animation.value;
//     final Paint paint = new Paint()
//       ..color = Colors.blue[400]
//       ..style = PaintingStyle.fill;

//     canvas.drawRect(
//         Rect.fromLTWH(size.width - barWidth / 2.0, size.height - barHeight,
//             barWidth, barHeight),
//         paint);
//   }

//   @override
//   bool shouldRepaint(BarChartPainter old) => false;
// }
