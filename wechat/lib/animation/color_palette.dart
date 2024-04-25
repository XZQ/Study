import 'package:flutter/material.dart';
import 'dart:math';

class ColorPalette {
  static final ColorPalette primary = new ColorPalette(<Color>[
    Colors.blue[400],
    Colors.red[400],
    Colors.green[400],
    Colors.yellow[400],
    Colors.purple[400],
    Colors.orange[400],
    Colors.teal[400],
  ]);

  ColorPalette(List<Color> colors) : _colors = colors {
    assert(colors.isNotEmpty);
  }

  factory ColorPalette.monochrome(Color base, int length) {
    return new ColorPalette(
        new List.generate(length, (i) => _brighterColor(base, i, length)));
  }

  static Color _brighterColor(Color base, int i, int n) {
    /*
    const Color.fromARGB(
      int a,
      int r,
      int g,
      int b
    )
    从四个整数的低8位构造一个颜色
      a：a是alpha值，0是透明的，255是完全不透明的
      r：r为红色，从0到255
      g：g为红色，从0到255
      b：b为红色，从0到255
     */
    return new Color.fromARGB(
        /*
      int alpha
      这个颜色的alpha通道是8位值
      值为0表示此颜色完全透明。值为255表示此颜色完全不透明
       */
        base.alpha,
        _brighterComponent(base.red, i, n),
        _brighterComponent(base.green, i, n),
        _brighterComponent(base.blue, i, n));
  }

  static int _brighterComponent(int base, int i, int n) {
    return (base + i * (255 - base) / n).floor();
  }

  final List<Color> _colors;

  Color operator [](int index) => _colors[index % length];

  int get length => _colors.length;

  Color random(Random random) => this[random.nextInt(length)];
}
