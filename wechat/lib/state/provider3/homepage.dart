import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:wechat/state/provider3/CountBloc.dart';
import 'package:wechat/state/provider3/second_page.dart';
import 'package:wechat/tools/ThemeColors.dart';

class HomePage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Provider3 HomePage', style: TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
      ),
      body: StreamBuilder(
          stream: Provider.of<CountBloc>(context).stream,
          initialData: 0,
          builder: (context, snapshot) {
            return Center(child: Text("${snapshot.data}"));
          }),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          Navigator.push(context, MaterialPageRoute(builder: (context) => SecondPage()));
        },
        child: Icon(Icons.arrow_forward_ios),
      ),
    );
  }
}
