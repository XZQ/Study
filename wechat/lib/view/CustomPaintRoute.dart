import 'package:flutter/material.dart';
import 'package:wechat/tools/ThemeColors.dart';
import 'dart:math';

class CustomPaintRoute extends StatefulWidget {
  @override
  _CustomPaintRouteState createState() => _CustomPaintRouteState();
}

class _CustomPaintRouteState extends State<CustomPaintRoute> {
  @override
  Widget build(BuildContext context) {
    return  Scaffold(
      appBar:  AppBar(
        title:  Text('五子棋', style:  TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
        elevation: 0.0,
      ),
      body:  Center(
        child:  CustomPaint(
          size:  Size(350, 350),
          painter:  MyPainter(),
          //
        ),
      ),
    );
  }
}

class MyPainter extends CustomPainter {
  @override
  void paint(Canvas canvas, Size size) {
    double eWidth = size.width / 13;
    double eHeight = size.height / 13;

    var paint =  Paint()
      ..color = Color(0x77cdb175)
      ..isAntiAlias = true
      ..style = PaintingStyle.fill; //背景为纸黄色
    canvas.drawRect(Offset.zero & size, paint);

    //画棋盘网格
    paint
      ..style = PaintingStyle.stroke //线
      ..color = Colors.black87
      ..strokeWidth = 1.0;

// 画横线
    for (int i = 0; i <= 13; i++) {
      double dy = i * eHeight;
      canvas.drawLine(Offset(0.0, dy), Offset(size.width, dy), paint);
    }
    // 画竖线
    for (int i = 0; i <= 13; i++) {
      double dx = i * eWidth;
      canvas.drawLine(Offset(dx, 0), Offset(dx, size.width), paint);
    }
    //画一个黑子
    paint
      ..style = PaintingStyle.fill
      ..color = Colors.black;
    canvas.drawCircle(
      Offset(size.width / 2 - eWidth / 2, size.height / 2 - eHeight / 2),
      min(eWidth / 2, eHeight / 2) - 2,
      paint,
    );

    //画一个白子
    paint.color = Colors.white;
    canvas.drawCircle(
      Offset(size.width / 2 + eWidth / 2, size.height / 2 - eHeight / 2),
      min(eWidth / 2, eHeight / 2) - 2,
      paint,
    );
  }

  @override
  bool shouldRepaint(CustomPainter oldDelegate) => true;
}
