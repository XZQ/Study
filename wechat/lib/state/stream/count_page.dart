import 'dart:async';

import 'package:flutter/material.dart';
import 'package:wechat/tools/ThemeColors.dart';

//https://juejin.im/post/5baa4b90e51d450e6d00f12e
class CountPage extends StatefulWidget {
  @override
  _CountPageState createState() => _CountPageState();
}

class _CountPageState extends State<CountPage> {
  int count = 0;
  final StreamController _controller = StreamController<int>.broadcast();

  @override
  void initState() {
    super.initState();
    lintener();
  }

  void lintener() {
    StreamTransformer transformer = StreamTransformer<int, String>.fromHandlers(handleData: (value, sink) {
      if (value == 1) {
        sink.add("ssssss");
      } else {
        sink.addError("tttttt");
      }
    });
    _controller.stream
        .transform(transformer)
        .listen((data) => print("== " + data), onError: (err) => print("++ " + err));
  }

  @override
  void dispose() {
    _controller.close();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    // test();
    return new Scaffold(
      appBar: new AppBar(
        title: new Text('Stream', style: new TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
        elevation: 0.0,
      ),
      body: Center(
        child: StreamBuilder<int>(
          stream: _controller.stream,
          initialData: count,
          builder: (BuildContext context, AsyncSnapshot<int> snapshot) {
            return Center(
              child: Column(
                mainAxisAlignment: MainAxisAlignment.center,
                crossAxisAlignment: CrossAxisAlignment.center,
                children: <Widget>[
                  Text('You hit me: ${snapshot.data} times'),
                ],
              ),
            );
          },
        ),
      ),
      floatingActionButton: FloatingActionButton(
        child: const Icon(Icons.add),
        onPressed: () {
          _controller.sink.add(++count);
        },
      ),
    );
  }
}
