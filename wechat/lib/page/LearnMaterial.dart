import 'package:flutter/material.dart';
import 'package:wechat/tools/ThemeColors.dart';

class LearnMaterial extends StatefulWidget {
  @override
  _LearnMaterialState createState() => _LearnMaterialState();
}

class _LearnMaterialState extends State<LearnMaterial> {
  @override
  Widget build(BuildContext context) {
    return new Scaffold(
        appBar: new AppBar(
          elevation: 0.0,
          title: new Text('Stack', style: new TextStyle(color: Colors.white)),
          backgroundColor: ThemeColors.currentColorTheme,
        ),
        body: new Column(
          children: <Widget>[
            new Container(
              padding: const EdgeInsets.only(top: 10.0),
              child: new Material(
                color: Colors.blueAccent,
                shape: new BeveledRectangleBorder(
                  side: new BorderSide(
                    width: 1.0,
                    color: Colors.blueAccent,
                    style: BorderStyle.none,
                  ),
                  borderRadius: new BorderRadius.circular(50.0),
                ),
                child: new Container(
                  padding: EdgeInsets.all(20.0),
                  child: new Text('斜角矩形边框'),
                ),
              ),
            ),
            new Container(
              padding: const EdgeInsets.only(top: 10.0),
              child: new Material(
                color: Colors.blueAccent,
                shape: new BeveledRectangleBorder(
                  side: new BorderSide(
                    width: 1.0,
                    color: Colors.blueAccent,
                    style: BorderStyle.none,
                  ),
                  borderRadius: new BorderRadius.circular(10.0),
                ),
                child: new Container(
                  padding: EdgeInsets.all(20.0),
                  child: new Text('斜角矩形边框'),
                ),
              ),
            ),
            new Container(
              padding: const EdgeInsets.only(top: 10.0),
              child: new Material(
                color: Colors.blueAccent,
                shape: new BorderDirectional(
                    start: new BorderSide(
                      color: Colors.yellow,
                      width: 10.0,
                    ),
                    top: new BorderSide(
                      color: Colors.deepOrange,
                      width: 10.0,
                    ),
                    end: new BorderSide(
                      color: Colors.black87,
                      width: 10.0,
                    ),
                    bottom: new BorderSide(
                      color: Colors.purpleAccent,
                      width: 10.0,
                    )),
                child: new Container(
                  padding: EdgeInsets.all(30.0),
                  child: new Text('多彩边框'),
                ),
              ),
            ),
            new Container(
              padding: const EdgeInsets.only(top: 10.0),
              child: new Material(
                color: Colors.blueAccent,
                shape: new CircleBorder(
                    side: new BorderSide(
                  color: Colors.yellow,
                  width: 10.0,
                )),
                child: new Container(
                  padding: EdgeInsets.all(50.0),
                  child: new Text('圆形边框'),
                ),
              ),
            ),
            new Container(
              padding: const EdgeInsets.only(top: 10.0),
              child: new Material(
                color: Colors.blueAccent,
                shape: new RoundedRectangleBorder(
                  side: new BorderSide(
                    color: Colors.purpleAccent,
                    width: 5.0,
                  ),
                  borderRadius: new BorderRadius.circular(
                      20.0), //如果[borderRadius]被指定，那么[type]属性不能是 [MaterialType.circle]。
                ),
                child: new Container(
                  padding: EdgeInsets.all(30.0),
                  child: new Text('圆角矩形'),
                ),
              ),
            ),
            new Container(
              padding: const EdgeInsets.only(top: 10.0),
              child: new Material(
                color: Colors.purpleAccent,
                elevation: 10.0,
                shadowColor: Colors.yellow,
                shape: new StadiumBorder(
                    side: new BorderSide(
                  color: Colors.brown,
                  width: 5.0,
                )),
                child: new Container(
                  padding: EdgeInsets.all(30.0),
                  child: new Text('体育场形状'),
                ),
              ),
            )
          ],
        ));
  }
}
