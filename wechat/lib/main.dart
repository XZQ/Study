import 'dart:io';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:wechat/bean/event/ThemeEvent.dart';
import 'package:wechat/mainpage/Discover.dart';
import 'package:wechat/mainpage/Home.dart';
import 'package:wechat/mainpage/Mine.dart';
import 'package:wechat/mainpage/Order.dart';
import 'package:wechat/mainpage/Shop.dart';
import 'package:wechat/tools/Constants.dart';
import 'package:wechat/tools/DataUtils.dart';
import 'package:wechat/tools/ThemeColors.dart';

void main() {
  if (Platform.isAndroid) {
    SystemUiOverlayStyle systemUiOverlayStyle = SystemUiOverlayStyle(statusBarColor: Colors.transparent);
    SystemChrome.setSystemUIOverlayStyle(systemUiOverlayStyle);
  }
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        primaryColor: ThemeColors.currentColorTheme,
      ),
      home: Center(
        child: RandomWords(),
      ),
    );
  }
}

class RandomWords extends StatefulWidget {
  createState() => RandomWordsState();
}

class RandomWordsState extends State<RandomWords> {
  Color themeColor = ThemeColors.currentColorTheme;
  int _tabIndex = 0;
  var _navTitles = ['首页', '发现', '购物车', '订单', '我的'];
  var _tabImages;
  var _pageList;
  var _body;

  /// 根据路径获取图片
  Image getTabImage(final String path) {
    return Image.asset(path, width: 20, height: 20);
  }

  Image getImage(int index) {
    if (_tabIndex == index) {
      return _tabImages[index][1];
    } else {
      return _tabImages[index][0];
    }
  }

  Text getTabTitle(int curIndex) {
    if (curIndex == _tabIndex) {
      return Text(_navTitles[curIndex], style: TextStyle(fontSize: 12.0, color: Colors.green));
    } else {
      return Text(_navTitles[curIndex], style: TextStyle(fontSize: 12.0, color: Colors.black));
    }
  }

  ///初始化数据
  void initData() {
    _tabImages = [
      [getTabImage('images/pdj_my_category_normal.png'), getTabImage('images/pdj_my_category_select.png')],
      [getTabImage('images/pdj_find_default.png'), getTabImage('images/pdj_find_selected.png')],
      [getTabImage('images/pdj_cart_default.png'), getTabImage('images/pdj_cart_selected.png')],
      [getTabImage('images/pdj_order_default.png'), getTabImage('images/pdj_order_selected.png')],
      [getTabImage('images/pdj_my_default.png'), getTabImage('images/pdj_my_selected.png')],
    ];
    _pageList = [
      Home(),
      Discover(),
      Shop(),
      Order(),
      MineWidget(),
    ];

    _body = IndexedStack(
      children: _pageList,
      index: _tabIndex,
    );
  }

  @override
  Widget build(BuildContext context) {
    initData();
    return Scaffold(
      appBar: AppBar(
        centerTitle: true,
        title: Text("京东到家", style: TextStyle(color: Colors.white)),
        backgroundColor: themeColor,
        elevation: 0.0,
      ),
      body: _body,
      bottomNavigationBar: CupertinoTabBar(
        items: <BottomNavigationBarItem>[
          // ignore: deprecated_member_use
          BottomNavigationBarItem(icon: getImage(0), title: getTabTitle(0)),
          // ignore: deprecated_member_use
          BottomNavigationBarItem(icon: getImage(1), title: getTabTitle(1)),
          BottomNavigationBarItem(icon: getImage(2), title: getTabTitle(2)),
          // ignore: deprecated_member_use
          BottomNavigationBarItem(icon: getImage(3), title: getTabTitle(3)),
          BottomNavigationBarItem(icon: getImage(4), title: getTabTitle(4)),
        ],
        currentIndex: _tabIndex, //默认第一个
        onTap: (index) {
          setState(() {
            _tabIndex = index;
          });
        },
      ),
    );
  }

  @override
  void initState() {
    super.initState();
    DataUtils.getColorThemeIndex().then((index) {
      if (index != null) {
        ThemeColors.currentColorTheme = ThemeColors.supportColors[index];
        Constants.eventBus.fire(ThemeEvent(ThemeColors.supportColors[index]));
      }
    });

    Constants.eventBus.on<ThemeEvent>().listen((event) {
      setState(() {
        themeColor = event.color;
      });
    });
  }
}
