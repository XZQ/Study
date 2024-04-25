import 'package:flutter/material.dart';

class SpinkitRingView extends StatefulWidget {
  final Color color; //
  final double size; //
  final double lineWidth; //
  final Duration duration; //

  const SpinkitRingView({
    Key key,
    @required this.color,
    this.size = 50.0,
    this.lineWidth = 7.0,
    this.duration = const Duration(milliseconds: 1200),
  })  : assert(color != null),
        assert(size != null),
        assert(lineWidth != null),
        super(key: key);

  SpinkitRingViewState createState() => new SpinkitRingViewState();
}

class SpinkitRingViewState extends State<SpinkitRingView> {
  @override
  Widget build(BuildContext context) {
    return new Scaffold();
  }
}
