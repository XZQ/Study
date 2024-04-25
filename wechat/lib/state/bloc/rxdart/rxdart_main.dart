import 'package:flutter/material.dart';
import 'package:wechat/state/bloc/scoped/bloc_provider.dart';
import 'package:wechat/tools/ThemeColors.dart';
import 'under_page.dart';

class RxdartMain extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return BlocProvider(
      child: MaterialApp(
        home: TopPage(context),
      ),
    );
  }
}

class TopPage extends StatelessWidget {
  TopPage(BuildContext context);
  @override
  Widget build(BuildContext context) {
    final bloc = BlocProvider.of(context);

    return Scaffold(
      appBar: AppBar(
        title: new Text('Rxdart', style: new TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
      ),
      body: Center(
        child: StreamBuilder<int>(
            stream: bloc.stream,
            initialData: bloc.value,
            builder: (BuildContext context, AsyncSnapshot<int> snapshot) {
              return Text(
                'You hit me: ${snapshot.data} times',
                style: Theme.of(context).textTheme.display1,
              );
            }),
      ),
      floatingActionButton: FloatingActionButton(
          child: Icon(Icons.navigate_next),
          onPressed: () => Navigator.push(
              context, MaterialPageRoute(builder: (context) => UnderPage()))),
    );
  }
}
