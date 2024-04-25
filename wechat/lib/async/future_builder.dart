import 'dart:io';

import 'package:flutter/material.dart';
import 'package:wechat/tools/ThemeColors.dart';

class FutureMain extends StatefulWidget {
  @override
  _FutureMainState createState() => _FutureMainState();
}

class _FutureMainState extends State<FutureMain> {
  @override
  Widget build(BuildContext context) {
    var httpClient = new HttpClient();

    Widget waiting = Column(
      children: <Widget>[
        Text('waiting'),
        Icon(Icons.cloud_download),
      ],
    );
    Widget active = Column(
      children: <Widget>[
        Text('active'),
        Icon(Icons.access_time),
      ],
    );
    Widget error = Column(
      children: <Widget>[
        Text('error'),
        Icon(Icons.error),
      ],
    );
    Widget done = Column(
      children: <Widget>[
        Text('done'),
        Icon(Icons.done),
      ],
    );
    Widget none = Column(
      children: <Widget>[
        Text('none'),
        Icon(Icons.filter_none),
      ],
    );

    return Scaffold(
        appBar: AppBar(
          title: Text('Future', style: new TextStyle(color: Colors.white)),
          backgroundColor: ThemeColors.currentColorTheme,
          elevation: 0.0,
        ),
        body: FutureBuilder(
          future: httpClient.getUrl(Uri.parse('https://www.baidu.cossm/')),
          builder: (context, snap) {
            if (snap.connectionState == ConnectionState.done) {
              if (snap.hasError) {
                return error;
              }
              return done;
            } else if (snap.connectionState == ConnectionState.active) {
              return active;
            } else if (snap.connectionState == ConnectionState.waiting) {
              return waiting;
            } else if (snap.connectionState == ConnectionState.none) {
              return none;
            }
          },
        ));
  }
}
