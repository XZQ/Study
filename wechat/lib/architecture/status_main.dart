import 'package:flutter/material.dart';
import 'package:wechat/architecture/bloc/bloc_main.dart';
import 'package:wechat/architecture/mvc/mvc_main.dart';
import 'package:wechat/architecture/mvp/mvp_main.dart';
import 'package:wechat/architecture/redux/redux_main.dart';
import 'package:wechat/tools/ThemeColors.dart';

//https://juejin.im/post/5d2c4b76f265da1bb56529b5
class StatusMian extends StatefulWidget {
  @override
  _StatusMianState createState() => _StatusMianState();
}

class _StatusMianState extends State<StatusMian> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Status', style: TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
        iconTheme: ThemeData.light().primaryIconTheme,
      ),
      body: Center(
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.center,
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            MaterialButton(
              child: Text("MVC"),
              onPressed: () {
                Navigator.push(context, MaterialPageRoute(builder: (ctx) => MvcMian()));
              },
              textTheme: ButtonTextTheme.normal,
              textColor: Colors.red,
              color: Color(0xFF82B1FF),
              minWidth: 120,
            ),
            MaterialButton(
              child: Text("MVP"),
              onPressed: () {
                Navigator.push(context, MaterialPageRoute(builder: (ctx) => MvpMain()));
              },
              textTheme: ButtonTextTheme.normal,
              textColor: Colors.blue,
              disabledTextColor: Colors.red,
              color: Color(0xFF82B1FF),
              minWidth: 120,
            ),
            MaterialButton(
              child: Text("Redux"),
              onPressed: () {
                Navigator.push(context, MaterialPageRoute(builder: (ctx) => ReduxMian()));
              },
              textTheme: ButtonTextTheme.normal,
              textColor: Colors.blue,
              minWidth: 120,
              disabledTextColor: Colors.red,
              color: Color(0xFF82B1FF),
            ),
            MaterialButton(
              child: Text("BLoC"),
              onPressed: () {
                Navigator.push(context, MaterialPageRoute(builder: (ctx) => BlocMain()));
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
