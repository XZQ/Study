import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';

class DataInfo with ChangeNotifier {
  int _count = 0;
  ThemeData _themeData = ThemeData.light();

  int get count => _count;

  ThemeData get themeData => _themeData;

  addCount() {
    _count++;
    //父类的方法,发出通知
    notifyListeners();
  }

  subCount() {
    if (_count == 0) return;
    _count--;
    notifyListeners();
  }

  changeTheme() {
    if (_themeData == ThemeData.light()) {
      _themeData = ThemeData.dark();
    } else {
      _themeData = ThemeData.light();
    }
    notifyListeners();
  }
}
