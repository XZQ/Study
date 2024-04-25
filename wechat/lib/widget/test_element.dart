import 'package:flutter/material.dart';
import 'package:wechat/widget/test_widget.dart';

class TestElement extends Element {
  Element _child;

  TestElement(Widget widget) : super(widget);

  @override
  bool get debugDoingBuild => throw UnimplementedError();

  @override
  void performRebuild() {
    ///调用build函数
    var _build = build();

    ///更新子视图
    _child = updateChild(_child, _build, slot);
  }

  @override
  void update(Widget newWidget) {
    super.update(newWidget);
    // print("25 ${widget} ${super.widget} update");
    ///更新.
    performRebuild();
  }

  ///将widget强转成TestWidget
  @override
  TestWidget get widget => super.widget as TestWidget;

  /// 调用TestWidget的build函数
  Widget build() => widget.build(this);
}
