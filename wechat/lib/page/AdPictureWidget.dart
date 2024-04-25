import 'dart:async';

import 'package:dio/dio.dart';
import 'package:flutter/material.dart';
import 'package:wechat/bean/AdPicture.dart';
import 'package:wechat/tools/ThemeColors.dart';

class AdPictureWidget extends StatefulWidget {
  @override
  _AdPictureWidgetState createState() => _AdPictureWidgetState();
}

const timeout = const Duration(seconds: 3);

class _AdPictureWidgetState extends State<AdPictureWidget>
    with SingleTickerProviderStateMixin {
  TabController _tabController;
  PageController _pageController = PageController();
  Timer _timer;

  List _adPictures = [];
  int _index = 0;

  @override
  void initState() {
    _tabController = TabController(length: 0, vsync: this);
    _timer = Timer.periodic(timeout, _handleTimeout);
    loadAdPictures();
    super.initState();
  }

  @override
  void dispose() {
    _tabController.dispose();
    _timer.cancel();
    _pageController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: new AppBar(
        title: new Text('轮播', style: new TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
      ),
      body: new Stack(
        alignment: new Alignment(0.9, 0.1),
        children: <Widget>[
          PageView(
            children: _adPictures.map((json) {
              var adPicture = AdPicture.fromJson(json);
              return Image.network(
                adPicture.imageUrl,
                width: MediaQuery.of(context).size.width,
                height: 200.0,
              );
            }).toList(),
            onPageChanged: _onPageChanged,
            controller: _pageController,
          ),
          Align(
            alignment: Alignment(0.0, 0.5),
            child: TabPageSelector(
              color: Colors.white,
              selectedColor: Colors.black,
              controller: _tabController,
            ),
          ),
        ],
      ),
    );
  }

  _handleTimeout(Timer timer) {
    if (_adPictures.length - 2 != 0) {
      _index++;
      _pageController.animateToPage(
        _index % (_adPictures.length - 2),
        duration: Duration(milliseconds: 30),
        curve: Curves.fastOutSlowIn,
      );
    }
  }

  void _onPageChanged(int index) {
    _index = index;
    if (index == 0) {
      _tabController.animateTo(_tabController.length - 1);
      _pageController.jumpToPage(_adPictures.length - 2);
    } else if (index == _adPictures.length - 1) {
      _tabController.animateTo(0);
      _pageController.jumpToPage(1);
    } else {
      _tabController.animateTo(index - 1);
    }
  }

  void loadAdPictures() async {
    Dio dio = Dio();
    Response<List> response = await dio
        .get("http://www.wanandroid.com/tools/mockapi/2511/getAdPictures");

    List res = response.data;
    if (res.length != 0) {
      res.insert(0, res[res.length - 1]);
      res.add(res[1]);
      setState(() {
        _adPictures = res;
        _pageController.jumpToPage(1);
        _tabController =
            TabController(length: _adPictures.length - 2, vsync: this);
      });
    }
  }
}
