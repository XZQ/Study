import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:wechat/state/provider3/CountBloc.dart';
import 'package:wechat/state/provider3/homepage.dart';
import 'package:wechat/tools/ThemeColors.dart';

class Provider3App extends StatefulWidget {
  @override
  _Provider3AppState createState() => _Provider3AppState();
}

class _Provider3AppState extends State<Provider3App> {
  @override
  Widget build(BuildContext context) {
    return Provider<CountBloc>(
      // builder: (context) => CountBloc(),
      //dispose:在widget销毁的时候调用，方便关闭stream，可以防止内存泄露
      //特别是在在StatelessWidget中使用非常好，因为StatelessWidget没有dispose方法
      dispose: (context, value) => value.dispose(),

      child: MaterialApp(
        debugShowCheckedModeBanner: false,
        title: "provider",
        color: ThemeColors.currentColorTheme,
        home: HomePage(),
      ),
    );
  }
}
