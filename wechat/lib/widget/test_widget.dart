import 'package:flutter/material.dart';

import 'lifecycle_element.dart';

class TestWidget extends Widget {
  @override
  Element createElement() {
    print("8 ${this}   update");
    return LifecycleElement(this);
  }

  /// 这个context其实就是Element
  Widget build(BuildContext context) {
    print("14 TestWidget build");
    return Text("TestWidget");
  }
}
