import 'package:flutter/material.dart';
import 'package:wechat/animation/BarChart.dart';
import 'package:wechat/tools/ThemeColors.dart';
import 'dart:math';
import 'dart:ui';

/**
 * https://blog.csdn.net/hekaiyou/article/details/72625480
 */
class AnimationThree extends StatefulWidget {
  @override
  _AnimationThreeState createState() => _AnimationThreeState();
}

class _AnimationThreeState extends State<AnimationThree>
    with SingleTickerProviderStateMixin {
  AnimationController _controller;
  final random = new Random();
  int dataSet = 50;
  BarChartTween tween;
  static const size = const Size(100.0, 100.0);

  void changeData() {
    setState(() {
      dataSet = random.nextInt(100);

      tween = new BarChartTween(
        tween.evaluate(_controller),
        new BarChart.random(size, random),
      );
      _controller.forward(from: 0.0);
    });
  }

  @override
  void initState() {
    super.initState();
    _controller = new AnimationController(
        duration: const Duration(milliseconds: 500), vsync: this);
    tween = new BarChartTween(
        new BarChart.empty(size), new BarChart.random(size, random));
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
            size: new Size(100.0, 100.0),
            painter: new BarChartPainter(tween.animate(_controller))),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: changeData,
        child: new Icon(Icons.refresh),
      ),
    );
  }
}
