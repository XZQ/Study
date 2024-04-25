import 'package:flutter/material.dart';
import 'package:wechat/tools/Log.dart';
import 'package:wechat/tools/ThemeColors.dart';

class GoStatefulWidget extends StatefulWidget {
  @override
  _GoStatefulWidgetState createState() => _GoStatefulWidgetState();
}

class _GoStatefulWidgetState extends State<GoStatefulWidget> with WidgetsBindingObserver {
  //
  _GoStatefulWidgetState() {
    Log.e("TAG", "_GoStatefulWidgetState ==>  构造");
  }

  @override
  void initState() {
    super.initState();
    WidgetsBinding.instance.addObserver(this);
    Log.e("TAG", "_GoStatefulWidgetState ==>  initState");
  }

  @override
  void didChangeAppLifecycleState(AppLifecycleState state) {
    Log.e("TAG", "_GoStatefulWidgetState ==>  didChangeAppLifecycleState  " + state.toString());
  }

  @override
  void didChangeDependencies() {
    super.didChangeDependencies();
    Log.e("TAG", "_GoStatefulWidgetState ==>  didChangeDependencies");
  }

  @override
  void didUpdateWidget(GoStatefulWidget oldWidget) {
    super.didUpdateWidget(oldWidget);
    Log.e("TAG", "_GoStatefulWidgetState ==>  didUpdateWidget");
  }

  @override
  void deactivate() {
    super.deactivate();
    Log.e("TAG", "_GoStatefulWidgetState ==>  deactivate");
  }

  @override
  void dispose() {
    WidgetsBinding.instance.removeObserver(this);
    super.dispose();
    Log.e("TAG", "_GoStatefulWidgetState ==>  dispose");
  }

  @override
  Widget build(BuildContext context) {
    Log.e("TAG", "_GoStatefulWidgetState ==>  build");
    return Scaffold(
      appBar: new AppBar(
        title: new Text('GoStatefulWidget', style: new TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
        elevation: 0.0,
      ),
      body: new Container(),
    );
  }
}
