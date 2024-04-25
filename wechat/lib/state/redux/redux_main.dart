import 'package:flutter/material.dart';
import 'package:flutter_redux/flutter_redux.dart';
import 'package:redux/redux.dart';
import 'package:wechat/state/redux/count_state.dart';
import 'package:wechat/state/redux/top_screen.dart';

class ReduxMain extends StatelessWidget {
  //Store接收一个reducer，以及初始化State，我们想用Redux管理全局的状态的话，需要将store储存在应用的入口才行
  final store =
      Store<CountState>(reducer, initialState: CountState.initState());
  @override
  Widget build(BuildContext context) {
    return StoreProvider<CountState>(
      store: store,
      child: new MaterialApp(
        title: 'Flutter Demo',
        theme: new ThemeData(
          primarySwatch: Colors.blue,
        ),
        home: TopScreen(),
      ),
    );
  }
}
