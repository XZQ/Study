import 'package:flutter/material.dart';

abstract class MyStatelessWidget extends StatelessWidget {
  const MyStatelessWidget({Key key}) : super(key: key);

  // @override
  // Element createElement() => StatelessElement(this);

  Widget build(BuildContext context);
}
