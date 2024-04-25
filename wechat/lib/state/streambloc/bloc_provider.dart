import 'package:flutter/material.dart';
import 'package:wechat/state/streambloc/blocbase.dart';

class BlocProvider<T extends BlocBase> extends StatefulWidget {
  
  final T bloc;
  final Widget child;

  BlocProvider({Key key, @required this.child, @required this.bloc});

  @override
  _BlocProviderState<T> createState() => _BlocProviderState<T>();

  static T of<T extends BlocBase>(BuildContext context) {
    final type = _typeOf<BlocProvider<T>>();
    BlocProvider<T> provider = context.ancestorWidgetOfExactType(type);
    return provider.bloc;
  }

  static Type _typeOf<T>() => T;
}

class _BlocProviderState<T> extends State<BlocProvider> {
  @override
  Widget build(BuildContext context) {
    return widget.child;
  }

  @override
  void dispose() {
    widget.bloc.dispose();
    super.dispose();
  }
}
