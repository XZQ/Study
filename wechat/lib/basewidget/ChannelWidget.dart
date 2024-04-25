import 'dart:async';

import 'package:flutter/material.dart' hide BottomNavigationBar;
import 'package:flutter/services.dart';
import 'package:wechat/tools/ThemeColors.dart';
import 'package:wechat/tools/Log.dart';

//https://www.jianshu.com/p/51ac309786c6
//https://www.jianshu.com/p/d9eeb15b3fa0
//https://juejin.im/post/5d2c19c6e51d4558936aa11c
//
class ChannelWidget extends StatefulWidget {
  @override
  _ChannelWidgetState createState() => _ChannelWidgetState();
}

class _ChannelWidgetState extends State<ChannelWidget> {
  // static const MethodChannel methodChannel =
  //     MethodChannel('samples.flutter.io/battery');

  static const EventChannel eventChannel =
      EventChannel('samples.flutter.io/charging');

  String _batteryLevel = 'Battery level: unknown.';

  String _chargingStatus = 'Battery status: unknown.';

  // Future<void> _getBatteryLevel() async {
  //   String batteryLevel;
  //   try {
  //     final int result = await methodChannel.invokeMethod('getBatteryLevel');
  //     batteryLevel = 'Battery level: $result%.';
  //   } on PlatformException {
  //     batteryLevel = 'Failed to get battery level.';
  //   }
  //   setState(() {
  //     _batteryLevel = batteryLevel;
  //   });
  // }

  Future<dynamic> platformCallHandler(MethodCall call) async {
    switch (call.method) {
      case "getFlutterName":
        return "Flutter name is XZQ";
        break;
    }
  }

  @override
  void initState() {
    super.initState();
    eventChannel.receiveBroadcastStream().listen(_onEvent, onError: _onError);
    // methodChannel.setMethodCallHandler(platformCallHandler);
  }

  void _onEvent(Object event) {
    setState(() {
      _chargingStatus =
          "Battery status: ${event == 'charging' ? '' : 'dis'}charging.";

      Log.e("XZQ", "Battery status: ${event == 'charging' ? '' : 'dis'}");
    });
  }

  void _onError(Object error) {
    setState(() {
      _chargingStatus = 'Battery status: unknown.';
    });
  }

  @override
  Widget build(BuildContext context) {
    return new Scaffold(
        appBar: new AppBar(
          title: new Text('动画', style: new TextStyle(color: Colors.white)),
          backgroundColor: ThemeColors.currentColorTheme,
        ),
        body: new Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: <Widget>[
              Column(
                mainAxisAlignment: MainAxisAlignment.center,
                children: <Widget>[
                  Text(_batteryLevel, key: const Key('Battery level label')),
                  Padding(
                    padding: const EdgeInsets.all(16.0),
                    child: RaisedButton(
                      child: const Text('Refresh'),
                      // onPressed: _getBatteryLevel,
                    ),
                  ),
                ],
              ),
              Text(_chargingStatus),
            ],
          ),
        ));
  }
}
