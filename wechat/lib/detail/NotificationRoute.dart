import 'package:flutter/material.dart';

class NotificationRoute extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return  NotificationRouteState();
  }
}

class NotificationRouteState extends State {
  String _msg = "";
  @override
  Widget build(BuildContext context) {
    return  NotificationListener<MyNotification>(
      onNotification: (notification) {
        setState(() {
          _msg += notification.msg + " ";
        });
      },
      child:  Center(
        child:  Column(
          mainAxisSize: MainAxisSize.min,
          children: <Widget>[
            Builder(
              builder: (context) {
                return RaisedButton(
                  //按钮点击时分发通知
                  onPressed: () => MyNotification("Hi").dispatch(context),
                  child: Text("Send Notification"),
                );
              },
            ),
            Text(_msg),
          ],
        ),
      ),
    );
  }
}

class MyNotification extends Notification {
  String msg;
  MyNotification(this.msg);
}
