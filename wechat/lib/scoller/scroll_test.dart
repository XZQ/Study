import 'package:flutter/material.dart';
import 'package:flutter_swiper/flutter_swiper.dart';

class ScrollTest extends StatefulWidget {
  @override
  _scroll_testState createState() => _scroll_testState();
}

class _scroll_testState extends State<ScrollTest> {
  //
  final int DEFAULT_SCROLLER = 300;
  final int DEFAULT_SHOW_TOP_BTN = 1000;
  double toolbarOpacity = 0.0;
  ScrollController _controller = new ScrollController();
  bool showToTopBtn = false;

  @override
  void initState() {
    super.initState();
    _controller.addListener(() {
      double t = _controller.offset / DEFAULT_SCROLLER;
      if (t < 0.0) {
        t = 0.0;
      } else if (t > 1.0) {
        t = 1.0;
      }
      setState(() {
        toolbarOpacity = t;
      });

      if (_controller.offset < DEFAULT_SHOW_TOP_BTN && showToTopBtn) {
        setState(() {
          showToTopBtn = false;
        });
      } else if (_controller.offset >= DEFAULT_SHOW_TOP_BTN && !showToTopBtn) {
        setState(() {
          showToTopBtn = true;
        });
      }

      print(_controller.offset); //打印滚动位置
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Stack(
        children: <Widget>[
          MediaQuery.removePadding(
            removeTop: true,
            context: context,
            child: ListView.builder(
              controller: _controller,
              itemCount: 100,
              itemBuilder: (BuildContext context, int index) {
                if (index == 0) {
                  return Container(
                    height: MediaQuery.of(context).size.height / 4,
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
          Opacity(
            opacity: toolbarOpacity,
            child: Container(
              height: 60,
              color: Colors.blue,
              child: Padding(
                padding: const EdgeInsets.only(top: 30.0),
                child: Center(
                  child: Text(
                    "ScrollerDemo",
                    style: TextStyle(color: Colors.white, fontSize: 20.0),
                  ),
                ),
              ),
            ),
          )
        ],
      ),
      floatingActionButton: !showToTopBtn
          ? null
          : FloatingActionButton(
              child: Icon(Icons.keyboard_arrow_up),
              onPressed: () {
                _controller.animateTo(0.0,
                    duration: Duration(milliseconds: 500), curve: Curves.ease);
              },
            ),
    );
  }

  @override
  void dispose() {
    _controller.dispose();
    super.dispose();
  }
}
