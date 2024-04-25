import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:wechat/tools/ThemeColors.dart';

//https://blog.csdn.net/chenlove1/article/details/84828049
class ButtonDemo extends StatefulWidget {
  @override
  _ButtonDemoState createState() => _ButtonDemoState();
}

class _ButtonDemoState extends State<ButtonDemo> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Button', style: TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
      ),
      body: Container(
        child: getButtons(context),
      ),
    );
  }

  //  ---------------------------Button--------------------------------------------------
  Widget getButtons(BuildContext context) {
    return Column(children: [
      SizedBox(height: 10),
      Expanded(flex: 0, child: getMaterialButton(context)),
      //
      SizedBox(height: 10),
      Expanded(flex: 0, child: getRaisedButtonRow(context)),
      //
      SizedBox(height: 10),
      Expanded(flex: 0, child: getFlatButtonRow(context)),
      //
      SizedBox(height: 10),
      Expanded(flex: 0, child: getOutlineButtonRow(context)),
      //
      SizedBox(height: 10),
      Expanded(flex: 0, child: getCupertinoButton(context)),
      SizedBox(height: 10),
    ]);
  }

  Widget getMaterialButton(BuildContext context) {
    return MaterialButton(
      key: ValueKey("text"),
      child: Text("MaterialButton"),
      onPressed: pressedBtn(context),
      onHighlightChanged: onHighlightChanged(context),
      textTheme: ButtonTextTheme.normal,
      textColor: Colors.blue,
      disabledTextColor: Colors.red,
      color: Color(0xFF82B1FF),
      disabledColor: Colors.grey,
      highlightColor: Colors.grey,
      // 按下的背景色
      splashColor: Colors.green,
      // 水波纹颜色
      colorBrightness: Brightness.light,
      // 主题
      elevation: 10,
      highlightElevation: 10,
      disabledElevation: 10,
      padding: EdgeInsets.all(10),
//       MaterialButton shape 子类才起效
      shape: RoundedRectangleBorder(
          borderRadius: BorderRadius.all(Radius.circular(20)),
          side: BorderSide(color: Color(0xFFFFFFFF), style: BorderStyle.solid, width: 2)),
      clipBehavior: Clip.antiAlias,
      materialTapTargetSize: MaterialTapTargetSize.padded,
      animationDuration: Duration(seconds: 1),
      // minWidth: 200,
      // height: 50,
    );
  }

  Widget getRaisedButtonRow(BuildContext context) {
    return Row(children: [
      SizedBox(width: 10),
      Expanded(flex: 1, child: getRaisedButton(context)),
      SizedBox(width: 10),
      Expanded(flex: 1, child: getRaisedButtonIcon(context)),
      SizedBox(width: 10),
    ]);
  }

  Widget getRaisedButton(BuildContext context) {
    return RaisedButton(
      child: Text("RaisedButton"),
      onPressed: pressedBtn(context),
      onHighlightChanged: onHighlightChanged(context),
      textTheme: ButtonTextTheme.normal,
      textColor: Colors.blue,
      disabledTextColor: Colors.red,
      color: Color(0xFF82B1FF),
      disabledColor: Colors.grey,
      highlightColor: Colors.grey,
      // 按下的背景色
      splashColor: Colors.green,
      // 水波纹颜色
      colorBrightness: Brightness.light,
      // 主题
      elevation: 10,
      highlightElevation: 10,
      disabledElevation: 10,
      padding: EdgeInsets.all(10),
      // RaisedButton 才起效
      shape: RoundedRectangleBorder(
          borderRadius: BorderRadius.all(Radius.circular(20)),
          side: BorderSide(color: Color(0xFFFFF00F), style: BorderStyle.solid, width: 2)),
      clipBehavior: Clip.antiAlias,
      materialTapTargetSize: MaterialTapTargetSize.padded,
      animationDuration: Duration(seconds: 1),
    );
  }

  Widget getRaisedButtonIcon(BuildContext context) {
    return RaisedButton.icon(
      icon: Icon(Icons.menu),
      label: Text("Icons.menu"),
      onPressed: pressedBtn(context),
      onHighlightChanged: onHighlightChanged(context),
      textTheme: ButtonTextTheme.normal,
      textColor: Colors.blue,
      disabledTextColor: Colors.red,
      color: Color(0xFF82B1FF),
      disabledColor: Colors.grey,
      highlightColor: Colors.red,
      // 按下的背景色
//      splashColor: Colors.green,// 水波纹颜色
      colorBrightness: Brightness.light,
      // 主题
      elevation: 10,
      highlightElevation: 10,
      disabledElevation: 10,
//      padding: EdgeInsets.all(10),
      // RaisedButton 才起效
      shape: RoundedRectangleBorder(
          borderRadius: BorderRadius.all(Radius.circular(10)),
          side: BorderSide(color: Color(0xFFF0F00), style: BorderStyle.solid, width: 2)),
      clipBehavior: Clip.antiAlias,
      materialTapTargetSize: MaterialTapTargetSize.padded,
      animationDuration: Duration(seconds: 1),
//      minWidth: 200,
//      height: 50,
    );
  }

  Widget getFlatButtonRow(BuildContext context) {
    return Row(children: [
      SizedBox(width: 10),
      Expanded(flex: 1, child: getFlatButton(context)),
      SizedBox(width: 10),
      Expanded(flex: 1, child: getFlatButtonIcon(context)),
      SizedBox(width: 10),
    ]);
  }

  Widget getFlatButton(BuildContext context) {
    return FlatButton(
      child: Text("FlatButton"),
      onPressed: pressedBtn(context),
      onHighlightChanged: onHighlightChanged(context),
      textTheme: ButtonTextTheme.normal,
      textColor: Colors.yellow,
      disabledTextColor: Colors.red,
      color: Color(0xFF82B1FF),
      disabledColor: Colors.grey,
      highlightColor: Colors.grey,
      // 按下的背景色
      splashColor: Colors.transparent,
      // 水波纹颜色
      colorBrightness: Brightness.light,
      // 主题
//      elevation: 10,
//      highlightElevation: 10,
//      disabledElevation: 10,
      padding: EdgeInsets.all(10),
//       RaisedButton 才起效
      shape: RoundedRectangleBorder(
          borderRadius: BorderRadius.all(Radius.circular(20)),
          side: BorderSide(color: Color(0xFFF9F3FF), style: BorderStyle.solid, width: 2)),
      clipBehavior: Clip.antiAlias,
      materialTapTargetSize: MaterialTapTargetSize.padded,
//      animationDuration: Duration(seconds:1),
//      minWidth: 200,
//      height: 50,
    );
  }

  Widget getFlatButtonIcon(BuildContext context) {
    return FlatButton.icon(
      icon: Icon(
        Icons.menu,
        color: Colors.green,
      ),
      label: Text("Icons.menu"),
      onPressed: pressedBtn(context),
      onHighlightChanged: onHighlightChanged(context),
      textTheme: ButtonTextTheme.normal,
      textColor: Colors.yellow,
      disabledTextColor: Colors.red,
      color: Color(0xFF82B1FF),
      disabledColor: Colors.grey,
      highlightColor: Colors.red,
      // 按下的背景色
      splashColor: Colors.green,
      // 水波纹颜色
      colorBrightness: Brightness.light,
      // 主题
//      elevation: 10,
//      highlightElevation: 10,
//      disabledElevation: 10,
//      padding: EdgeInsets.all(10),
      // RaisedButton 才起效
      shape: RoundedRectangleBorder(
          borderRadius: BorderRadius.all(Radius.circular(10)),
          side: BorderSide(color: Color(0xFF6FFF00), style: BorderStyle.solid, width: 2)),
      clipBehavior: Clip.antiAlias,
      materialTapTargetSize: MaterialTapTargetSize.padded,
//      animationDuration: Duration(seconds:1),
//      minWidth: 200,
//      height: 50,
    );
  }

  Widget getOutlineButtonRow(BuildContext context) {
    return Row(children: [
      SizedBox(width: 10),
      Expanded(flex: 1, child: getOutlineButton(context)),
      SizedBox(width: 10),
      Expanded(flex: 1, child: getOutlineButtonIcon(context)),
      SizedBox(width: 10),
    ]);
  }

  Widget getOutlineButton(BuildContext context) {
    return OutlineButton(
      child: Text("OutlineButton"),
      onPressed: pressedBtn(context),
//      onHighlightChanged: onHighlightChanged,
      textTheme: ButtonTextTheme.accent,
      textColor: Colors.blueAccent,
      disabledTextColor: Colors.red,
      color: Color(0xFF82B1FF),
//      disabledColor: Colors.grey,
      highlightColor: Color(0xFF2962FF),
      // 按下的背景色
      splashColor: Colors.red,
      // 水波纹颜色
//      colorBrightness: Brightness.light,   // 主题
//      elevation: 10,
      highlightElevation: 10,
//      disabledElevation: 10,
      padding: EdgeInsets.all(10),
//       RaisedButton 才起效
      shape: RoundedRectangleBorder(
          borderRadius: BorderRadius.all(Radius.circular(20)),
          side: BorderSide(color: Color(0xFFFFFF00), style: BorderStyle.solid, width: 2)),
      clipBehavior: Clip.antiAlias,
//      materialTapTargetSize: MaterialTapTargetSize.padded,
//      animationDuration: Duration(seconds:1),
//      minWidth: 200,
//      height: 50,
    );
  }

  Widget getOutlineButtonIcon(BuildContext context) {
    return OutlineButton.icon(
      icon: Icon(
        Icons.menu,
        color: Colors.green,
      ),
      label: Text("Icons.menu"),
      onPressed: pressedBtn(context),
//      onHighlightChanged: onHighlightChanged,
      textTheme: ButtonTextTheme.normal,
      textColor: Colors.green,
      disabledTextColor: Colors.red,
      color: Colors.green,
//      disabledColor: Colors.grey,
      highlightColor: Colors.red,
      // 按下的背景色
      splashColor: Colors.green,
      // 水波纹颜色
//      colorBrightness: Brightness.light,   // 主题
//      elevation: 10,
      highlightElevation: 10,
//      disabledElevation: 10,
      padding: EdgeInsets.all(10),
      // RaisedButton 才起效
      shape: RoundedRectangleBorder(
        borderRadius: BorderRadius.all(Radius.circular(12)),
      ),
      clipBehavior: Clip.antiAlias,
//      materialTapTargetSize: MaterialTapTargetSize.padded,
//      animationDuration: Duration(seconds:1),
//      minWidth: 200,
//      height: 50,
    );
  }

  Widget getCupertinoButton(BuildContext context) {
    return CupertinoButton(
      child: Text("CupertinoButton"),
      onPressed: pressedBtn(context),
      color: Colors.blue,
      disabledColor: Colors.grey,
      padding: EdgeInsets.all(10),
      minSize: 50,
      pressedOpacity: 0.8,
      borderRadius: BorderRadius.all(Radius.circular(8.0)),
    );
  }

  ValueChanged<bool> onHighlightChanged(BuildContext context) {
    return (bool b) {
      showToast(context, "onHighlightChanged:" + b.toString());
    };
  }

  VoidCallback pressedBtn(BuildContext context) {
    return () {
      showToast(context, "pressedBtn");
    };
  }

  void showToast(BuildContext context, var msg) async {
    Widget _buildToastWidget() {
      return Center(
        child: Card(
          color: Colors.black26,
          child: Padding(
            padding: EdgeInsets.symmetric(horizontal: 10.0, vertical: 5.0),
            child: Text(
              msg,
              style: TextStyle(
                fontSize: 14.0,
                color: Colors.white,
              ),
            ),
          ),
        ),
      );
    }

    //获取OverlayState
    OverlayState overlayState = Overlay.of(context);
    //创建OverlayEntry
    OverlayEntry _overlayEntry = OverlayEntry(
        //toast靠它加到屏幕上
        builder: (BuildContext context) => Positioned(
              //top值，可以改变这个值来改变toast在屏幕中的位置
              top: MediaQuery.of(context).size.height * 4 / 7,
              child: Container(
                  alignment: Alignment.center,
                  width: MediaQuery.of(context).size.width,
                  child: Padding(
                    padding: EdgeInsets.symmetric(horizontal: 80.0),
                    child: _buildToastWidget(),
                  )),
            ));
    //显示到屏幕上。
    overlayState.insert(_overlayEntry);
    //等待2秒
    await Future.delayed(Duration(seconds: 2));
    //移除
    _overlayEntry.remove();
  }
}
