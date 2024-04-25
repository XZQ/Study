import 'dart:math';

import 'package:flutter/material.dart';
import 'package:flutter/animation.dart';
import 'dart:ui' show lerpDouble;

import 'package:wechat/animation/color_palette.dart';

class Bar {
  Bar(this.height, this.color);

  final double height;
  final Color color;

  factory Bar.empty() => new Bar(0.0, Colors.transparent);

  factory Bar.random(Random random) {
    return new Bar(
        random.nextDouble() * 100.0, ColorPalette.primary.random(random));
  }

  static Bar lerp(Bar begin, Bar end, double t) {
    return new Bar(lerpDouble(begin.height, end.height, t),
        Color.lerp(begin.color, end.color, t));
  }
}

class BarTween extends Tween<Bar> {
  BarTween(Bar begin, Bar end) : super(begin: begin, end: end);

  @override
  Bar lerp(double t) => Bar.lerp(begin, end, t);
}

class BarChartPainter extends CustomPainter {
  static const barWidth = 10.0;

  BarChartPainter(Animation<Bar> animation)
      : animation = animation,
        super(repaint: animation);

  final Animation<Bar> animation;

  @override
  void paint(Canvas canvas, Size size) {
    final bar = animation.value;
    final paint = new Paint()
      ..color = bar.color
      ..style = PaintingStyle.fill;
    canvas.drawRect(
        new Rect.fromLTWH(size.width - barWidth / 2.0, size.height - bar.height,
            barWidth, bar.height),
        paint);
  }

  @override
  bool shouldRepaint(BarChartPainter old) => false;
}
