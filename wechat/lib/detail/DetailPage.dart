import 'package:flutter/material.dart';

class DetailPage extends StatefulWidget {
  createState() =>  DetailPageState();
}

class DetailPageState extends State<DetailPage> {
  @override
  Widget build(BuildContext context) {
    return  Scaffold(
      // appBar:  AppBar(title:  Text("")),
      body:  Container(
        alignment: Alignment.bottomCenter,
        child:  TextField(),
      ),
    );
  }
}
