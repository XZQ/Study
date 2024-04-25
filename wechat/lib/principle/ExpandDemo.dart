import 'dart:math';

import 'package:flutter/material.dart';
import 'package:wechat/tools/ThemeColors.dart';

//https://www.jianshu.com/u/312aad1f1c8b
class ExpandDemo extends StatefulWidget {
  @override
  _ExpandDemoState createState() => _ExpandDemoState();
}

const Color default_color = const Color(0xFF999999);

class _ExpandDemoState extends State<ExpandDemo> {
  //正常文字
  var commonStyle = TextStyle(color: Colors.black, fontSize: 18);
//灰色较小文字
  var infoStyle = TextStyle(color: Color(0xff999999), fontSize: 13);

  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: new AppBar(
        title: new Text('布局', style: new TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
        elevation: 0.0,
      ),
      body: new Column(
        children: <Widget>[
          extensionRow(),
          rowAndColumn(),
          rowAndColumn2(),
          rowAndColumn3(),
        ],
      ),
    );
  }

  Widget rowAndColumn3() {
    return Container(
      height: 70,
      color: Colors.white,
      child: Row(
        crossAxisAlignment: CrossAxisAlignment.center,
        mainAxisAlignment: MainAxisAlignment.center,
        children: <Widget>[
          SizedBox(
              width: 20,
              height: 20,
              child: Stack(
                alignment: Alignment.center,
                children: <Widget>[
                  Image.asset(
                    "images/progress_load_logo.png",
                    width: 20,
                    height: 20,
                  ),
                  CircularProgressIndicator(
                    strokeWidth: 1,
                    valueColor: AlwaysStoppedAnimation(default_color),
                  )
                ],
              )),
          Padding(
            padding: EdgeInsets.only(left: 5),
          ),
          Text(
            "努力加载中...",
            style: TextStyle(color: Color(0xff999999), fontSize: 10),
          )
        ],
      ),
    );
  }

  Widget rowAndColumn2() {
    var bigStyle = TextStyle(
        color: Colors.black, fontSize: 20, fontWeight: FontWeight.bold);
    var btnStyle = TextStyle(color: Color(0xffffffff), fontSize: 13);
    var headImg3 = Image.asset(
      "images/xk.jpg",
      width: 50,
      height: 50,
    );
    var center3 = Column(
      mainAxisAlignment: MainAxisAlignment.center,
      crossAxisAlignment: CrossAxisAlignment.start,
      children: <Widget>[
        Text("京东到家", style: bigStyle),
        Row(
          children: <Widget>[
            Icon(Icons.next_week, size: 15),
            pd(Text("京东到家 | 便捷到家"), l: 5)
          ],
        ),
        Row(
          children: <Widget>[
            Icon(Icons.keyboard, size: 15),
            pd(Text("京东到家,一小时全城送达"), l: 5)
          ],
        ),
      ],
    );

//尾部的
    var end3 = Column(
      mainAxisAlignment: MainAxisAlignment.spaceBetween,
      crossAxisAlignment: CrossAxisAlignment.end,
      children: <Widget>[
        Row(
          children: <Widget>[
            Icon(
              Icons.language,
              size: 15,
            ),
            Icon(Icons.local_pharmacy, size: 15),
            Icon(Icons.person_pin_circle, size: 15)
          ],
        ),
        bg(
            pdhv(
                Text(
                  "编辑",
                  style: btnStyle,
                ),
                h: 10,
                v: 3),
            Colors.blueAccent),
      ],
    );

    return new Card(
      child: new Container(
          height: 95,
          color: Colors.white,
          child: new Row(
            children: <Widget>[
              pda(headImg3, 5),
              Expanded(child: pda(center3, 5)),
              pda(end3, 8),
            ],
          )),
    );
  }

  Widget rowAndColumn() {
    var head = Image.asset("images/img.jpg", width: 45, height: 45);
    var center2 = new Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      mainAxisAlignment: MainAxisAlignment.center,
      children: <Widget>[
        Text(
          "京东到家",
          style: commonStyle,
        ),
        Text(
          "京东到家 便捷到家",
          maxLines: 1,
          overflow: TextOverflow.ellipsis,
          style: infoStyle,
          textAlign: TextAlign.start,
        )
      ],
    );

    var end2 = Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: <Widget>[
        Text("10:45", style: infoStyle),
        Icon(
          Icons.visibility_off,
          size: 20,
          color: Color(0xff999999),
        )
      ],
    );
    return new Container(
        height: 70,
        color: Colors.grey[200],
        padding: EdgeInsets.all(5),
        child: new Row(
          children: <Widget>[
            Padding(child: head, padding: EdgeInsets.all(5)),
            Expanded(
                child: Padding(padding: EdgeInsets.all(5), child: center2)),
            Padding(child: end2, padding: EdgeInsets.only(right: 10)),
          ],
        ));
  }

  Widget extensionRow() {
    return new Container(
      color: Colors.grey[200],
      padding: EdgeInsets.all(15),
      child: new Row(
        children: <Widget>[
          Icon(
            Icons.extension,
            color: Colors.blue,
          ),
          new Expanded(
            child: new Padding(
              padding: EdgeInsets.only(left: 20),
              child: Text(
                "京东到家",
                style: TextStyle(fontSize: 18),
              ),
            ),
          ),
          Icon(Icons.arrow_forward),
        ],
      ),
    );
  }

  pd(Widget w, {double l, double t, double r, double b}) {
    return Padding(
      child: w,
      padding: EdgeInsets.fromLTRB(l ?? 0, t ?? 0, r ?? 0, b ?? 0),
    );
  }

//全部padding
  pda(Widget w, double a) {
    return Padding(
      child: w,
      padding: EdgeInsets.all(a),
    );
  }

//水平、竖直的两个padding
  pdhv(Widget w, {double h, double v}) {
    return Padding(
      child: w,
      padding: EdgeInsets.fromLTRB(h ?? 0, v ?? 0, h ?? 0, v ?? 0),
    );
  }

  bg(Widget w, [Color color]) {
    return Container(color: color ?? randomARGB(), child: w);
  }

  Color randomARGB() {
    Random random = new Random();
    int r = 30 + random.nextInt(200);
    int g = 30 + random.nextInt(200);
    int b = 30 + random.nextInt(200);
    int a = 50 + random.nextInt(200);
    return Color.fromARGB(a, r, g, b);
  }
}
