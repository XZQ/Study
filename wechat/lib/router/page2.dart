import 'package:flutter/material.dart';
import 'package:wechat/tools/ThemeColors.dart';

class Page2 extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Page2', style: new TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
        elevation: 0.0,
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: <Widget>[
            Text(
              "Page2",
              style: TextStyle(fontSize: 25.0),
            ),
            MaterialButton(
              child: Text("RouterApp"),
              onPressed: () {
                Navigator.of(context).pop("end");
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
  }
}
