import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:wechat/state/provider/counter_bloc.dart';
import 'package:wechat/state/provider/data_info.dart';
import 'package:wechat/state/provider/provide_multi.dart';
import 'package:wechat/state/provider/provider_single.dart';
import 'package:wechat/state/provider/theme_data_bloc.dart';
import 'package:wechat/tools/ThemeColors.dart';

//https://juejin.im/post/5cdee8a151882525b21a5f9e
class ProviderMain extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: new AppBar(
        title: new Text('Provider', style: new TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
        iconTheme: ThemeData.light().primaryIconTheme,
      ),
      body: Center(
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.center,
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            MaterialButton(
              child: Text("single"),
              onPressed: () {
                // Navigator.push(
                    // context,
                    // new MaterialPageRoute(
                    //     builder: (ctx) => ChangeNotifierProvider(
                    //         builder: (context) => DataInfo(),
                    //         child: ProvideSingle())));
              },
              textTheme: ButtonTextTheme.normal,
              textColor: Colors.red,
              color: Color(0xFF82B1FF),
              minWidth: 120,
            ),
            MaterialButton(
              child: Text("nulti"),
              onPressed: () {
                var counterBloc = CounterBloc();
                var themeDataBloc = ThemeDataBloc();
                Navigator.push(
                    context,
                    new MaterialPageRoute(
                        builder: (ctx) => MultiProvider(
                              providers: [
                                Provider<CounterBloc>.value(value: counterBloc),
                                Provider<ThemeDataBloc>.value(
                                    value: themeDataBloc),
                              ],
                              child: ProvideMulti(),
                            )));
              },
              textTheme: ButtonTextTheme.normal,
              textColor: Colors.blue,
              disabledTextColor: Colors.red,
              color: Color(0xFF82B1FF),
              minWidth: 120,
            ),
          ],
        ),
      ),
    );
  }
}
