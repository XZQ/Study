import 'package:flutter/material.dart';

import 'package:flutter_refresh/flutter_refresh.dart';

// https://github.com/xuelongqy/flutter_easyrefresh
class Shop extends StatefulWidget {
  // Shop({Key key, this.title}) : super(key: key);

  createState() => new ShopState();
}

class ShopState extends State<Shop> {
  int _itemCount;

  Widget _itemBuilder(BuildContext context, int index) {
    return new Padding(
      key: new Key(index.toString()),
      padding: new EdgeInsets.all(10.0),
      child: new Text(
        "Orered data:$index",
        style: new TextStyle(fontSize: 14.0),
      ),
    );
  }

  @override
  void initState() {
    _itemCount = 20;
    super.initState();
  }

  Future<Null> onFooterRefresh() {
    return new Future.delayed(new Duration(seconds: 2), () {
      setState(() {
        _itemCount += 20;
      });
    });
  }

  Future<Null> onHeaderRefresh() {
    return new Future.delayed(new Duration(seconds: 2), () {
      setState(() {
        _itemCount = 20;
      });
    });
  }

  @override
  Widget build(BuildContext context) {
    return new Scaffold(
        body: new SafeArea(
            child: new Refresh(
      onFooterRefresh: onFooterRefresh,
      onHeaderRefresh: onHeaderRefresh,
      child: new ListView.builder(
        itemBuilder: _itemBuilder,
        itemCount: _itemCount,
      ),
    )));
  }
}

//  body: new ListView(
//         children: <Widget>[
//           new Container(
//             padding: const EdgeInsets.only(top: 20.0),
//             child: new Container(
//               height: 80.0,
//               child: new ListTile(
//                 leading: new Image.asset("images/xk.jpg"),
//                 title: new Text("Tony"),
//                 subtitle: new Text("微信号：ty001"),
//                 trailing: new Icon(Icons.fullscreen),
//               ),
//               color: Colors.white,
//             ),
//             color: Colors.grey[200],
//           ),
//           DecoratedBox(
//               decoration: BoxDecoration(
//                   gradient: LinearGradient(
//                       colors: [Colors.red, Colors.orange[700]]), //背景渐变
//                   borderRadius: BorderRadius.circular(3.0), //3像素圆角
//                   boxShadow: [
//                     //阴影
//                     BoxShadow(
//                         color: Colors.black54,
//                         offset: Offset(2.0, 2.0),
//                         blurRadius: 4.0)
//                   ]),
//               child: Padding(
//                 padding: EdgeInsets.symmetric(horizontal: 80.0, vertical: 18.0),
//                 child: Text(
//                   "Login",
//                   style: TextStyle(color: Colors.white),
//                 ),
//               )),
//           new Container(
//             padding: const EdgeInsets.only(top: 20.0),
//             child: new Container(
//               child: new ListTile(
//                 leading: new Icon(Icons.call_to_action),
//                 title: new Text("钱包"),
//               ),
//               color: Colors.white,
//               height: 50.0,
//             ),
//             color: Colors.grey[200],
//           ),
//           new Container(
//             padding: const EdgeInsets.only(top: 20.0),
//             child: new Container(
//               child: new ListTile(
//                 leading: new Icon(Icons.dashboard),
//                 title: new Text("收藏"),
//               ),
//               color: Colors.white,
//               height: 50.0,
//             ),
//             color: Colors.grey[200],
//           ),
//           new Container(
//             child: new ListTile(
//               leading: new Icon(Icons.photo),
//               title: new Text("相册"),
//             ),
//             color: Colors.white,
//             height: 50.0,
//           ),
//           new Container(
//             child: new ListTile(
//               leading: new Icon(Icons.credit_card),
//               title: new Text("卡包"),
//             ),
//             color: Colors.white,
//             height: 50.0,
//           ),
//           new Container(
//             child: new ListTile(
//               leading: new Icon(Icons.tag_faces),
//               title: new Text("表情"),
//             ),
//             color: Colors.white,
//             height: 50.0,
//           ),
//           new Container(
//             padding: const EdgeInsets.only(top: 20.0),
//             child: new Container(
//               child: new ListTile(
//                 leading: new Icon(Icons.settings),
//                 title: new Text("设置"),
//               ),
//               color: Colors.white,
//               height: 50.0,
//             ),
//             color: Colors.grey[200],
//           ),
//         ],
//       ),
