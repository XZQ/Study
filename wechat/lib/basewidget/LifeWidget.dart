import 'package:flutter/material.dart';
import 'package:wechat/tools/Log.dart';
import 'package:wechat/tools/ThemeColors.dart';

class LifeWidget extends StatefulWidget {
  @override
  _LifeWidgetState createState() => _LifeWidgetState();
}

class _LifeWidgetState extends State<LifeWidget> {
  //创建之初调用一次
  @override
  void initState() {
    super.initState();
    Log.i("TAG", "initState");
  }

// 在initState之后调用，可以在这个方法中跨组件拿到数据。
  @override
  void didChangeDependencies() {
    super.didChangeDependencies();
    Log.i("TAG", "didChangeDependencies");
  }

//当组件的状态改变的时候就会调用,比如调用了setState.
  @override
  void didUpdateWidget(LifeWidget oldWidget) {
    super.didUpdateWidget(oldWidget);
    Log.i("TAG", "didUpdateWidget");
  }

//在离开和回到页面的时候都会调用。
  @override
  void deactivate() {
    super.deactivate();
    Log.i("TAG", "deactivate");
  }

//如果处在开发模式，热加载会调用reassemble；
  @override
  void reassemble() {
    super.reassemble();
  }

// 销毁的时候调用
  @override
  void dispose() {
    super.dispose();
    Log.i("TAG", "dispose");
  }

//创建Widget的地方，在离开和回到页面的时候都会调用。
  @override
  Widget build(BuildContext context) {
    Log.i("TAG", "build");
    return Scaffold(
      appBar: new AppBar(
        title: new Text('生命周期', style: new TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
        elevation: 0.0,
      ),
    );
  }
}
