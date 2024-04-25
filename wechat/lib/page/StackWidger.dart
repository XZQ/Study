import 'package:flutter/material.dart';
import 'package:wechat/tools/ThemeColors.dart';

class StackWidger extends StatefulWidget {
  @override
  _StackWidgerState createState() => _StackWidgerState();
}

class _StackWidgerState extends State<StackWidger> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Stack', style: TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
      ),
      body: Container(
          color: Colors.green,
          height: 150.0,
          width: 500.0,
          child: Stack(children: <Widget>[
            Container(
              color: Colors.blueAccent,
              height: 50.0,
              width: 100.0,
              alignment: Alignment.center,
              child: Text('unPositioned'),
            ),
            Positioned(
                left: 40.0,
                top: 80.0,
                child: Container(
                  color: Colors.pink,
                  height: 50.0,
                  width: 95.0,
                  alignment: Alignment.center,
                  child: Text('Positioned'),
                )),
          ])),
    );
  }

  @override
  void deactivate() {
    super.deactivate();
  }
}
