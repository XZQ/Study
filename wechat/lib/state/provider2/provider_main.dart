import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:wechat/tools/ThemeColors.dart';

// 绑定单条数据
class ProviderMain2 extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        title: 'Flutter Demo',
        theme: ThemeData(primarySwatch: Colors.blue),
        debugShowCheckedModeBanner: false,
        home: Provider<String>.value(
            value: 'FirstPage Provider', child: Example()));
  }
}

class Example extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: new AppBar(
        title: new Text('Provider Main',
            style: new TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
        iconTheme: ThemeData.light().primaryIconTheme,
      ),
      body: Center(
        child: Text(Provider.of<String>(context)),
      ),
    );
  }
}
