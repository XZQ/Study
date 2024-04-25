import 'package:flutter/material.dart';
import 'package:wechat/tools/ThemeColors.dart';

// 帧动画Image
class FrameAnimationImage extends StatefulWidget {
  final double width = 80;
  final double height = 50;
  int interval = 200;

  List<String> _assetList = [
    'images/pull_to_refresh_people_0.png',
    'images/pull_to_refresh_people_1.png',
    'images/pull_to_refresh_people_2.png'
  ];

  @override
  State<StatefulWidget> createState() {
    return _FrameAnimationImageState();
  }
}

class _FrameAnimationImageState extends State<FrameAnimationImage>
    with SingleTickerProviderStateMixin {
  AnimationController _controller; //逐帧动画
  Animation<double> _animation;

  AnimationController translationController; //平移动画
  Animation<EdgeInsets> movement;

  int interval = 200;

  @override
  void initState() {
    super.initState();

    if (widget.interval != null) {
      interval = widget.interval;
    }
    final int imageCount = widget._assetList.length;
    final int maxTime = interval * imageCount;

    _controller = new AnimationController(
        duration: Duration(milliseconds: maxTime), vsync: this)
      ..addStatusListener((AnimationStatus status) {
        if (status == AnimationStatus.completed) {
          _controller.forward(from: 0.0); // 完成后重新开始
        }
      });

    _animation = new Tween<double>(begin: 0, end: imageCount.toDouble())
        .animate(_controller)
          ..addListener(() {
            setState(() {
              // the state that has changed here is the animation object’s value
            });
          });

    // _controller.forward();

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
      await _controller.forward();
    } on TickerCanceled {
      print('Animation Failed');
    }
  }

  @override
  void dispose() {
    _controller?.dispose();
    translationController?.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    int ix = _animation.value.floor() % widget._assetList.length;

    List<Widget> images = [];
    // 把所有图片都加载进内容，否则每一帧加载时会卡顿
    for (int i = 0; i < widget._assetList.length; ++i) {
      if (i != ix) {
        images.add(Image.asset(
          widget._assetList[i],
          // width: 0,
          // height: 0,
        ));
      }
    }
    // images.add(Image.asset(
    //   widget._assetList[ix],
    //   width: widget.width,
    //   height: widget.height,
    // )
    // );
    // return Stack(alignment: AlignmentDirectional.center, children: images);
    return new Scaffold(
        appBar: new AppBar(
          title: new Text('动画', style: new TextStyle(color: Colors.white)),
          backgroundColor: ThemeColors.currentColorTheme,
          elevation: 0.0,
        ),
        body: new Container(
          color: Colors.grey[200],
          height: 60,
          child: new Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              new Padding(
                padding: movement.value,
                child: new Stack(
                    alignment: AlignmentDirectional.center, children: images),
              ),
              new Container(
                padding: EdgeInsets.only(left: 10.0),
                height: 50.0,
                child: Image.asset(
                  "images/pull_to_refresh_text_jddj.png",
                  width: 66,
                  height: 66,
                ),
              )
            ],
          ),
        ));
  }
}
