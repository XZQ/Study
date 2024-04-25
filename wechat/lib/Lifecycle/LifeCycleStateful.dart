import 'package:flutter/material.dart';
import 'package:wechat/Lifecycle/ToStatefulWidget.dart';
import 'package:wechat/Lifecycle/ToStatelessWidget.dart';
import 'package:wechat/tools/Log.dart';
import 'package:wechat/tools/ThemeColors.dart';

class LifeCycleStateful extends StatefulWidget {
  @override
  LifeDemoState createState() => LifeDemoState();
}

class LifeDemoState extends State<LifeCycleStateful> with WidgetsBindingObserver {
  LifeDemoState() {
    Log.e("TAG", "LifeDemoState ==>  构造");
  }

  @override
  void initState() {
    super.initState();
    WidgetsBinding.instance.addObserver(this);
    Log.e("TAG", "LifeDemoState ==>  initState");
  }

  @override
  void didChangeAppLifecycleState(AppLifecycleState state) {
    Log.e("TAG", "LifeDemoState ==>  didChangeAppLifecycleState " + state.toString());
  }

  @override
  void didChangeDependencies() {
    super.didChangeDependencies();
    Log.e("TAG", "LifeDemoState ==>  didChangeDependencies");
  }

  @override
  void didUpdateWidget(LifeCycleStateful oldWidget) {
    super.didUpdateWidget(oldWidget);
    Log.e("TAG", "LifeDemoState ==>  didUpdateWidget");
  }

  @override
  void deactivate() {
    super.deactivate();
    Log.e("TAG", "LifeDemoState ==>  deactivate");
  }

  @override
  void dispose() {
    WidgetsBinding.instance.removeObserver(this);
    super.dispose();
    Log.e("TAG", "LifeDemoState ==>  dispose");
  }

  @override
  Widget build(BuildContext context) {
    Log.e("TAG", "LifeDemoState ==>  build");
    return new Scaffold(
      appBar: new AppBar(
        title: new Text('LifeCycleStateful', style: new TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
        elevation: 0.0,
      ),
      body: new Container(
        child: new Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: <Widget>[
              new RaisedButton(
                child: Text("to StatelessWidget"),
                onPressed: () {
                  Navigator.push(context, new MaterialPageRoute(builder: (ctx) {
                    return new ToStatelessWidget();
                  }));
                },
                textColor: Colors.blue,
                color: Color(0xFF82B1FF),
              ),
              new RaisedButton(
                child: Text("to StatefulWidget"),
                onPressed: () {
                  Navigator.push(context, new MaterialPageRoute(builder: (ctx) {
                    return new ToStatefulWidget();
                  }));
                },
                textColor: Colors.blue,
                color: Color(0xFF82B1FF),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
