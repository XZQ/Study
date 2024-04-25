import 'package:flutter/material.dart';
import 'package:wechat/principle/StatelessfulState.dart';
import 'package:wechat/principle/WrapStatelessWidget.dart';
import 'package:wechat/tools/ThemeColors.dart';

class Overdraw extends StatefulWidget {
  @override
  _OverdrawState createState() => _OverdrawState();
}

class _OverdrawState extends State<Overdraw> {
  Color themeColor = ThemeColors.currentColorTheme;
  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: new AppBar(
        title: new Text('过度绘制', style: new TextStyle(color: Colors.white)),
        backgroundColor: themeColor,
        elevation: 0.0,
      ),
      body: new ListView(
        children: <Widget>[
          new Container(
            padding: const EdgeInsets.only(top: 1.0),
            child: new Container(
              height: 50.0,
              child: new ListTile(
                leading: new Icon(Icons.scatter_plot),
                title: new Text("StatefulWidget"),
                onTap: () {
                  Navigator.push(context, new MaterialPageRoute(builder: (ctx) {
                    return new StatelessfulState("过度绘制");
                  }));
                },
              ),
              color: Colors.white,
            ),
            color: Colors.grey[200],
          ),
          new Container(
            padding: const EdgeInsets.only(top: 1.0),
            child: new Container(
              height: 50.0,
              child: new ListTile(
                leading: new Icon(Icons.sentiment_satisfied),
                title: new Text("StatelessWidget"),
                onTap: () {
                  // Navigator.pushNamed(context, RouterPage.WRAPSTATEL);
                  Navigator.push(context, new MaterialPageRoute(builder: (ctx) {
                    return new WrapStatelessWidget();
                  }));
                },
              ),
              color: Colors.white,
            ),
            color: Colors.grey[200],
          ),
        ],
      ),
    );
  }
}
