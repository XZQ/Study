import 'package:flutter/material.dart';
import 'package:dio/dio.dart';
import 'dart:convert';

import 'package:wechat/bean/MoviebeanEntity.dart';

class MovieList extends StatefulWidget {
  String movieType = "in_theaters";
  MovieList({Key key, this.movieType}) : super(key: key);
  @override
  State<StatefulWidget> createState() {
    return new MovieListState(movieType: "in_theaters");
  }
}

class MovieListState extends State<MovieList> {
  String movieType;
  String typeName;
  List<Subjects> movieList = new List();
  int currentPage = 0; //第一页
  int pageSize = 10; //页容量
  int totalSize = 0; //总条数
  String loadMoreText = "没有更多数据";
  TextStyle loadMoreTextStyle =new TextStyle(color: const Color(0xFF999999), fontSize: 14.0);
  TextStyle titleStyle = new TextStyle(color: const Color(0xFF757575), fontSize: 14.0);
  ScrollController _controller = new ScrollController();

  MovieListState({Key key, this.movieType}) {
    _controller.addListener(() {
      var maxScroll = _controller.position.maxScrollExtent;
      var pixel = _controller.position.pixels;
      if (maxScroll == pixel && movieList.length < totalSize) {
        setState(() {
          loadMoreText = "正在加载中...";
          loadMoreTextStyle =
              new TextStyle(color: const Color(0xFF4483f6), fontSize: 14.0);
        });
        loadMoreData();
      } else {
        setState(() {
          loadMoreText = "没有更多数据";
          loadMoreTextStyle =
              new TextStyle(color: const Color(0xFF999999), fontSize: 14.0);
        });
      }
    });
  }

  //加载列表数据
  loadMoreData() async {
    this.currentPage++;
    var start = (currentPage - 1) * pageSize;
    var url =
        "https://api.douban.com/v2/movie/$movieType?start=$start&count=$pageSize";
    print("URL= " + url);
    Dio dio = new Dio();
    Response response = await dio.get(url);
    if (response.statusCode == 200) {
      MoviebeanEntity entity =
          MoviebeanEntity.fromJson(json.decode(response.toString()));
      setState(() {
        totalSize = entity.total;
        movieList.addAll(entity.subjects);
      });
    }
  }

  @override
  void initState() {
    super.initState();
    switch (movieType) {
      case "in_theaters":
        typeName = "正在热映";
        break;
      case "coming_soon":
        typeName = "即将上映";
        break;
      case "top250":
        typeName = "Top250";
        break;
    }

    loadMoreData();
  }

  Future _pullToRefresh() async {
    currentPage = 0;
    movieList.clear();
    loadMoreData();
    return null;
  }

  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      backgroundColor: Colors.white,
      body: movieList.length == 0
          ? new Center(child: new CircularProgressIndicator())
          : new RefreshIndicator(
              color: const Color(0xFF4483f6),
              child: ListView.builder(
                itemCount: movieList.length + 1,
                itemBuilder: (context, index) {
                  if (index == movieList.length) {
                    return _buildProgressMoreIndicator();
                  } else {
                    return renderRow(index, context);
                  }
                },
                controller: _controller, //指明控制器加载更多使用
              ),
              onRefresh: _pullToRefresh,
            ),
    );
  }

  Widget _buildProgressMoreIndicator() {
    return new Padding(
      padding: const EdgeInsets.all(15.0),
      child: new Center(
        child: new Text(loadMoreText, style: loadMoreTextStyle),
      ),
    );
  }

  renderRow(index, context) {
    return new Container(
        color: Colors.white,
        child: new InkWell(
          child: new Column(
            children: <Widget>[
              new Container(
                height: 140,
                child: new Row(
                  children: <Widget>[
                    new Container(
                      padding: EdgeInsets.fromLTRB(0, 6.0, 0, 6.0),
                      width: 120.0,
                      child: Image.network(movieList[index].images.small),
                    ),
                    Expanded(
                      child: new Container(
                        child: new Column(
                          mainAxisAlignment: MainAxisAlignment.spaceAround,
                          crossAxisAlignment: CrossAxisAlignment.start,
                          children: <Widget>[
                            new Text(
                              "电影名称：${movieList[index].title}",
                              style: titleStyle,
                              overflow: TextOverflow.ellipsis,
                            ),
                            new Text(
                              "电影类型：${movieList[index].genres}",
                              style: titleStyle,
                              overflow: TextOverflow.ellipsis,
                            ),
                            new Text(
                              "上映年份：${movieList[index].year}",
                              style: titleStyle,
                              overflow: TextOverflow.ellipsis,
                            ),
                            new Text(
                              "豆瓣评分：${movieList[index].rating.average}",
                              style: titleStyle,
                              overflow: TextOverflow.ellipsis,
                            )
                          ],
                        ),
                      ),
                    ),
                  ],
                ),
              ),
              //分割线
              new Divider(height: 1)
            ],
          ),
        ));
  }
}
