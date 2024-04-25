import 'package:flutter/material.dart';
import 'package:wechat/state/streambloc/bloc_provider.dart';
import 'package:wechat/state/streambloc/increment_bloc.dart';
import 'package:wechat/tools/ThemeColors.dart';

//https://blog.csdn.net/yumi0629/article/details/82759447
class StreamBlocMain extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return new MaterialApp(
      title: 'Streams Demo',
      theme: new ThemeData(
        primarySwatch: ThemeColors.currentColorTheme,
      ),
      home: BlocProvider<IncrementBloc>(
        bloc: IncrementBloc(),
        child: CounterPage(),
      ),
    );
  }
}

class CounterPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final IncrementBloc counterBloc = BlocProvider.of<IncrementBloc>(context);
    // final ApplicationBloc appBloc = BlocProvider.of<ApplicationBloc>(context);
  }
}
