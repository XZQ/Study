import 'package:flutter/material.dart';
import 'package:wechat/animation/AnimationRoot.dart';
import 'package:wechat/page/AdPictureWidget.dart';
import 'package:wechat/page/BottomLoading.dart';
import 'package:wechat/page/StackWidger.dart';
import 'package:wechat/page/StateManager.dart';
import 'package:wechat/page/Widgets.dart';
import 'package:wechat/setting/MyTheme.dart';
import 'package:wechat/view/MyWidget.dart';
// import 'package:wechat/tools/RouterPage.dart';

//遗留问题，使用MaterialApp后，静态路由，跳转底部不消失

// class Mine extends StatelessWidget {
//   @override
//   Widget build(BuildContext context) {
//     return new MaterialApp(
//       debugShowCheckedModeBanner: false,
//       routes: <String, WidgetBuilder>{
//         RouterPage.MYTHEME: (BuildContext context) => new MyTheme(),
//         RouterPage.ANIMATION: (BuildContext context) => new AnimationOne(),
//         RouterPage.BOTTOM: (BuildContext context) => new BottomLoading(),
//         RouterPage.WRAPSTATEL: (_) => new WrapStatelessWidget(),
//       },
//       home: new MineWidget(),
//     );
//   }
// }

// class MineWidget extends StatelessWidget {
//   var parentContext;
//   MineWidget(this.parentContext);
//   @override
//   Widget build(BuildContext context) {
//     return _Sacffold(this.parentContext);
//   }
// }
class MineWidget extends StatefulWidget {
  createState() => MineState();
}

class MineState extends State<MineWidget> {
  var devider = 0.5;

  @override
  Widget build(BuildContext context) {
    return _Sacffold(context);
  }
}

Widget _Sacffold(BuildContext context) {
  return new Scaffold(
    body: new ListView(
      children: <Widget>[
        new Row(
          mainAxisAlignment: MainAxisAlignment.start,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: <Widget>[
            new Container(
              margin: EdgeInsets.fromLTRB(20, 10, 10.0, 10),
              child: new ClipRRect(
                borderRadius: BorderRadius.circular(6.0),
                child: Image.asset(
                  "images/xzq.jpg",
                  width: 66,
                  height: 66,
                ),
              ),
            ),
            new Container(
              height: 80.0,
              child: new Column(
                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                crossAxisAlignment: CrossAxisAlignment.start,
                children: <Widget>[
                  new Text(
                    "夏志强",
                    style: new TextStyle(
                        color: Colors.black,
                        // decoration: TextDecoration.lineThrough,
                        fontSize: 21,
                        fontWeight: FontWeight.w900),
                  ),
                  new Row(
                    children: <Widget>[
                      new Container(
                        child: new Text(
                          "微信号:xcmdkmdx",
                          style: new TextStyle(
                              color: Colors.grey[400],
                              fontSize: 14.0,
                              fontWeight: FontWeight.w900),
                        ),
                      ),
                    ],
                  ),
                ],
              ),
            ),
          ],
        ),
        new Container(
          padding: const EdgeInsets.only(top: 10.0),
          child: new Container(
            height: 50.0,
            child: new ListTile(
              leading: new Icon(Icons.camera),
              title: new Text("主题"),
              onTap: () {
                // Navigator.pushNamed(context, RouterPage.MYTHEME);
                Navigator.push(context, new MaterialPageRoute(builder: (ctx) {
                  return new MyTheme();
                }));
              },
            ),
            color: Colors.white,
          ),
          color: Colors.grey[200],
        ),
        new Container(
          padding: const EdgeInsets.only(top: 0.5),
          child: new Container(
            height: 50.0,
            child: new ListTile(
              leading: new Icon(Icons.hot_tub),
              title: new Text("底部Loading"),
              onTap: () {
                // Navigator.pushNamed(context, RouterPage.BOTTOM);
                Navigator.push(context, new MaterialPageRoute(builder: (ctx) {
                  return new BottomLoading();
                }));
              },
            ),
            color: Colors.white,
          ),
          color: Colors.grey[200],
        ),
        new Container(
          padding: const EdgeInsets.only(top: 0.5),
          child: new Container(
            height: 50.0,
            child: new ListTile(
              leading: new Icon(Icons.airplanemode_inactive),
              title: new Text("动画"),
              onTap: () {
                // Navigator.pushNamed(context, RouterPage.ANIMATION);
                Navigator.push(context, new MaterialPageRoute(builder: (ctx) {
                  return new AnimationRoot();
                }));
              },
            ),
            color: Colors.white,
          ),
          color: Colors.grey[200],
        ),
        new Container(
          padding: const EdgeInsets.only(top: 0.5),
          child: new Container(
            height: 50.0,
            child: new ListTile(
              leading: new Icon(Icons.wb_cloudy),
              title: new Text("控件"),
              onTap: () {
                Navigator.push(context, new MaterialPageRoute(builder: (ctx) {
                  return new Widgets();
                }));
              },
            ),
            color: Colors.white,
          ),
          color: Colors.grey[200],
        ),
        new Container(
          padding: const EdgeInsets.only(top: 0.5),
          child: new Container(
            height: 50.0,
            child: new ListTile(
              leading: new Icon(Icons.label_important),
              title: new Text("轮播"),
              onTap: () {
                Navigator.push(context, new MaterialPageRoute(builder: (ctx) {
                  return new AdPictureWidget();
                }));
              },
            ),
            color: Colors.white,
          ),
          color: Colors.grey[200],
        ),
        new Container(
          padding: const EdgeInsets.only(top: 0.5),
          child: new Container(
            height: 50.0,
            child: new ListTile(
              leading: new Icon(Icons.system_update),
              title: new Text("状态管理"),
              onTap: () {
                Navigator.push(context, new MaterialPageRoute(builder: (ctx) {
                  return new StateManager();
                }));
              },
            ),
            color: Colors.white,
          ),
          color: Colors.grey[200],
        ),
        _stackWidget(context),
        _MyWidget(context),
      ],
    ),
  );
}

//  TurnBox
Widget _MyWidget(BuildContext context) {
  return new Container(
    padding: const EdgeInsets.only(top: 0.5),
    child: new Container(
      height: 50.0,
      child: new ListTile(
        leading: new Icon(Icons.refresh),
        title: new Text("自定View"),
        onTap: () {
          Navigator.push(context, new MaterialPageRoute(builder: (ctx) {
            return new MyWidget();
          }));
        },
      ),
      color: Colors.white,
    ),
    color: Colors.grey[200],
  );
}

// Stack Widger
Widget _stackWidget(BuildContext context) {
  return new Container(
    padding: const EdgeInsets.only(top: 0.5),
    child: new Container(
      height: 50.0,
      child: new ListTile(
        leading: new Icon(Icons.stay_current_landscape),
        title: new Text("Stack"),
        onTap: () {
          Navigator.push(context, new MaterialPageRoute(builder: (ctx) {
            return new StackWidger();
          }));
        },
      ),
      color: Colors.white,
    ),
    color: Colors.grey[200],
  );
}
