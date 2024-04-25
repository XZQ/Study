import 'package:flutter/material.dart';
import 'package:wechat/state/provider2/change_notifier_provider_main.dart';
import 'package:wechat/state/provider2/mutli_mian.dart';
import 'package:wechat/state/provider2/nest_main.dart';
import 'package:wechat/state/provider2/provider_main.dart';
import 'package:wechat/tools/ThemeColors.dart';

class ProviderApp extends StatefulWidget {
  @override
  _ProviderState createState() => _ProviderState();
}

class _ProviderState extends State<ProviderApp> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Provider', style: new TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: <Widget>[
            MaterialButton(
              child: Text("ProviderMain"),
              onPressed: () {
                Navigator.push(context,
                    new MaterialPageRoute(builder: (ctx) => ProviderMain2()));
              },
              textTheme: ButtonTextTheme.normal,
              textColor: Colors.red,
              color: Color(0xFF82B1FF),
              minWidth: 120,
            ),
            MaterialButton(
              child: Text("NestMain"),
              onPressed: () {
                Navigator.push(context,
                    new MaterialPageRoute(builder: (ctx) => NestMain()));
              },
              textTheme: ButtonTextTheme.normal,
              textColor: Colors.blue,
              disabledTextColor: Colors.red,
              color: Color(0xFF82B1FF),
              minWidth: 120,
            ),
            MaterialButton(
              child: Text("MutliMian"),
              onPressed: () {
                Navigator.push(context,
                    new MaterialPageRoute(builder: (ctx) => MutliMian()));
              },
              textTheme: ButtonTextTheme.normal,
              textColor: Colors.blue,
              minWidth: 120,
              disabledTextColor: Colors.red,
              color: Color(0xFF82B1FF),
            ),
            MaterialButton(
              child: Text("ChangeNotifier"),
              onPressed: () {
                Navigator.push(
                    context,
                    new MaterialPageRoute(
                        builder: (ctx) => ChangeNotifierProviderMain()));
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
