import 'package:flutter/material.dart';
import 'package:wechat/state/provider/counter_bloc.dart';
import 'package:wechat/state/provider/mutli_page.dart';
import 'package:wechat/state/provider/theme_data_bloc.dart';
import 'package:provider/provider.dart';
import 'package:wechat/tools/ThemeColors.dart';

class ProvideMulti extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return StreamBuilder(
      builder: (context, snapshot) {
        return MaterialApp(
          home: MyHomePage(),
          color: ThemeColors.currentColorTheme,
          debugShowCheckedModeBanner: false,
        );
      },
      initialData: ThemeData.light(),
      stream: Provider.of<ThemeDataBloc>(context).stream,
    );
  }
}

class MyHomePage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Multi Provider Demo'),
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
                RaisedButton(
                  onPressed: () {
                    Navigator.of(context).push(
                        MaterialPageRoute(builder: (context) => MutliPage()));
                  },
                  child: Text('Page 2'),
                )
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
