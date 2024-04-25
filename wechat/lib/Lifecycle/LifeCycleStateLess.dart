import 'package:flutter/material.dart';
import 'package:wechat/Lifecycle/GoStatefulWidget.dart';
import 'package:wechat/Lifecycle/GoStatelessWidget.dart';
import 'package:wechat/tools/Log.dart';
import 'package:wechat/tools/ThemeColors.dart';

class LifeCycleStateLess extends StatelessWidget {
  LifeCycleStateLess() {
    Log.e("TAG", "LifeCycleStateLess 构造");
  }

  @override
  Widget build(BuildContext context) {
    Log.e("TAG", "LifeCycleStateLess build");
    return Scaffold(
      appBar: AppBar(
        title: Text('LifeCycleStateLess', style: TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
        elevation: 0.0,
      ),
      body: Container(
        child: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: <Widget>[
              MaterialButton(
                child: Text("go StatelessWidget"),
                onPressed: () {
                  Navigator.push(context, MaterialPageRoute(builder: (ctx) {
                    return GoStatelessWidget();
                  }));
                },
                textColor: Colors.blue,
                color: Color(0xFF82B1FF),
              ),
              MaterialButton(
                child: Text("go StatefulWidget"),
                onPressed: () {
                  Navigator.push(context, MaterialPageRoute(builder: (ctx) {
                    return GoStatefulWidget();
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
