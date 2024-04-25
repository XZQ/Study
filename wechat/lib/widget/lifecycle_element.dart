import 'package:flutter/src/widgets/framework.dart';
import 'package:wechat/widget/test_element.dart';

class LifecycleElement extends TestElement {
  LifecycleElement(Widget widget) : super(widget);

  @override
  void mount(Element parent, newSlot) {
    print("LifecycleElement mount");
    super.mount(parent, newSlot);
  }

  @override
  void unmount() {
    print("LifecycleElement unmount");
    super.unmount();
  }

  @override
  void activate() {
    print("LifecycleElement activate");
    super.activate();
  }

  @override
  void rebuild() {
    print("LifecycleElement rebuild");
    super.rebuild();
  }

  @override
  void deactivate() {
    print("LifecycleElement deactivate");
    super.deactivate();
  }

  @override
  void didChangeDependencies() {
    print("LifecycleElement didChangeDependencies");
    super.didChangeDependencies();
  }

  @override
  void update(Widget newWidget) {
    print("LifecycleElement update");
    super.update(newWidget);
  }

  @override
  Element updateChild(Element child, Widget newWidget, newSlot) {
    print("LifecycleElement updateChild");
    return super.updateChild(child, newWidget, newSlot);
  }

  @override
  void deactivateChild(Element child) {
    print("LifecycleElement deactivateChild");
    super.deactivateChild(child);
  }
}
