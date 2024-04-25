import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:wechat/tools/ThemeColors.dart';

import 'ListviewDemo.dart';
import 'class_bean.dart';

class ListViewMain extends StatefulWidget {
  @override
  _ListViewMainState createState() => _ListViewMainState();
}

class _ListViewMainState extends State<ListViewMain> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('ListView', style: TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
        iconTheme: ThemeData.light().primaryIconTheme,
      ),
      body: Center(
        child: Column(
          children: <Widget>[
            SizedBox(height: 10),
            CupertinoButton(
              child: Text('dismiss模式'),
              color: Colors.blue,
              disabledColor: Colors.grey,
              padding: EdgeInsets.all(8),
              minSize: 40,
              pressedOpacity: 0.8,
              onPressed: () {
                Navigator.push(
                    context,
                    new MaterialPageRoute(
                        builder: (ctx) => ListviewDemo(),
                        settings:
                            RouteSettings(arguments: ClassBean("XZQ", 1))));
              },
              borderRadius: BorderRadius.all(Radius.circular(8.0)),
            ),
            SizedBox(height: 10),
            CupertinoButton(
              child: Text('builder模式'),
              color: Colors.blue,
              disabledColor: Colors.grey,
              padding: EdgeInsets.all(8),
              minSize: 40,
              pressedOpacity: 0.8,
              onPressed: () {
                Navigator.push(
                    context,
                    new MaterialPageRoute(
                        builder: (ctx) => ListviewDemo(),
                        settings:
                            RouteSettings(arguments: ClassBean("XZQ", 2))));
              },
              borderRadius: BorderRadius.all(Radius.circular(8.0)),
            ),
            SizedBox(height: 10),
            CupertinoButton(
              child: Text('separated模式'),
              color: Colors.blue,
              disabledColor: Colors.grey,
              padding: EdgeInsets.all(8),
              minSize: 40,
              pressedOpacity: 0.8,
              onPressed: () {
                Navigator.push(
                    context,
                    new MaterialPageRoute(
                        builder: (ctx) => ListviewDemo(),
                        settings:
                            RouteSettings(arguments: ClassBean("XZQ", 3))));
              },
              borderRadius: BorderRadius.all(Radius.circular(8.0)),
            ),
            SizedBox(height: 10),
            CupertinoButton(
              child: Text('default模式'),
              color: Colors.blue,
              disabledColor: Colors.grey,
              padding: EdgeInsets.all(8),
              minSize: 40,
              pressedOpacity: 0.8,
              onPressed: () {
                Navigator.push(
                    context,
                    new MaterialPageRoute(
                        builder: (ctx) => ListviewDemo(),
                        settings:
                            RouteSettings(arguments: ClassBean("XZQ", 4))));
              },
              borderRadius: BorderRadius.all(Radius.circular(8.0)),
            ),
            SizedBox(height: 10),
            CupertinoButton(
              child: Text('ListTile模式'),
              color: Colors.blue,
              disabledColor: Colors.grey,
              padding: EdgeInsets.all(8),
              minSize: 40,
              pressedOpacity: 0.8,
              onPressed: () {
                Navigator.push(
                    context,
                    new MaterialPageRoute(
                        builder: (ctx) => ListviewDemo(),
                        settings:
                            RouteSettings(arguments: ClassBean("XZQ", 5))));
              },
              borderRadius: BorderRadius.all(Radius.circular(8.0)),
            ),
            SizedBox(height: 10),
            CupertinoButton(
              child: Text('listViewLayoutBuilder模式'),
              color: Colors.blue,
              disabledColor: Colors.grey,
              padding: EdgeInsets.all(8),
              minSize: 40,
              pressedOpacity: 0.8,
              onPressed: () {
                Navigator.push(
                    context,
                    new MaterialPageRoute(
                        builder: (ctx) => ListviewDemo(),
                        settings:
                            RouteSettings(arguments: ClassBean("XZQ", 6))));
              },
              borderRadius: BorderRadius.all(Radius.circular(8.0)),
            ),
            SizedBox(height: 10),
            CupertinoButton(
              child: Text('listViewLayoutSeparated模式'),
              color: Colors.blue,
              disabledColor: Colors.grey,
              padding: EdgeInsets.all(8),
              minSize: 40,
              pressedOpacity: 0.8,
              onPressed: () {
                Navigator.push(
                    context,
                    new MaterialPageRoute(
                        builder: (ctx) => ListviewDemo(),
                        settings:
                            RouteSettings(arguments: ClassBean("XZQ", 7))));
              },
              borderRadius: BorderRadius.all(Radius.circular(8.0)),
            ),
            SizedBox(height: 10),
            CupertinoButton(
              child: Text('listViewLayoutCustom模式'),
              color: Colors.blue,
              disabledColor: Colors.grey,
              padding: EdgeInsets.all(8),
              minSize: 40,
              pressedOpacity: 0.8,
              onPressed: () {
                Navigator.push(
                    context,
                    new MaterialPageRoute(
                        builder: (ctx) => ListviewDemo(),
                        settings:
                            RouteSettings(arguments: ClassBean("XZQ", 8))));
              },
              borderRadius: BorderRadius.all(Radius.circular(8.0)),
            ),
          ],
        ),
      ),
    );
  }
}
