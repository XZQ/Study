import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

//https://juejin.im/post/5bea43ade51d45544844010a
//https://juejin.im/post/5dc5035e51882558fd75dd51
class NestScrollView extends StatefulWidget {
  @override
  _NestScrollViewState createState() => _NestScrollViewState();
}

Widget _timeTabBarItem(String title) {
  return Tab(
      child: Text(
    title,
    style: TextStyle(color: Colors.white, fontSize: 14),
  ));
}

class _NestScrollViewState extends State<NestScrollView> with SingleTickerProviderStateMixin {
  //
  TabController tabController;

  List<Tab> timeTabs = <Tab>[
    _timeTabBarItem("10:00"),
    _timeTabBarItem("13:00"),
    _timeTabBarItem("15:00"),
    _timeTabBarItem("17:00"),
    _timeTabBarItem("19:00"),
    _timeTabBarItem("21:00"),
  ];

  @override
  void initState() {
    super.initState();
    //
    tabController = new TabController(vsync: this, initialIndex: 0, length: timeTabs.length);
//
    tabController.animation.addListener(() {
      setState(() {});
    });
  }

  @override
  void dispose() {
    tabController.dispose();
    super.dispose();
  }

  Widget _timeSelection() {
    double width = MediaQuery.of(context).size.width;
    return Stack(
      alignment: Alignment.topLeft,
      children: <Widget>[
        Container(
          height: 55,
        ),
        Container(
          height: 55 - 5.0,
          color: Colors.black,
        ),
        Positioned(
          left: tabController.animation.value * width / 6,
          width: width / 6,
          height: 55,
          child: Image.asset(
            "images/time_selected_bg.png",
            fit: BoxFit.fill,
          ),
        ),
        TabBar(
          labelPadding: EdgeInsets.all(0),
          tabs: timeTabs,
          controller: tabController,
          isScrollable: false,
          indicatorColor: Colors.transparent,
        )
      ],
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        centerTitle: true,
      ),
      body: Column(
        children: <Widget>[
          _timeSelection(),
          Expanded(
            child: TabBarView(
              controller: tabController,
              children: <Widget>[
                Image.asset(
                  "images/a1.jpg",
                  fit: BoxFit.cover,
                  width: MediaQuery.of(context).size.width,
                  height: 100,
                ),
                Image.asset(
                  "images/a2.jpg",
                  fit: BoxFit.cover,
                  width: MediaQuery.of(context).size.width,
                  height: 100,
                ),
                Image.asset(
                  "images/a3.jpg",
                  fit: BoxFit.cover,
                  width: MediaQuery.of(context).size.width,
                  height: 100,
                ),
                Image.asset(
                  "images/a4.jpg",
                  fit: BoxFit.cover,
                  width: MediaQuery.of(context).size.width,
                  height: 100,
                ),
                Image.asset(
                  "images/a5.jpg",
                  fit: BoxFit.cover,
                  width: MediaQuery.of(context).size.width,
                  height: 100,
                ),
                Image.asset(
                  "images/img.jpg",
                  fit: BoxFit.cover,
                  width: MediaQuery.of(context).size.width,
                  height: 100,
                ),
              ],
            ),
          )
        ],
      ),
    );
  }
}
