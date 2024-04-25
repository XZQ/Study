import 'package:flutter/material.dart';
import 'package:wechat/tools/ThemeColors.dart';

import 'ListItem.dart';
import 'class_bean.dart';

//https://www.jianshu.com/p/9830b1a6ae1f
//https://blog.csdn.net/hao_m582/article/details/84112278
class ListviewDemo extends StatefulWidget {
  @override
  _ListviewDemoState createState() => _ListviewDemoState();
}

class _ListviewDemoState extends State<ListviewDemo> {
  var items =
      List<ListItem>.generate(120, (it) => it % 6 == 0 ? HeadingItem("Heading $it") : MessageItem("Sender $it", "Message body $it"));

  var list = List<BaseBean>.generate(60, (i) => BaseBean("name$i", i, "content=$i"));

  int i = 1;

  @override
  Widget build(BuildContext context) {
    ClassBean _people = ModalRoute.of(context).settings.arguments;
    return new Scaffold(
      appBar: AppBar(
        title: Text(getTitle(_people?.dex), style: TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
        elevation: 0.0,
      ),
      body: consructor(context, _people?.dex),
    );
  }

  getTitle(int i) {
    if (i == 1) {
      return "滑动删除";
    } else if (i == 2) {
      return "builder模式";
    } else if (i == 3) {
      return "separated模式";
    } else if (i == 4) {
      return "default模式";
    } else if (i == 5) {
      return "ListTile模式";
    } else if (i == 6) {
      return "listViewLayoutBuilder模式";
    } else if (i == 7) {
      return "listViewLayoutSeparated模式";
    } else if (i == 8) {
      return "listViewLayoutCustom模式";
    }
  }

  consructor(BuildContext context, int i) {
    if (i == 1) {
      return dismissibleWidget(context);
    } else if (i == 2) {
      return listviewBuilder(context);
    } else if (i == 3) {
      return listviewSeparated(context);
    } else if (i == 4) {
      return listViewDefault(context);
    } else if (i == 5) {
      return listViewListTile(list);
    } else if (i == 6) {
      return listViewLayoutBuilder(list);
    } else if (i == 7) {
      return listViewLayoutSeparated(list);
    } else if (i == 8) {
      return listViewLayoutCustom(list);
    }
  }

  //滑动删除
  //https://mp.weixin.qq.com/s/UWx_5fr9lZTSKWfONv2anQ
  //https://juejin.im/post/5d35660ae51d4555fd20a421
  Widget dismissibleWidget(BuildContext context) {
    return new ListView.builder(
      itemCount: items.length,
      itemBuilder: (context, index) {
        var item1 = items[index];
        return Dismissible(
          key: Key(item1.toString()),
          onDismissed: (direction) {
            var _snackStr;
            if (direction == DismissDirection.endToStart) {
              _snackStr = '删除了${items[index]}';
            } else if (direction == DismissDirection.startToEnd) {
              _snackStr = '收藏了${items[index]}';
            }
            Scaffold.of(context).showSnackBar(SnackBar(
              content: Text(_snackStr),
            ));
            setState(() {
              items.removeAt(index);
            });
          },
          background: new Container(
            color: Colors.red,
            child: ListTile(
              leading: Icon(
                Icons.bookmark,
                color: Colors.white,
              ),
              trailing: Icon(
                Icons.delete,
                color: Colors.white,
              ),
            ),
          ),
          secondaryBackground: Container(
            color: Colors.red,
            child: ListTile(
              trailing: Icon(
                Icons.ac_unit,
                color: Colors.white,
              ),
            ),
          ),
          child: ListTile(title: Text('$item1')),
        );
      },
    );
  }

  Widget listviewSeparated(BuildContext context) {
    return new ListView.separated(
        itemCount: 40,
        itemBuilder: (BuildContext context, int index) {
          return new Padding(
            padding: EdgeInsets.all(10),
            child: new Text("text $index"),
          );
        },
        separatorBuilder: (BuildContext context, int index) {
          return new Container(height: 1.0, color: Colors.grey[200]);
        });
  }

// ListView.builder
  Widget listviewBuilder(BuildContext context) {
    return new ListView.builder(
      itemCount: items.length,
      // itemBuilder: (context, index) {
      //   return new ListTile(
      //     contentPadding: EdgeInsets.all(1.0),
      //     title: new Text('${items[index]}'),
      //   );
      // },
      itemBuilder: (context, index) {
        final item = items[index];
        if (item is HeadingItem) {
          return new ListTile(
            title: new Text(
              item.heading,
              style: Theme.of(context).textTheme.headline,
            ),
          );
        } else if (item is MessageItem) {
          return new ListTile(
            title: new Text(item.sender),
            subtitle: new Text(item.body),
          );
        }
      },
    );
  }

  ///默认构建
  Widget listViewDefault(BuildContext context) {
    List<Widget> _list = new List();
    for (int i = 0; i < list.length; i++) {
      _list.add(new Center(
        child: new Padding(
          padding: EdgeInsets.all(10),
          child: new Text(list[i].age.toString()),
        ),
      ));
    }

// 添加分割线
    var divideList = ListTile.divideTiles(context: context, tiles: _list).toList();
    return new Scrollbar(
      child: new ListView(
        // children: _list, // 无分割线
        children: divideList, // 添加分割线/
      ),
    );
  }

  /// ListTile
  Widget listViewListTile(List<BaseBean> list) {
    List<Widget> _list = new List();
    for (int i = 0; i < list.length; i++) {
      _list.add(new Center(
        child: ListTile(
          leading: new Icon(Icons.list),
          title: new Text(list[i].name),
          trailing: new Icon(Icons.keyboard_arrow_right),
        ),
      ));
    }
    return new ListView(
      children: _list,
    );
  }

  ///listView builder 构建
  Widget listViewLayoutBuilder(List<BaseBean> list) {
    return ListView.builder(
        //设置滑动方向 Axis.horizontal 水平  默认 Axis.vertical 垂直
        scrollDirection: Axis.vertical,
        //内间距
        padding: EdgeInsets.all(10.0),
        //是否倒序显示 默认正序 false  倒序true
        reverse: false,
        //false，如果内容不足，则用户无法滚动 而如果[primary]为true，它们总是可以尝试滚动。
        primary: true,
        //确定每一个item的高度 会让item加载更加高效
        itemExtent: 50.0,
        //item 高度会适配 item填充的内容的高度 多用于嵌套listView中 内容大小不确定 比如 垂直布局中 先后放入文字 listView （需要Expend包裹否则无法显示无穷大高度 但是需要确定listview高度 shrinkWrap使用内容适配不会） 文字
        shrinkWrap: true,
        //item 数量
        itemCount: list.length,
        //滑动类型设置
        //new AlwaysScrollableScrollPhysics() 总是可以滑动 NeverScrollableScrollPhysics禁止滚动 BouncingScrollPhysics 内容超过一屏 上拉有回弹效果 ClampingScrollPhysics 包裹内容 不会有回弹
//        cacheExtent: 30.0,  //cacheExtent  设置预加载的区域   cacheExtent 强制设置为了 0.0，从而关闭了“预加载”
        physics: new ClampingScrollPhysics(),
        //滑动监听
//        controller ,
        itemBuilder: (context, i) => new Container(
              child: new Row(
                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                children: <Widget>[
                  new Text(
                    "${list[i].name}",
                    style: new TextStyle(fontSize: 18.0, color: Colors.red),
                  ),
                  new Text(
                    "${list[i].age}",
                    style: new TextStyle(fontSize: 18.0, color: Colors.green),
                  ),
                  new Text(
                    "${list[i].content}",
                    style: new TextStyle(fontSize: 18.0, color: Colors.blue),
                  ),
                ],
              ),
            ));
  }

  ///listView custom 构建
  Widget listViewLayoutCustom(List<BaseBean> list) {
    return ListView.custom(
      itemExtent: 40.0,
      childrenDelegate: MyChildrenDelegate(
        (BuildContext context, int i) {
          return new Container(
              child: new Row(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: <Widget>[
              new Text(
                "${list[i].name}",
                style: new TextStyle(fontSize: 18.0, color: Colors.red),
              ),
              new Text(
                "${list[i].age}",
                style: new TextStyle(fontSize: 18.0, color: Colors.green),
              ),
              new Text(
                "${list[i].content}",
                style: new TextStyle(fontSize: 18.0, color: Colors.blue),
              ),
            ],
          ));
        },
        childCount: list.length,
      ),
      cacheExtent: 0.0,
    );
  }
}

// ignore: slash_for_doc_comments
/**
 * 继承SliverChildBuilderDelegate  可以对列表的监听
 */
class MyChildrenDelegate extends SliverChildBuilderDelegate {
  MyChildrenDelegate(
    Widget Function(BuildContext, int) builder, {
    int childCount,
    bool addAutomaticKeepAlives = true,
    bool addRepaintBoundaries = true,
  }) : super(builder, childCount: childCount, addAutomaticKeepAlives: addAutomaticKeepAlives, addRepaintBoundaries: addRepaintBoundaries);

  ///监听 在可见的列表中 显示的第一个位置和最后一个位置
  @override
  void didFinishLayout(int firstIndex, int lastIndex) {
    print('firstIndex: $firstIndex, lastIndex: $lastIndex');
  }

  ///可不重写 重写不能为null  默认是true  添加进来的实例与之前的实例是否相同 相同返回true 反之false
  ///listView 暂时没有看到应用场景 源码中使用在 SliverFillViewport 中
  @override
  bool shouldRebuild(SliverChildBuilderDelegate oldDelegate) {
    print("oldDelegate$oldDelegate");
    return super.shouldRebuild(oldDelegate);
  }
}

///  listView separated 构建 用于多类型 分割
Widget listViewLayoutSeparated(List<BaseBean> list) {
  return ListView.separated(
    itemCount: list.length,
    separatorBuilder: (content, index) {
      //和itemBuilder 同级别的执行
      if (index == 2) {
        return new Container(
          height: 40.0,
          child: new Center(
            child: new Text("类型1"),
          ),
          color: Colors.red,
        );
      } else if (index == 7) {
        return new Container(
          height: 40.0,
          child: new Center(
            child: new Text("类型2"),
          ),
          color: Colors.blue,
        );
      } else if (index == 14) {
        return new Container(
          height: 40.0,
          child: new Center(
            child: new Text("类型3"),
          ),
          color: Colors.yellow,
        );
      } else {
        return new Container();
      }
    },
    itemBuilder: (content, i) {
      return new InkWell(
        child: new Container(
            height: 30.0,
            child: new Row(
              mainAxisAlignment: MainAxisAlignment.spaceEvenly,
              children: <Widget>[
                new Text(
                  "${list[i].name}",
                  style: new TextStyle(fontSize: 18.0, color: Colors.red),
                ),
                new Text(
                  "${list[i].age}",
                  style: new TextStyle(fontSize: 18.0, color: Colors.green),
                ),
                new Text(
                  "${list[i].content}",
                  style: new TextStyle(fontSize: 18.0, color: Colors.blue),
                ),
              ],
            )),
        onTap: () {
          print("1111");
        },
      );
    },
  );
}
