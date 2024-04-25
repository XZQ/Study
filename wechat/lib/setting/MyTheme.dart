import 'package:flutter/material.dart';
import 'package:wechat/bean/event/ThemeEvent.dart';
import 'package:wechat/tools/Constants.dart';
import 'package:wechat/tools/DataUtils.dart';
import 'package:wechat/tools/ThemeColors.dart';

class MyTheme extends StatefulWidget {
  createState() => MyThemeState();
}

class MyThemeState extends State<MyTheme> {
  List<Color> colors = ThemeColors.supportColors;
  Color themeColor = ThemeColors.currentColorTheme;

  changeThemeColor(Color c) {
    Constants.eventBus.fire(ThemeEvent(c));
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('切换主题', style: TextStyle(color: Colors.white)),
        backgroundColor: themeColor,
      ),
      body: Padding(
        padding: const EdgeInsets.all(4.0),
        child: GridView.count(
          crossAxisCount: 4,
          children: List.generate(colors.length, (index) {
            return InkWell(
              onTap: () {
                ThemeColors.currentColorTheme = colors[index];
                DataUtils.setColorTheme(index);
                changeThemeColor(colors[index]);
                setState(() {
                  themeColor = colors[index];
                });
              },
              child: Container(
                color: colors[index],
                margin: const EdgeInsets.all(3.0),
              ),
            );
          }),
        ),
      ),
    );
  }
}
