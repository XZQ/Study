import 'package:flutter/material.dart';
import 'package:wechat/tools/ThemeColors.dart';

class SearchAll extends StatefulWidget {
  @override
  _SearchAllState createState() => _SearchAllState();
}

class _SearchAllState extends State<SearchAll> {
  Paint _paint = Paint()
    ..isAntiAlias = true
    ..color = Colors.red
    ..strokeWidth = 5;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Flutter Drawer'),
      ),
      body: Padding(
        padding: EdgeInsetsDirectional.only(start: 50),
        child: RichText(
          maxLines: 2,
          overflow: TextOverflow.ellipsis,
          text: TextSpan(children: [
            WidgetSpan(
                child: Container(
              alignment: Alignment.center,
              height: 14,
              width: 47,
              padding: EdgeInsetsDirectional.only(start: 3, end: 3),
              decoration: BoxDecoration(
                gradient: LinearGradient(
                  begin: Alignment.bottomCenter,
                  end: Alignment.topCenter,
                  colors: [ThemeColors.yellowFF2474, ThemeColors.yellowFF4F00],
                ),
                borderRadius: BorderRadius.circular(1.5),
              ),
              child: Text(
                "Flash Deal",
                style: TextStyle(color: ThemeColors.white, fontSize: 8),
              ),
            )),

            TextSpan(text: "我爱爱习我爱学习我爱学习我爱 爱学习我爱学习我爱学习我学习我爱学习我爱学习", style: TextStyle(color: Colors.red, fontSize: 12), semanticsLabel: "这是Flutter")

            // WidgetSpan(
            //     child: Padding(
            //   padding: EdgeInsetsDirectional.only(start: 3),
            //   child: Text("我爱爱习我爱学习我爱学我爱爱习我爱学习我爱学习我爱我爱爱习我爱学习我爱学习我爱习我爱", style: TextStyle(color: Colors.red, fontSize: 12)),
            // )),
          ]),
        ),
      ),
    );
  }
}

class MyPainter extends CustomPainter {
  @override
  void paint(Canvas canvas, Size size) {
    var paint = Paint()
      ..isAntiAlias = true
      ..strokeWidth = 1.0
      ..style = PaintingStyle.fill
      ..color = Colors.green
      ..invertColors = false;
    Rect rect = Rect.fromPoints(Offset(size.width / 2, 0), Offset(0.0, size.height / 2));
    canvas.drawRect(rect, paint);
    rect = Rect.fromPoints(Offset(size.width / 3, 0), Offset(0.0, size.height / 3));
    canvas.drawRect(rect, paint..color = Colors.red);
    rect = Rect.fromPoints(Offset(0, 0), Offset(size.width / 4, size.height / 4));
    canvas.drawRect(rect, paint..color = Colors.blue);
  }

  //在实际场景中正确利用此回调可以避免重绘开销，本示例我们简单的返回true
  @override
  bool shouldRepaint(CustomPainter oldDelegate) => true;
}
