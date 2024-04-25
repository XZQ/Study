import 'package:flutter/material.dart';
import 'package:wechat/tools/ThemeColors.dart';

//https://blog.csdn.net/yuzhiqiang_1993/article/details/86496145
// https://www.jianshu.com/p/0ce74751d970
class BottomComponent extends StatefulWidget {
  @override
  _BottomCompontState createState() => _BottomCompontState();
}

class _BottomCompontState extends State<BottomComponent> {
  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: new AppBar(
        title: new Text('组件封装', style: new TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
      ),
      body: new Column(
        children: <Widget>[
          containerWidget(),
          Padding(padding: EdgeInsets.all(10)),
          assemableWidget(),
        ],
      ),
    );
  }

  //
  Widget containerWidget() {
    return new Container(
      height: 60.0,
      color: Colors.grey[200],
      child: new Row(
        mainAxisAlignment: MainAxisAlignment.spaceAround,
        children: <Widget>[
          new Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              new Icon(Icons.monetization_on, color: Colors.grey),
              new Text("赞赏", style: new TextStyle(color: Colors.grey))
            ],
          ),
          new Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              new Icon(Icons.comment, color: Colors.grey),
              new Text("评论", style: new TextStyle(color: Colors.grey))
            ],
          ),
          new Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              new Icon(Icons.favorite_border, color: Colors.grey),
              new Text("喜欢", style: new TextStyle(color: Colors.grey))
            ],
          ),
          new Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              new Icon(Icons.share, color: Colors.grey),
              new Text("分享", style: new TextStyle(color: Colors.grey))
            ],
          ),
        ],
      ),
    );
  }

  Widget assemableWidget() {
    return new Container(
      height: 60.0,
      color: Colors.grey[200],
      child: new Row(
        mainAxisAlignment: MainAxisAlignment.spaceAround,
        children: <Widget>[
          /**************************************************************************** */
          AssemableComponent(
            icons: Icons.monetization_on,
            btnName: "赞赏",
            color: Colors.grey,
          ),
          AssemableComponent(
            icons: Icons.comment,
            btnName: "评论",
            color: Colors.grey,
          ),
          AssemableComponent(
            icons: Icons.favorite_border,
            btnName: "喜欢",
            color: Colors.grey,
          ),
          AssemableComponent(
            icons: Icons.share,
            btnName: "分享",
            color: Colors.grey,
          ),
          /**************************************************************************** */
          // AssemableComponent(
          //   Icons.monetization_on,
          //   '赞赏',
          // ),
          // AssemableComponent(
          //   Icons.comment,
          //   '评论',
          // ),
          // AssemableComponent(
          //   Icons.favorite_border,
          //   '喜欢',
          // ),
          // AssemableComponent(
          //   Icons.share,
          //   '分享',
          // ),
          /**************************************************************************** */
        ],
      ),
    );
  }
}

class AssemableComponent extends StatefulWidget {
  final IconData icons;
  final MaterialColor color;
  final String btnName;

  AssemableComponent(
      {@required this.icons, @required this.btnName, @required this.color});

  // AssemableComponent(this.icons, this.btnName, {this.color = Colors.grey});

  @override
  _AssemableComponentState createState() => _AssemableComponentState();
}

class _AssemableComponentState extends State<AssemableComponent> {
  @override
  Widget build(BuildContext context) {
    return new Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: <Widget>[
        new Icon(widget.icons, color: widget.color),
        new Text(widget.btnName, style: new TextStyle(color: widget.color))
      ],
    );
  }
}
