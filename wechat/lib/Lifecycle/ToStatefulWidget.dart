import 'package:flutter/material.dart';
import 'package:wechat/tools/Log.dart';
import 'package:wechat/tools/ThemeColors.dart';

class ToStatefulWidget extends StatefulWidget {
  @override
  _ToStatefulWidgetState createState() => _ToStatefulWidgetState();
}

//https://juejin.im/post/5ca81c80e51d4509f8232e9b
class _ToStatefulWidgetState extends State<ToStatefulWidget> with WidgetsBindingObserver {
  String string = "button";

  _ToStatefulWidgetState() {
    Log.e("TAG", "_ToStatefulWidgetState ==>  构造");
  }

  @override
  void initState() {
    super.initState();
    WidgetsBinding.instance.addObserver(this);
    Log.e("TAG", "_ToStatefulWidgetState ==>  initState");
  }

  @override
  void didChangeAppLifecycleState(AppLifecycleState state) {
    Log.e("TAG", "_ToStatefulWidgetState ==>  didChangeAppLifecycleState " + state.toString());
  }

  @override
  void didChangeDependencies() {
    super.didChangeDependencies();
    Log.e("TAG", "_ToStatefulWidgetState ==>  didChangeDependencies");
  }

  @override
  void didUpdateWidget(ToStatefulWidget oldWidget) {
    super.didUpdateWidget(oldWidget);
    Log.e("TAG", "_ToStatefulWidgetState ==>  didUpdateWidget");
  }

  @override
  void deactivate() {
    super.deactivate();
    Log.e("TAG", "_ToStatefulWidgetState ==>  deactivate");
  }

  @override
  void dispose() {
    WidgetsBinding.instance.removeObserver(this);
    super.dispose();
    Log.e("TAG", "_ToStatefulWidgetState ==>  dispose");
  }

  @override
  Widget build(BuildContext context) {
    Log.e("TAG", "_ToStatefulWidgetState ==>  build");
    return Scaffold(
      appBar:  AppBar(
        title:  Text('ToStatefulWidget', style:  TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
        elevation: 0.0,
      ),
      body:  Center(
        child:  Padding(
          padding: EdgeInsets.all(10),
          child:  Column(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: <Widget>[
               RaisedButton(
                child: Text(string),
                onPressed: () {
                  setState(() {
                    string = "XZQ";
                    Log.e("TAG", "Button onPressed  ==>  XZQ");
                  });
                },
                textColor: Colors.blue,
                color: Color(0xFF82B1FF),
              ),
               Container(
                child:  RaisedButton(
                  child: Text("string"),
                  onPressed: () {
                    setState(() {
                      string = "XZQ";
                      Log.e("TAG", "Button onPressed  ==>  XZQ");
                    });
                  },
                  textColor: Colors.blue,
                  color: Color(0xFF82B1FF),
                ),
              )
            ],
          ),
        ),
      ),
    );
  }
}
