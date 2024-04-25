import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:wechat/tools/ThemeColors.dart';

import 'CountBloc.dart';

class SecondPage extends StatefulWidget {
  @override
  _SecondPageState createState() => _SecondPageState();
}

class _SecondPageState extends State<SecondPage> {
  @override
  @override
  Widget build(BuildContext context) {
    CountBloc bloc = Provider.of<CountBloc>(context);
    return Scaffold(
      appBar: AppBar(
        title:
            Text('Provider3 SecondPage', style: TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
      ),
      body: StreamBuilder(
          stream: bloc.stream,
          initialData: bloc.count,
          builder: (context, snapshot) {
            return Center(child: Text("${snapshot.data}"));
          }),
      floatingActionButton: FloatingActionButton(
        onPressed: () => bloc.add(),
        child: Icon(Icons.add),
      ),
    );
  }
}
