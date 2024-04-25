import 'package:flutter/material.dart';
import 'package:wechat/tools/ThemeColors.dart';

class AnimationOne extends StatefulWidget {
  @override
  _AnimationOneState createState() => _AnimationOneState();
}

class _AnimationOneState extends State<AnimationOne>
    with SingleTickerProviderStateMixin {
  AnimationController _controller;
  Animation<double> _animation;

  @override
  void initState() {
    super.initState();
    _controller = new AnimationController(
        duration: const Duration(milliseconds: 2000), vsync: this);
    _animation = new Tween(begin: 0.0, end: 1.0).animate(_controller);
    _controller.forward();
  }

  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: new AppBar(
        title: new Text('动画', style: new TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
      ),
      body: AnimatedLogo(animation: _animation),
    );
  }

  @override
  void dispose() {
    _controller.dispose();
    super.dispose();
  }
}

// 使用AnimatedWidget简化
class AnimatedLogo extends AnimatedWidget {
  AnimatedLogo({Key key, Animation<double> animation})
      : super(key: key, listenable: animation);

  @override
  Widget build(BuildContext context) {
    final Animation<double> animation = listenable;
    print(animation.value.toString() + "  ==");
    return new Center(
      child: Container(
        decoration: BoxDecoration(
          color: Colors.green,
        ),
        height: animation.value * 150,
        width: animation.value * 150,
      ),
    );
  }
}
