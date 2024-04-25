import 'package:flutter/material.dart';
import 'package:wechat/loading/flutter_spinkit.dart';
import 'package:wechat/tools/ThemeColors.dart';

class BottomLoading extends StatefulWidget {
  BottomLoadingState createState() => new BottomLoadingState();
}

class BottomLoadingState extends State<BottomLoading> {
  Color themeColor = ThemeColors.currentColorTheme;
  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: new AppBar(
        title: new Text('底部loading', style: new TextStyle(color: Colors.white)),
        backgroundColor: themeColor,
      ),
      body: new ListView(
        children: <Widget>[
          new Padding(padding: EdgeInsets.all(10)),
          new SpinKitRotatingPlain(
            color: Colors.blueAccent,
            size: 40.0,
          ),
          new Padding(padding: EdgeInsets.all(10)),
          new SpinKitRotatingCircle(
            color: Colors.blueAccent,
            size: 40.0,
          ),
          new Padding(padding: EdgeInsets.all(10)),
          new SpinKitDoubleBounce(
            color: Colors.blueAccent,
            size: 40.0,
          ),
          new Padding(padding: EdgeInsets.all(10)),
          new SpinKitRing(
            color: Colors.blueAccent,
            lineWidth: 1,
            size: 40.0,
          ),
          new Padding(padding: EdgeInsets.all(10)),
          new SpinKitWave(
            color: Colors.blueAccent,
            size: 40.0,
          ),
          new Padding(padding: EdgeInsets.all(10)),
          new SpinKitWanderingCubes(
            color: Colors.blueAccent,
            size: 40.0,
          ),
          new Padding(padding: EdgeInsets.all(10)),
          new SpinKitFadingCube(
            color: Colors.blueAccent,
            size: 40.0,
          ),
          new Padding(padding: EdgeInsets.all(10)),
          new SpinKitFadingFour(
            color: Colors.blueAccent,
            size: 40.0,
          ),
          new Padding(padding: EdgeInsets.all(10)),
          new SpinKitPulse(
            color: Colors.blueAccent,
            size: 40.0,
          ),
          new Padding(padding: EdgeInsets.all(10)),
          new SpinKitChasingDots(
            color: Colors.green[400],
            size: 50.0,
          ),
          new Padding(padding: EdgeInsets.all(10)),
          new SpinKitHourGlass(
            color: Colors.blueAccent,
            size: 40.0,
          ),
          new Padding(padding: EdgeInsets.all(10)),
          new SpinKitSpinningCircle(
            color: Colors.blueAccent,
            size: 40.0,
          ),
          new Padding(padding: EdgeInsets.all(10)),
        ],
      ),
    );
  }
}
