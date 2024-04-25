import 'package:flutter/material.dart';

class AnimantionTrnas extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return new _MovementAniWidgetState();
  }
}

class _MovementAniWidgetState extends State<AnimantionTrnas>
    with TickerProviderStateMixin {
  AnimationController _controller;

  Animation<EdgeInsets> movement;

  void _initController() {
    _controller = AnimationController(
      duration: Duration(milliseconds: 5000),
      vsync: this,
    );
  }

  void _initAni() {
    movement = EdgeInsetsTween(
      begin: EdgeInsets.only(left: 0.0),
      end: EdgeInsets.only(left: 300.0),
    ).animate(
      CurvedAnimation(
        parent: _controller,
        curve: Interval(
          0.0,
          1.0,
          curve: Curves.fastOutSlowIn,
        ),
      ),
    )
      ..addListener(() {
        setState(() {});
      })
      ..addStatusListener((AnimationStatus status) {
        print(status);
      });
  }

  Future _startAnimation() async {
    try {
      // await _controller.repeat();
      await _controller.forward();
      //  .orCancel;
//      await _controller
//          .reverse()
//          .orCancel;
    } on TickerCanceled {
      print('Animation Failed');
    }
  }

  @override
  void initState() {
    super.initState();
    _initController();
    _initAni();
    _startAnimation();
  }

  @override
  void dispose() {
    _controller?.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return new Container(
      color: Colors.blue,
      height: 200.0,
      width: 200.0,
      padding: movement.value,
      child: new Center(
        child: new Text(
          'movement',
          style: new TextStyle(color: Colors.white, fontSize: 16.0),
        ),
      ),
    );
  }
}
