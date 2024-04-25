import 'package:flutter/material.dart';

////http://www.flutterj.com/?post=120
class NestScrollViewHeader extends StatefulWidget {
  @override
  _NestScrollViewHeaderState createState() => _NestScrollViewHeaderState();
}

class _NestScrollViewHeaderState extends State<NestScrollViewHeader> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(),
      body: NestedScrollView(
        headerSliverBuilder: (BuildContext context, bool innerBoxIsScrolled) {
          return <Widget>[
            SliverOverlapAbsorber(
              handle: NestedScrollView.sliverOverlapAbsorberHandleFor(context),
              sliver: SliverAppBar(
                backgroundColor: Color(0xfff1f1f1),
                forceElevated: innerBoxIsScrolled,
                bottom: PreferredSize(child: Container(), preferredSize: Size.fromHeight(100)),
                flexibleSpace: Column(
                  children: <Widget>[],
                ),
              ),
            ),
          ];
        },
      ),
    );
  }
}
