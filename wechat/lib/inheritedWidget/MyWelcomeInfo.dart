import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';
import 'package:wechat/tools/ThemeColors.dart';

//https://juejin.im/post/5b4f1f686fb9a04fcd584e6e
//https://www.jianshu.com/p/77c9ab7c1330
class ShareInheritWidget extends InheritedWidget {
  final String welcomeInfo;

  ShareInheritWidget({Key key, this.welcomeInfo, Widget child})
      : assert(welcomeInfo != null),
        assert(child != null),
        super(key: key, child: child);

  static ShareInheritWidget of(BuildContext context) =>
      context.inheritFromWidgetOfExactType(ShareInheritWidget);

  @override
  bool updateShouldNotify(ShareInheritWidget oldWidget) =>
      welcomeInfo != oldWidget.welcomeInfo;
}

class MyNestedChild extends StatelessWidget {
  @override
  build(BuildContext context) {
    final ShareInheritWidget widget =
        context.inheritFromWidgetOfExactType(ShareInheritWidget);
    return Text(widget.welcomeInfo);
  }
}

class ShareMyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: new AppBar(
        title: new Text('InheritedWidget',
            style: new TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
      ),
      body: Center(
        child: ShareInheritWidget(
            welcomeInfo: 'XZQ',
            child: Center(
              child: MyNestedChild(),
            )),
      ),
    );
  }
}
