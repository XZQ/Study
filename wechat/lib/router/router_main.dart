import 'package:flutter/material.dart';
import 'package:wechat/router/page1.dart';
import 'package:wechat/router/page2.dart';
import 'package:wechat/router/router_app.dart';
import 'package:wechat/tools/ThemeColors.dart';

class RouterMain extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Router Main',
      theme: ThemeData(primaryColor: ThemeData.light().accentColor),
      home: RouterFulMain(),
      routes: <String, WidgetBuilder>{'page2': (_) => Page2()},
      debugShowCheckedModeBanner: false,
    );
  }
}

class RouterFulMain extends StatefulWidget {
  @override
  _RouterFulMainState createState() => _RouterFulMainState();
}

class _RouterFulMainState extends State<RouterFulMain> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('RouterFulMain', style: new TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
        elevation: 0.0,
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: <Widget>[
            MaterialButton(
              child: Text("Page1"),
              onPressed: () {
                Navigator.push(
                    context, new MaterialPageRoute(builder: (ctx) => Page1()));
              },
              textTheme: ButtonTextTheme.normal,
              textColor: Colors.red,
              color: Color(0xFF82B1FF),
              minWidth: 120,
            ),
            MaterialButton(
              child: Text("RouterApp"),
              onPressed: () {
                //静态路由，必须在StatelessWidget提前声明，不可传参
                // Navigator.of(context).pushNamed("page2");
                //动态路由
                Navigator.push(context,
                    new MaterialPageRoute(builder: (ctx) => RouterApp()));
              },
              textTheme: ButtonTextTheme.normal,
              textColor: Colors.blue,
              disabledTextColor: Colors.red,
              color: Color(0xFF82B1FF),
              minWidth: 120,
            ),
          ],
        ),
      ),
    );
    ;
  }
}
