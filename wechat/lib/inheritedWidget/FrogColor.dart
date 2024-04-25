import 'package:flutter/material.dart';
// import 'package:flutter/widgets.dart';

class FrogColor extends InheritedWidget {
  final Color color;

  const FrogColor({Key key, @required this.color, @required Widget child})
      : assert(color != null),
        assert(child != null),
        super(key: key, child: child);

  static FrogColor of(BuildContext context) =>
      context.inheritFromWidgetOfExactType(FrogColor);

  @override
  bool updateShouldNotify(FrogColor oldWidget) => color != oldWidget.color;
}
