import 'package:flutter/material.dart';

//https://blog.csdn.net/iamdingruihaha/article/details/88319883
//https://blog.csdn.net/sinat_17775997/article/details/82084067

//https://juejin.im/post/5d0274846fb9a07edd2a0d4c
//https://juejin.im/post/5b4c6054e51d4519475f1d5d
//https://juejin.im/post/5c7e853151882549664b0543
//https://juejin.im/post/5d2940b1f265da1b8d164abf
//
//

class BaseWidget extends StatefulWidget {
  _BaseWidgetState createState() => _BaseWidgetState();
}

class _BaseWidgetState extends State<BaseWidget> {
  @override
  Widget build(BuildContext context) {
    return Container();
  }

  @override
  void initState() {
    super.initState();
    print("First ------------------->initState");
  }

  @override
  void didChangeAppLifecycleState(AppLifecycleState state) {
    print("First ------------------->didChangeAppLifecycleState");
  }

  @override
  void didChangeDependencies() {
    super.didChangeDependencies();
    print("First ------------------->didChangeDependencies");
  }

  @override
  void didUpdateWidget(BaseWidget oldWidget) {
    super.didUpdateWidget(oldWidget);
    print("First ------------------->didUpdateWidget");
  }

  @override
  void reassemble() {
    super.reassemble();
    print("First ------------------->reassemble");
  }

  @override
  void deactivate() {
    super.deactivate();
    print("First ------------------->deactivate");
  }

  @override
  void dispose() {
    super.dispose();
    print("First ------------------->dispose");
  }
}
