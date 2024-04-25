import 'package:flutter/material.dart';
import 'package:wechat/tools/ThemeColors.dart';

class Widgets extends StatefulWidget {
  @override
  _WidgetsState createState() => _WidgetsState();
}

class _WidgetsState extends State<Widgets> {
  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: new AppBar(
        title: new Text('控件使用', style: new TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
      ),
      body: new ListView(
        children: <Widget>[
          new Container(
            padding: EdgeInsets.fromLTRB(0, 10, 0, 10),
            child: new Directionality(
              textDirection: TextDirection.rtl,
              child: new DefaultTextStyle(
                  style: new TextStyle(
                      fontSize: 14.0,
                      color: Colors.blue,
                      decoration: TextDecoration.underline),
                  maxLines: 2,
                  softWrap: true,
                  overflow: TextOverflow.ellipsis,
                  child: new Text('我是一段超长的文本啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦'
                      '啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦'
                      '啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦'
                      '啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦')),
            ),
          ),
          //剪切元素的还有ClipOval，ClipPath
          new Container(
            padding: EdgeInsets.fromLTRB(0, 10, 0, 10),
            child: new Align(
              alignment: Alignment.center,
              child: new ClipRRect(
                borderRadius:
                    const BorderRadius.all(const Radius.circular(90.0)),
                child: new Container(
                  width: 180.0,
                  height: 180.0,
                  color: Colors.green,
                ),
              ),
            ),
          ),
          new Container(
            child: new Align(
              alignment: Alignment.center,
              child: new PhysicalModel(
                color: Colors.green,
                elevation: 6.0,
                child: new Container(
                  width: 180.0,
                  height: 180.0,
                  color: Colors.green,
                ),
              ),
            ),
          ),
          new Container(
            padding: EdgeInsets.fromLTRB(0, 10, 0, 10),
            color: Colors.white,
            child: new Align(
              alignment: Alignment.center,
              child: new Transform(
                  transform: new Matrix4.rotationZ(3.14 / 2),
                  child: new Container(
                      color: Colors.black,
                      child: new Text(
                        '垂直文字',
                        style: const TextStyle(color: Colors.red),
                      ))),
            ),
          ),
          new Container(
            color: Colors.white,
            padding: EdgeInsets.fromLTRB(0, 10, 0, 10),
            child: new Align(
              child: new FractionalTranslation(
                translation: const Offset(0.0, 0.0),
                child: new Container(
                  width: 100.0,
                  height: 100.0,
                  color: Colors.red,
                ),
              ),
            ),
          ),
          new Container(
            color: Colors.white,
            padding: EdgeInsets.fromLTRB(0, 10, 0, 10),
            child: new Align(
              child: new FractionalTranslation(
                translation: const Offset(1.0, 0.0),
                child: new Container(
                  width: 100.0,
                  height: 100.0,
                  color: Colors.green,
                ),
              ),
            ),
          ),
          new Container(
            padding: EdgeInsets.fromLTRB(0, 10, 0, 10),
            color: Colors.white,
            alignment: Alignment.center,
            child: new Container(
              width: 200.0,
              height: 100.0,
              color: Colors.black,
              child: new FittedBox(
                fit: BoxFit.fitHeight,
                alignment: Alignment.bottomRight,
                child: new Container(
                  color: Colors.red,
                  width: 300.0,
                  height: 240.0,
                  alignment: Alignment.center,
                  child: new Text('AAA'),
                ),
              ),
            ),
          ),
          new Container(
            padding: EdgeInsets.fromLTRB(0, 10, 0, 10),
            child: _fractionallySizedBox(context),
          ),
          new Container(
            padding: EdgeInsets.fromLTRB(0, 10, 0, 10),
            child: _overflowBox(context),
          ),
          new Container(
            padding: EdgeInsets.fromLTRB(0, 10, 0, 10),
            child: _sizedOverflowBox(context),
          ),
          new Container(
            padding: EdgeInsets.fromLTRB(0, 10, 0, 10),
            child: _sizeBox(context),
          ),
          new Container(
            padding: EdgeInsets.fromLTRB(0, 10, 0, 10),
            child: _aspectRatio(context),
          ),
          new Container(
            padding: EdgeInsets.fromLTRB(0, 10, 0, 10),
            child: _itemBuilder(),
          ),
          new Container(
            padding: EdgeInsets.fromLTRB(0, 10, 0, 10),
            child: _stack1(),
          ),
        ],
      ),
    );
  }

  Widget _fractionallySizedBox(BuildContext context) {
    return new Align(
        alignment: Alignment.center,
        child: new Container(
            color: Colors.green,
            width: 300.0,
            height: 300.0,
            child: new FractionallySizedBox(
                heightFactor: .5,
                widthFactor: .5,
                alignment: Alignment.topLeft,
                child: new Container(
                  color: Colors.red,
                ))));
  }

  Widget _overflowBox(BuildContext context) {
    return new Align(
        alignment: Alignment.center,
        child: new Container(
            color: Colors.green,
            alignment: Alignment.center,
            width: 300.0,
            height: 300.0,
            child: new OverflowBox(
              maxWidth: 200,
              maxHeight: 360,
              child: new Container(
                height: 600.0,
                width: 200.0,
                color: Colors.red,
              ),
            )));
  }

  Widget _sizedOverflowBox(BuildContext context) {
    return new Align(
        child: new Container(
            color: Colors.red,
            alignment: Alignment.center,
            width: 200.0,
            height: 200.0,
            child: new SizedOverflowBox(
                size: new Size(200.0, 300.0),
                child: new Container(color: Colors.green[500]))));
  }

/*
SizeBox强制控制子控件具有特定的宽度、高度或者两者都有。
**/
  Widget _sizeBox(BuildContext context) {
    return new SizedBox(
      width: 500.0,
      height: 100.0,
      child: new Container(
        decoration: new BoxDecoration(color: Colors.deepOrange),
      ),
    );
  }

/*** 
 * AspectRatio强制子控件的宽度和高度具有给定的宽高比。
*/
  Widget _aspectRatio(BuildContext context) {
    return new AspectRatio(
      aspectRatio: 3.0 / 1.0,
      child: new Container(
        decoration: new BoxDecoration(color: Colors.yellow),
      ),
    );
  }

  Widget _itemBuilder() {
    final _size = 50 * 0.6;
    return SizedBox.fromSize(
      size: Size.square(_size),
      child: new DecoratedBox(
        decoration: BoxDecoration(
          shape: BoxShape.circle,
          color: Colors.green,
        ),
      ),
    );
  }

  Widget _stack() {
    return new Stack(
      alignment: new Alignment(0.6, 0.6),
      children: <Widget>[
        new Align(
          alignment: FractionalOffset.center,
          child: new Image.network(
            //加载网络图片
            'http://h.hiphotos.baidu.com/image/pic/item/21a4462309f790525fe7185100f3d7ca7acbd5e1.jpg',
            height: 300.0,
            width: 300.0,
            repeat: ImageRepeat.repeat, //图片重复方式
          ),
        ),
        new Opacity(
          opacity: 0.5, //不透明度
          child: new Container(
            width: 300.0,
            height: 400.0,
            color: Colors.blue,
          ),
        ),
        new Opacity(
          opacity: 0.3,
          child: new Container(
            width: 200.0,
            height: 200.0,
            color: Colors.red,
          ),
        ),
      ],
    );
  }

  Widget _stack1() {
    return new Stack(
      alignment: new Alignment(0.6, 0.6),
      children: <Widget>[
        // new SizedBox(height: 20.0),
        new Stack(
          alignment: const FractionalOffset(0.9, 0.1), //方法一
          children: <Widget>[
            new Image(
              image: new AssetImage("images/a1.jpg"),
              width: 300.0,
              height: 200.0,
              fit: BoxFit.cover,
            ),
            new Opacity(
              opacity: 0.8,
              child: new Image(
                image: new AssetImage("images/a2.jpg"),
                width: 200.0,
                height: 150.0,
                fit: BoxFit.cover,
              ),
            ),
            new GestureDetector(
              onTap: () {},
              child: new Icon(Icons.share, color: Colors.white),
            ),
          ],
        ),
        // new SizedBox(height: 20.0),
        // new Stack(
        //   children: <Widget>[
        //     new Image(
        //       image: new AssetImage("images/a3.jpg"),
        //       width: 300.0,
        //       height: 200.0,
        //       fit: BoxFit.cover,
        //     ),
        //     new Positioned(
        //       //方法二
        //       right: 15.0,
        //       top: 15.0,
        //       child: new Icon(
        //         Icons.share,
        //         color: Colors.white,
        //       ),
        //     ),
        //   ],
        // )
      ],
    );
  }
}
