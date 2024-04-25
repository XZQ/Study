import 'package:flutter/material.dart';
import 'package:wechat/state/bloc/global/count_bloc.dart';
import 'package:wechat/tools/ThemeColors.dart';
import 'under_page.dart';

class GlobalMian extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Top page', style: new TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
        iconTheme: ThemeData.light().primaryIconTheme,
      ),
      body: Center(
        child: StreamBuilder<int>(
            stream: bLoC.stream,
            initialData: bLoC.value,
            builder: (BuildContext context, AsyncSnapshot<int> snapshot) {
              return Text(
                'You hit me: ${snapshot.data} times',
              );
            }),
      ),
      floatingActionButton: FloatingActionButton(
          child: Icon(Icons.add),
          onPressed: () => Navigator.push(
              context, new MaterialPageRoute(builder: (ctx) => UnderPage()))),
    );
  }
}
