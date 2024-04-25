import 'package:flutter/material.dart';
import 'package:wechat/mvvm/HomePageNoMVVM.dart';
import 'package:wechat/mvvm/page_home.dart';
import 'package:wechat/mvvm/viewmodel_home.dart';
import 'package:wechat/mvvm/viewmodel_provider.dart';

class page_router extends StatelessWidget {
  @override
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter MVVM Demo',
      theme: ThemeData(
        primarySwatch: Colors.purple,
      ),
      home: new Column(
        children: <Widget>[
          HomePageNoMVVM(),
          ViewModelProvider(
            viewModel: HomeViewModel(),
            child: HomePage(),
          ),
        ],
      ),
    );
  }
}
