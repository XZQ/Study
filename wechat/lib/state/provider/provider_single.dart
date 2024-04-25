import 'package:flutter/material.dart';
import 'package:wechat/state/provider/data_info.dart';
import 'package:wechat/state/provider/provider_page.dart';
import 'package:wechat/tools/ThemeColors.dart';
import 'package:provider/provider.dart';

class ProvideSingle extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    var dataInfo = Provider.of<DataInfo>(context);
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: MyHomePage(),
      theme: dataInfo.themeData,
    );
  }
}

class MyHomePage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    var dataInfo = Provider.of<DataInfo>(context);
    return Scaffold(
      appBar: new AppBar(
        title: new Text('Provider Single',
            style: new TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
        iconTheme: ThemeData.light().primaryIconTheme,
      ),
      body: Center(
          child: Column(
        mainAxisSize: MainAxisSize.min,
        children: <Widget>[
          IconButton(
              icon: Icon(Icons.add),
              onPressed: () {
                dataInfo.addCount();
              }),
          Chip(
            label: Text(
              dataInfo.count.toString(),
              style: TextStyle(fontSize: 30.0),
            ),
            padding: EdgeInsets.all(12.0),
          ),
          IconButton(
              icon: Icon(Icons.remove),
              onPressed: () {
                dataInfo.subCount();
              }),
          RaisedButton(
            onPressed: () {
              Navigator.of(context).push(
                  MaterialPageRoute(builder: (context) => ProviderPage()));
            },
            child: Text('Page 2'),
          )
        ],
      )),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          dataInfo.changeTheme();
        },
        child: Icon(
          Icons.build,
          color: Colors.white,
        ),
      ),
    );
  }
}
