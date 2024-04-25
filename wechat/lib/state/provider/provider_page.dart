import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:wechat/state/provider/data_info.dart';
import 'package:wechat/tools/ThemeColors.dart';

class ProviderPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Provider Page', style: TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
        iconTheme: ThemeData.light().primaryIconTheme,
      ),
      body: Consumer<DataInfo>(
        builder: (context, dataInfo, _) => Center(
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
              ],
            )),
      ),
      floatingActionButton: Consumer<DataInfo>(
        builder: (context, dataInfo, _) => FloatingActionButton(
              onPressed: () {
                dataInfo.changeTheme();
              },
              child: Icon(
                Icons.build,
                color: Colors.white,
              ),
            ),
      ),
    );
  }
}
