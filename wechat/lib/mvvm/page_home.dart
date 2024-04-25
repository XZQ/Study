import 'package:flutter/material.dart';
import 'package:wechat/mvvm/viewmodel_home.dart';
import 'package:wechat/mvvm/viewmodel_provider.dart';
import 'package:wechat/tools/ThemeColors.dart';

class HomePage extends StatefulWidget {
  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  HomeViewModel _viewModel;

  @override
  void initState() {
    super.initState();
    _viewModel = ViewModelProvider.of(context);
    _viewModel.init(context);
  }

  @override
  void dispose() {
    _viewModel.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: new AppBar(
        title: new Text('Plugin', style: new TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
      ),
      body: Center(
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.center,
          children: <Widget>[
            RaisedButton(
              child: Text("点击重新获取网络数据"),
              onPressed: () {
                _viewModel.refreshData(context);
              },
            ),
            Expanded(
              child: SingleChildScrollView(
                child: StreamBuilder(
                  stream: _viewModel.dataStream,
                  builder: (BuildContext context, AsyncSnapshot<String> snapshot) {
                    if (snapshot.connectionState == ConnectionState.waiting) {
                      return Center(
                        child: CircularProgressIndicator(),
                      );
                    }
                    return Text(
                      "${snapshot.hasError ? snapshot.error : snapshot.data}",
                    );
                  },
                ),
              ),
            ),
            Offstage(),
          ],
        ),
      ),
    );
  }
}
