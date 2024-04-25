import 'package:flutter/material.dart';
import 'package:wechat/state/bloc/global/global_mian.dart';
import 'package:wechat/state/bloc/rxdart/rxdart_main.dart';
import 'package:wechat/state/bloc/scoped/scopde_main.dart';
import 'package:wechat/tools/ThemeColors.dart';

//https://juejin.im/post/5bb6f344f265da0aa664d68a
//https://www.jianshu.com/p/e7e1bced6890
class BlocMain extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: new AppBar(
        title: new Text('Bloc', style: new TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
        iconTheme: ThemeData.light().primaryIconTheme,
      ),
      body: Center(
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.center,
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            MaterialButton(
              child: Text("GlobalMian"),
              onPressed: () {
                Navigator.push(context,
                    new MaterialPageRoute(builder: (ctx) => GlobalMian()));
              },
              textTheme: ButtonTextTheme.normal,
              textColor: Colors.red,
              color: Color(0xFF82B1FF),
              minWidth: 120,
            ),
            MaterialButton(
              child: Text("Scope"),
              onPressed: () {
                Navigator.push(context,
                    new MaterialPageRoute(builder: (ctx) => ScopdeMain()));
              },
              textTheme: ButtonTextTheme.normal,
              textColor: Colors.blue,
              disabledTextColor: Colors.red,
              color: Color(0xFF82B1FF),
              minWidth: 120,
            ),
            MaterialButton(
              child: Text("RxDart"),
              onPressed: () {
                Navigator.push(context,
                    new MaterialPageRoute(builder: (ctx) => RxdartMain()));
              },
              textTheme: ButtonTextTheme.normal,
              textColor: Colors.blue,
              minWidth: 120,
              disabledTextColor: Colors.red,
              color: Color(0xFF82B1FF),
            ),
          ],
        ),
      ),
    );
  }
}
