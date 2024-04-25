import 'package:flutter/material.dart';
import 'package:wechat/tools/ThemeColors.dart';
import 'package:wechat/view/GradientButton.dart';

class GradientButtonRoute extends StatefulWidget {
  @override
  _GradientButtonRouteState createState() => _GradientButtonRouteState();
}

class _GradientButtonRouteState extends State<GradientButtonRoute> {
  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: new AppBar(
        elevation: 0.0,
        title: new Text('Stack', style: new TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
      ),
      body: new Container(
        child: Column(
          children: <Widget>[
            GradientButton(
              colors: [Colors.orange, Colors.red],
              height: 50.0,
              child: Text("Submit"),
              onTap: onTap,
            ),
            GradientButton(
              height: 50.0,
              colors: [Colors.lightGreen, Colors.green[700]],
              child: Text("Submit"),
              onTap: onTap,
            ),
            GradientButton(
              height: 50.0,
              colors: [Colors.lightBlue[300], Colors.blueAccent],
              child: Text("Submit"),
              onTap: onTap,
            ),
          ],
        ),
      ),
    );
  }

  onTap() {
    print("button click");
  }
}
