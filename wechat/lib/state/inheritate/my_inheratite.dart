import 'package:flutter/material.dart';
import 'package:wechat/inheritedWidget/MyWelcomeInfo.dart';
import 'package:wechat/tools/ThemeColors.dart';

class MyInheratite extends StatefulWidget {
  MyInheratite({Key key, this.title}) : super(key: key);

  final String title;

  @override
  _MyInheratiteState createState() => _MyInheratiteState();
}

class _MyInheratiteState extends State<MyInheratite> {
  int _counter = 0;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: new AppBar(
        title: new Text('InheritedWidget',
            style: new TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
      ),
      body: Center(
        child: ShareWidget(
          data: _counter,
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              Padding(
                padding: const EdgeInsets.only(bottom: 20.0),
                child: Text('You have clicked the button this many time:'),
              ),
              Padding(
                padding: const EdgeInsets.only(bottom: 20.0),
                child: _TextWidget(), //子widget中依赖ShareWidget
              ),
              RaisedButton(
                child: Text('Increment'),
                onPressed: () => setState(() => ++_counter),
              ),
              Padding(
                padding: EdgeInsets.only(top: 10.0),
                child: _inhertatiteWidget(context),
              ),
            ],
          ),
        ),
      ),
    );
  }
}

Widget _inhertatiteWidget(BuildContext context) {
  return MaterialButton(
    child: Text("MaterialButton"),
    textTheme: ButtonTextTheme.normal,
    onPressed: () {
      Navigator.push(context, new MaterialPageRoute(builder: (ctx) {
        return ShareMyApp();
      }));
    },
    textColor: Colors.blue,
    disabledTextColor: Colors.red,
    color: Color(0xFF82B1FF),
    disabledColor: Colors.grey,
    highlightColor: Colors.grey,
    colorBrightness: Brightness.light,
    padding: EdgeInsets.all(10),
    shape: RoundedRectangleBorder(
        borderRadius: BorderRadius.all(Radius.circular(20)),
        side:
            BorderSide(color: Colors.grey, style: BorderStyle.solid, width: 2)),
    clipBehavior: Clip.antiAlias,
    materialTapTargetSize: MaterialTapTargetSize.padded,
  );
}

class ShareWidget extends InheritedWidget {
  int data;

  ShareWidget({@required this.data, Widget child}) : super(child: child);

  static ShareWidget of(BuildContext context) {
    //这个方法的作用：获取最近的给定类型（这里的类型是ShareWidget）的Widget，该widget必须是InheritedWidget的子类，并向该widget注册传入的context，当该widget改变时，这个context会重新构建以便从该widget获得新的值。这就是child向InheritedWidget注册的方法。
    return context.inheritFromWidgetOfExactType(ShareWidget);
  }

  @override
  bool updateShouldNotify(ShareWidget oldWidget) {
    return oldWidget.data != data;
  }
}

class _TextWidget extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return _TextWidgetState();
  }
}

class _TextWidgetState extends State<_TextWidget> {
  @override
  Widget build(BuildContext context) {
    return Text(ShareWidget.of(context).data.toString());
  }

/**
   * 如果依赖的InheritedWidget改变了，framework将会调用这个方法来通知这个对象。
   * 在这个方法中调用BuildContext.inheritFromWidgetOfExactType是安全的。
   * 子类很少覆写这个方法，因为framework通常会在依赖的InheritedWidget改变后调用build方法，
   * 覆写这个方法通常用来做一些耗时的工作，比如网络请求
   */
  @override
  void didChangeDependencies() {
    super.didChangeDependencies();
    print("Dependencies change");
  }

  // State对象有一个didChangeDependencies方法，他会在“依赖”发生改变时framework调用。
// 而这里的“依赖”指的就是“是否使用了父Widget中InheritedWidget的数据”，如果使用了，就代表有依赖，如果没有使用，则代表没有依赖。这种依赖也被用于主题的变化等，随着主题的变化，子Widget做出相应的变化

}
