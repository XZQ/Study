import 'package:flutter/material.dart';
import 'package:wechat/async/future_builder.dart';
import 'package:wechat/basewidget/tabbar.dart';
import 'package:wechat/principle/MixinTest.dart';
import 'package:wechat/scoller/animation_demo.dart';
import 'package:wechat/scoller/notification_main.dart';
import 'package:wechat/scoller/notification_test.dart';
import 'package:wechat/scoller/scroll_test.dart';
import 'package:wechat/search/search_all.dart';
import 'package:wechat/sliver/sliver_bar.dart';
import 'package:wechat/sliver/sliver_header.dart';

import '../sliver/nestscroll_view.dart';

class Order extends StatefulWidget {
  @override
  _OrderState createState() => _OrderState();
}

class _OrderState extends State<Order> {
  List<Widget> _list = [];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        child: gridViewCount(),
      ),
    );
  }

  //GridView.count
  Widget gridViewCount() {
    return GridView.count(
      crossAxisSpacing: 5.0,
      mainAxisSpacing: 5.0,
      padding: EdgeInsets.fromLTRB(5.0, 10, 5, 10),
      crossAxisCount: 4,
      childAspectRatio: 2.0,
      children: getWidgetLists(),
    );
  }

  List<Widget> getWidgetLists() {
    _list.add(_notify(context));
    _list.add(_scroll(context));
    _list.add(_notificationTest(context));
    _list.add(_animationTest(context));
    _list.add(_sliverTest(context));
    _list.add(_sliverHeader(context));
    _list.add(_nestScrollview(context));
    _list.add(_nestScrollheader(context));
    _list.add(_future(context));
    _list.add(_tabbar(context));
    _list.add(_search(context));
    _list.add(_mixin(context));
    return _list;
  }

  Widget _mixin(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.push(context, MaterialPageRoute(builder: (ctx) => MixinTest()));
      },
      child: getContainer('Mixin'),
    );
  }

  Widget _search(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.push(context, MaterialPageRoute(builder: (ctx) => SearchAll()));
      },
      child: getContainer('Search'),
    );
  }

  Widget _tabbar(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.push(context, MaterialPageRoute(builder: (ctx) => Tabbar()));
      },
      child: getContainer('Tabbar'),
    );
  }

  Widget _future(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.push(context, MaterialPageRoute(builder: (ctx) => FutureMain()));
      },
      child: getContainer('Future'),
    );
  }

  Widget _nestScrollheader(BuildContext context) {
    return GestureDetector(
      onTap: () {
        // Navigator.push(
        //     context, MaterialPageRoute(builder: (ctx) => NestScrollView()));
      },
      child: getContainer('scrollheader'),
    );
  }

  Widget _nestScrollview(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.push(context, MaterialPageRoute(builder: (ctx) => NestScrollView()));
      },
      child: getContainer('nestScroll'),
    );
  }

  Widget _sliverHeader(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.push(context, MaterialPageRoute(builder: (ctx) => SliverHeader()));
      },
      child: getContainer('Header'),
    );
  }

  Widget getContainer(String title) {
    return Container(
      decoration: getBoxDecoration(),
      alignment: Alignment.center,
      child: Text(title, style: getTextStytle()),
    );
  }

  TextStyle getTextStytle() {
    return TextStyle(color: Colors.blue, fontWeight: FontWeight.normal, decoration: TextDecoration.none, fontSize: 13.0);
  }

  BoxDecoration getBoxDecoration() {
    return BoxDecoration(
      border: Border.all(width: 1.0, color: Colors.blueAccent),
      borderRadius: BorderRadius.all(Radius.circular(5.0)),
    );
  }

  Widget _sliverTest(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.push(context, MaterialPageRoute(builder: (ctx) => SliverBar()));
      },
      child: getContainer("Sliver"),
    );
  }

  Widget _animationTest(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.push(context, MaterialPageRoute(builder: (ctx) => AnimationDemo()));
      },
      child: getContainer("Animation"),
    );
  }

  Widget _notificationTest(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.push(context, MaterialPageRoute(builder: (ctx) => NotificationTest()));
      },
      child: getContainer("Nofication"),
    );
  }

  Widget _scroll(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.push(context, MaterialPageRoute(builder: (ctx) => ScrollTest()));
      },
      child: getContainer("Scroll"),
    );
  }

  Widget _notify(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.push(context, MaterialPageRoute(builder: (ctx) => NotificationMain()));
      },
      child: getContainer("Notify"),
    );
  }
}
