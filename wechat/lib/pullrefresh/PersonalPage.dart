//import 'dart:_http';
import 'dart:async';
import 'dart:convert';
import 'dart:io';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:wechat/bean/DataEntity.dart';
import 'package:wechat/loading/flutter_spinkit.dart';

class PersonalPage extends StatefulWidget {
  PersonalPage({Key key}) : super(key: key);
  @override
  PersonState createState() => new PersonState();
}

class PersonState extends State<PersonalPage> {
  List<Datas> widgets = [];
  ScrollController _scrollController = new ScrollController();

  bool isLoading = false; //是否在加载
  bool isHasNoMore = false; //是否有更多数据
  var currentPage = 0; //当前页
  final int pageSize = 20; //一页的数据条数

  // var _visible = true;

  //这个key用来在不是手动下拉，而是点击某个button或其它操作时，代码直接触发下拉刷新
  final GlobalKey<RefreshIndicatorState> _globalKey =
      new GlobalKey<RefreshIndicatorState>();

  @override
  void initState() {
    super.initState();
    _scrollController.addListener(() {
      if (_scrollController.position.pixels ==
          _scrollController.position.maxScrollExtent) {
        getMoreData();
      }
    });
    loadData(false);
  }

  @override
  Widget build(BuildContext context) {
    return new RefreshIndicator(
      key: _globalKey,
      onRefresh: refreshHelper,
      child: new ListView.builder(
        physics: const AlwaysScrollableScrollPhysics(),
        itemCount: widgets.length + 1,
        controller: _scrollController,
        itemBuilder: (context, index) {
          return getItem(index);
        },
      ),
    );
  }

  Widget getItem(int index) {
    print("${index == widgets.length}");
    if (index == widgets.length) {
      if (isHasNoMore) {
        return loadMoreComplete();
      } else {
        return loadMore();
      }
    } else {
      return itemBuilder(context, index);
    }
  }

  Widget itemBuilder(BuildContext context, int index) {
    return new Container(
      margin: EdgeInsets.all(15.0),
      child: new Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        mainAxisAlignment: MainAxisAlignment.start,
        children: <Widget>[
          new Text(
            "标题: ${widgets[index].title}",
            textAlign: TextAlign.start,
          ),
          new Text(
            "内容: ${widgets[index].link}",
            textAlign: TextAlign.start,
          ),
          new Container(
            margin: EdgeInsets.only(top: 10.0),
            child: new Divider(
              height: 2.0,
            ),
          )
        ],
      ),
    );
  }

  Widget loadMoreComplete() {
    return new Container(
      margin: EdgeInsets.only(top: 12.0, bottom: 25.0),
      alignment: Alignment.center,
      child: new Text("没有更多数据了"),
    );
  }

  Widget loadMore() {
    return new Padding(
      padding: EdgeInsets.all(8.0),
      child: new Center(
        child: new Opacity(
          opacity: isLoading ? 1.0 : 0.0,
          child: new Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              new SpinKitWave(
                color: Colors.blueAccent,
                size: 20.0,
              ),
              new Padding(padding: EdgeInsets.only(left: 10)),
              new Text("正在加载,请稍后...1!")
            ],
          ),
        ),
      ),
    );
  }

  Future<Null> refreshHelper() async {
    final Completer<Null> completer = new Completer<Null>();
    //清空数据
    widgets.clear();
    currentPage = 0;
    loadData(false, completer);
    // return completer.future;
  }

  @override
  void dispose() {
    super.dispose();
    _scrollController.dispose();
  }

  void loadData(bool isLoadMore, [Completer<Null> completer]) async {
    String url =
        "http://www.wanandroid.com/article/list/${currentPage}/json?cid=60";
    if (isLoadMore) {
      setState(() => isLoading = true);
    }

    var httpClient = new HttpClient();
    var request = await httpClient.getUrl(Uri.parse(url));
    var response = await request.close();

    if (response.statusCode == 200) {
      var responseBody = await response.transform(utf8.decoder).join();
      DataEntity entity = DataEntity.fromJson(json.decode(responseBody));
      List<Datas> data = entity.data.datas;

      if (data.length < pageSize) {
        isHasNoMore = true;
      } else {
        isHasNoMore = false;
      }
      if (isLoadMore) {
        setState(() {
          isLoading = false;
          widgets.addAll(data);
        });
      } else {
        setState(() {
          widgets = data;
        });
      }
    } else {
      print("error");
    }
  }

  void getMoreData() {
    if (!isLoading) {
      currentPage++;
      loadData(true);
    }
  }
}

//第一种http  json解析
// final response = await http.get(Uri.parse(url));
//   if (response.statusCode == 200) {
//     DataEntity entity = DataEntity.fromJson(json.decode(response.body));
//     if (entity.data != null &&
//         entity.data.datas != null &&
//         entity.data.datas.isNotEmpty) {
//       if (entity.data.datas.length < pageSize) {
//         isHasNoMore = true;
//       } else {
//         isHasNoMore = false;
//       }
//       if (isLoadMore) {
//         setState(() {
//           isLoading = false;
//           widgets.addAll(entity.data.datas);
//         });
//       } else {
//         setState(() {
//           widgets = entity.data.datas;
//         });
//       }
//     } else {
//       print("ERROR");
//     }

//透明度
// new Center(
//         child: new Opacity(
//           opacity: _visible ? 1.0 : 0.0,
//           child: new Center(
//             child: new GestureDetector(
//               onTap: () {
//                 _visible = _visible ? false : true;
//                 setState(() {});
//               },
//               child: new Text("XZQ",
//                   textDirection: TextDirection.ltr,
//                   style: const TextStyle(
//                       fontWeight: FontWeight.w900,
//                       fontStyle: FontStyle.italic)),
//             ),
//           ),
//         ),
//       ),

//加载框
//  body: new Column(
//         children: <Widget>[
// new SpinKitRotatingPlain(
//   color: Colors.blueAccent,
//   size: 30.0,
// ),
// new SpinKitRotatingCircle(
//   color: Colors.blueAccent,
//   size: 30.0,
// ),
// new SpinKitDoubleBounce(
//   color: Colors.blueAccent,
//   size: 30.0,
// ),
// new SpinKitRing(
//   color: Colors.blueAccent,
//   size: 30.0,
// ),
// new SpinKitWave(
//   color: Colors.blueAccent,
//   size: 30.0,
// ),
// new SpinKitWanderingCubes(
//   color: Colors.blueAccent,
//   size: 30.0,
// ),
// new SpinKitFadingCube(
//   color: Colors.blueAccent,
//   size: 30.0,
// ),
// new SpinKitFadingFour(
//   color: Colors.blueAccent,
//   size: 30.0,
// ),
// new SpinKitPulse(
//   color: Colors.blueAccent,
//   size: 30.0,
// ),
// new SpinKitChasingDots(
//   color: Colors.blueAccent,
//   size: 30.0,
// ),
// new SpinKitHourGlass(
//   color: Colors.blueAccent,
//   size: 30.0,
// ),
// new SpinKitSpinningCircle(
//   color: Colors.blueAccent,
//   size: 30.0,
// ),
//   ],
// ),
