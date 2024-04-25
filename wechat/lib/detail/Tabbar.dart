import 'package:flutter/material.dart';
import 'package:wechat/tools/ThemeColors.dart';

class Tabbar extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    List<String> mytabs = <String>[
      '微软',
      '苹果',
      '谷歌',
      '阿里',
    ];

    return DefaultTabController(
      length: mytabs.length,
      child: Scaffold(
        appBar: AppBar(
          bottom: TabBar(
            isScrollable: true,
            indicatorColor: ThemeColors.currentColorTheme,
            indicatorSize: TabBarIndicatorSize.label,
            labelColor: Colors.white,
            labelStyle: TextStyle(fontSize: 14.0),
            unselectedLabelColor: Colors.white54,
            indicatorWeight: 2.0,
            indicatorPadding: EdgeInsets.only(bottom: 5.0),
            unselectedLabelStyle: TextStyle(fontSize: 14.0),
            tabs: mytabs.map((String str) {
              return Tab(
                text: str,
              );
            }).toList(),
          ),
        ),
        body: ListView.builder(
            itemCount: 20,
            itemBuilder: (context, index) {
              return ListTile(
                title: Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: <Widget>[
                    Text(
                      "今天",
                      style: TextStyle(color: Colors.black, fontSize: 16.0),
                    ),
                    Text("2.02", style: TextStyle(color: Colors.green, fontSize: 22.0, fontWeight: FontWeight.w500)),
                  ],
                ),
                subtitle: Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: <Widget>[
                    Text(
                      "02:20",
                      style: TextStyle(color: Colors.black, fontSize: 14.0),
                    ),
                    Text(
                      "银行卡提现",
                      style: TextStyle(color: Colors.black, fontSize: 14.0),
                    ),
                  ],
                ),
              );
            }),
      ),
    );
  }
}
