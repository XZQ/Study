import 'package:flutter/material.dart';
import 'package:flutter_swiper/flutter_swiper.dart';

//https://juejin.im/post/5d8f0ad6e51d45780f0604c8
class NotificationTest extends StatefulWidget {
  @override
  _NotificationTestState createState() => _NotificationTestState();
}

class _NotificationTestState extends State<NotificationTest> {
  final int DEFAULT_SCROLLER = 300;
  double toolbarOpacity = 0.0;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Stack(
        children: <Widget>[
          MediaQuery.removePadding(
            removeTop: true,
            context: context,
            child: NotificationListener(
              onNotification: (notification) {
                if (notification is ScrollUpdateNotification &&
                    notification.depth == 0) {
                  double t = notification.metrics.pixels / DEFAULT_SCROLLER;
                  //
                  // print(metrics.pixels); // 当前位置
                  // print(metrics.atEdge); //是否在顶部或底部
                  // print(metrics.axis); //垂直或水平滚动
                  // print(metrics.axisDirection); // 滚动方向是down还是up
                  // print(metrics.extentAfter); //视口底部距离列表底部有多大
                  // print(metrics.extentBefore); //视口顶部距离列表顶部有多大
                  // print(metrics.extentInside); //视口范围内的列表长度
                  // print(metrics.maxScrollExtent); //最大滚动距离，列表长度-视口长度
                  // print(metrics.minScrollExtent); //最小滚动距离
                  // print(metrics.viewportDimension); //视口长度
                  // print(metrics.outOfRange); //是否越过边界
                  //
                  if (t < 0.0) {
                    t = 0.0;
                  } else if (t > 1.0) {
                    t = 1.0;
                  }
                  setState(() {
                    toolbarOpacity = t;
                  });

                  print(notification.metrics.pixels); //打印滚动位置
                }
                return true;
              },
              child: ListView.builder(
                itemCount: 100,
                itemBuilder: (context, index) {
                  if (index == 0) {
                    return Container(
                      height: 200,
                      child: Swiper(
                        itemBuilder: (BuildContext context, int index) {
                          return new Image.network(
                            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1571055811173&di=54820133a66f4a2e21f42bb53e0dfd38&imgtype=0&src=http%3A%2F%2Fimg.juimg.com%2Ftuku%2Fyulantu%2F110329%2F23-11032ZJ33574.jpg",
                            fit: BoxFit.fill,
                          );
                        },
                        itemCount: 3,
                        autoplay: true,
                        pagination: new SwiperPagination(),
                      ),
                    );
                  }
                  return ListTile(
                    title: Text("ListTile:$index"),
                  );
                },
              ),
            ),
          ),
          Opacity(
            opacity: toolbarOpacity,
            child: Container(
              height: 98,
              color: Colors.blue,
              child: Padding(
                padding: const EdgeInsets.only(top: 30.0),
                child: Center(
                  child: Text(
                    "NotificationListenerDemo",
                    style: TextStyle(color: Colors.white, fontSize: 20.0),
                  ),
                ),
              ),
            ),
          )
        ],
      ),
    );
  }
}
