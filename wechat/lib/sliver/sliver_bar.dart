import 'package:flutter/material.dart';
import 'package:wechat/sliver/sticky_tabbar_delegate.dart';

//https://blog.csdn.net/villa_mou/article/details/85123152
//https://segmentfault.com/a/1190000019902201
//https://juejin.im/post/5dca12dae51d45309f353f43?utm_source=gold_browser_extension
class SliverBar extends StatefulWidget {
  @override
  _SliverBarState createState() => _SliverBarState();
}

class _SliverBarState extends State<SliverBar> with SingleTickerProviderStateMixin {
  TabController tabController;

  @override
  void initState() {
    super.initState();
    tabController = TabController(length: 2, vsync: this);
  }

  @override
  void dispose() {
    tabController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: CustomScrollView(
        slivers: <Widget>[
          SliverAppBar(
            pinned: true,
            elevation: 0,
            expandedHeight: 250,
            flexibleSpace: FlexibleSpaceBar(
              title: Text("欢迎你"),
              background: Image.network(
                'http://img1.mukewang.com/5c18cf540001ac8206000338.jpg',
                fit: BoxFit.cover,
              ),
            ),
          ),
          // SliverToBoxAdapter(
          //   child: Padding(
          //     padding: EdgeInsets.symmetric(vertical: 16),
          //     child: Text(
          //       "XZQ",
          //       textAlign: TextAlign.center,
          //       style: TextStyle(fontSize: 20),
          //     ),
          //   ),
          // ),
          SliverPersistentHeader(
            pinned: true,
            delegate: StickyTabBarDelegate(
              child: TabBar(
                labelColor: Colors.black,
                controller: this.tabController,
                tabs: <Widget>[
                  Tab(text: 'Home'),
                  Tab(text: 'Profile'),
                ],
              ),
            ),
          ),
          // https://www.jianshu.com/p/ca79eb54a356
          SliverFillRemaining(
            child: TabBarView(
              controller: this.tabController,
              children: <Widget>[
                Center(child: Text('主页')),
                Center(child: Text('发现')),
              ],
            ),
          ),
        ],
      ),
    );
  }
}
