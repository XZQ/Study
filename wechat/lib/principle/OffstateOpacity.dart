import 'package:flutter/material.dart';
import 'package:wechat/tools/ThemeColors.dart';

class OffstateOpacity extends StatefulWidget {
  @override
  _OffstateOpacityState createState() => _OffstateOpacityState();
}

class _OffstateOpacityState extends State<OffstateOpacity> {
  bool visible = false;
  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: new AppBar(
        title: new Text('控件显示隐藏', style: new TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
      ),
      body: Container(
        alignment: Alignment.center,
        child: new Column(
          mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: <Widget>[
            new Offstage(
              offstage: visible,
              child: new RaisedButton(
                  child: new Text(
                    'Offstage',
                    style: new TextStyle(
                      color: Colors.white, // textcolor
                    ),
                  ),
                  color: Theme.of(context).accentColor,
                  splashColor: Colors.blueGrey,
                  onPressed: () {}),
            ),
            new AnimatedOpacity(
              duration: Duration(milliseconds: 0),
              opacity: visible ? 0.0 : 1.0,
              child: new RaisedButton(
                  child: new Text(
                    'Opacity',
                    style: new TextStyle(
                      color: Colors.white, // textcolor
                    ),
                  ),
                  color: Theme.of(context).accentColor,
                  splashColor: Colors.blueGrey,
                  onPressed: () {}),
            ),
          ],
        ),
      ),
      floatingActionButton: new FloatingActionButton(
        child: Text("显示"),
        onPressed: () {
          visible = !visible;
          setState(() {});
        },
      ),
    );
  }
}
