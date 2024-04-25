import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:wechat/state/provider2/user.dart';
import 'package:wechat/tools/ThemeColors.dart';

class ChangeNotifierProviderMain extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return ChangeNotifierProvider<User>.value(
        value: User('Flutter', 0),
        child: MaterialApp(
            title: 'Flutter Demo',
            debugShowCheckedModeBanner: false,
            theme: ThemeData(primarySwatch: ThemeColors.currentColorTheme),
            home: MyHomePage()));
  }
}

class MyHomePage extends StatefulWidget {
  @override
  _ChangeNotifierProviderMainState createState() =>
      _ChangeNotifierProviderMainState();
}

class _ChangeNotifierProviderMainState extends State<MyHomePage> {
  TextEditingController _controller = new TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Provider', style: new TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
      ),
      body: Center(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: <Widget>[
            Padding(
              padding: EdgeInsets.all(10.0),
            ),
            Text('${Provider.of<User>(context).getName}   ' +
                '${Provider.of<User>(context).getAge.toString()}'),

            Padding(
              padding: EdgeInsets.all(10.0),
            ),
            // 获取 Provider 数据
            Expanded(
                child: TextField(
                    controller: _controller,
                    onChanged: (changed) =>
                        Provider.of<User>(context).setName(changed),
                    decoration: InputDecoration(
                        hintText: '请输入用户名',
                        suffixIcon: IconButton(
                            icon: Icon(Icons.clear, color: Colors.black45),
                            onPressed: () {
                              _controller.clear();
                            })))),
          ],
        ),
      ),
    );
  }
}
