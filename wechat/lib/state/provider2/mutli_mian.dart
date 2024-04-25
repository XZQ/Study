import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:wechat/state/provider2/user.dart';
import 'package:wechat/tools/ThemeColors.dart';

// 聚合方式
class MutliMian extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primaryColor: Colors.green,
      ),
      debugShowCheckedModeBanner: false,
      home: MultiProvider(providers: [
        Provider<User>.value(value: new User('Flutter', '300')),
        Provider<int>.value(value: 200),
        Provider<bool>.value(value: false)
      ], child: MyHomePage()),
    );
  }
}

class MyHomePage extends StatefulWidget {
  //
  final String title;
  //
  MyHomePage({Key key, this.title}) : super(key: key);

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('聚合绑定', style: new TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
      ),
      body: Center(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: <Widget>[
            //
            Text(Provider.of<bool>(context).toString()),
            Padding(
              padding: EdgeInsets.all(10.0),
            ),
            //
            Text('${Provider.of<int>(context).toString()}',
                style: TextStyle(color: Colors.redAccent)),
            Padding(
              padding: EdgeInsets.all(10.0),
            ),
            //
            Text('${Provider.of<User>(context).name.toString()}'),
          ],
        ),
      ),
    );
  }
}
