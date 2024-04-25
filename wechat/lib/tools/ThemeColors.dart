import 'package:flutter/material.dart';

class ThemeColors {
  // 默认主题色
  static const Color defaultColor = Colors.green;

  // 可选的主题色
  static const List<Color> supportColors = [
    defaultColor,
    Colors.purple,
    Colors.orange,
    Colors.deepPurpleAccent,
    Colors.redAccent,
    Colors.blue,
    Colors.amber,
    Colors.green,
    Colors.lime,
    Colors.indigo,
    Colors.cyan,
    Colors.teal,
    Colors.white
  ];

  // 当前的主题色
  static Color currentColorTheme = defaultColor;

  static const Color yellowFF2474 = Color(0xFFFF2474);
  static const Color yellowFF4F00 = Color(0xFFFF4F00);
  static const Color white = Color(0xFFFFFFFF);
}

