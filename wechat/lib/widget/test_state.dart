import 'package:flutter/material.dart';
import 'package:wechat/tools/ThemeColors.dart';

class TestState extends StatefulWidget {
  @override
  _TestMainState createState() => _TestMainState();
}

class _TestMainState extends State<TestState> {
  String value = "init";

  @override
  Widget build(BuildContext context) {
    print("================================================= 10 $value");

    return Scaffold(
      ///
      appBar: AppBar(
        title: Text('TestState', style: TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
      ),

      ///
      body: StatePage(value),

      ///
      floatingActionButton: FloatingActionButton(
        child: Icon(Icons.add),
        onPressed: () {
          setState(() {
            value = "change setState";
          });
        },
      ),

      ///
    );
  }
}

class StatePage extends StatefulWidget {
  final String data;

  StatePage(this.data);

  @override
  _StatePage createState() => _StatePage();
}

class _StatePage extends State<StatePage> {
  @override
  Widget build(BuildContext context) {
    print("=================================================  2 ${widget.data}");
    return Center(child: Text(widget.data ?? ""));
  }
}
