import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:wechat/state/provider/counter_bloc.dart';
import 'package:wechat/state/provider/theme_data_bloc.dart';
import 'package:wechat/tools/ThemeColors.dart';

class MutliPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: new AppBar(
        title: new Text('Provider Single',
            style: new TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
        iconTheme: ThemeData.light().primaryIconTheme,
      ),
      body: Center(
        child: StreamBuilder(
          builder: (context, snapshot) {
            return Column(
              mainAxisSize: MainAxisSize.min,
              children: <Widget>[
                IconButton(
                    icon: Icon(Icons.add),
                    onPressed: () {
                      Provider.of<CounterBloc>(context).addCounter();
                    }),
                Chip(
                  padding: EdgeInsets.all(12.0),
                  label: Text(
                    snapshot.data.toString(),
                    style: TextStyle(fontSize: 30.0),
                  ),
                ),
                IconButton(
                    icon: Icon(Icons.remove),
                    onPressed: () {
                      Provider.of<CounterBloc>(context).subCounter();
                    }),
              ],
            );
          },
          initialData: Provider.of<CounterBloc>(context).count,
          stream: Provider.of<CounterBloc>(context).stream,
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          Provider.of<ThemeDataBloc>(context).changeTheme();
        },
        child: Icon(
          Icons.build,
          color: Colors.white,
        ),
      ),
    );
  }
}
