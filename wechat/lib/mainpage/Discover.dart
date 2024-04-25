import 'package:flutter/material.dart';
import 'package:wechat/Lifecycle/LifeCycleStateLess.dart';
import 'package:wechat/Lifecycle/LifeCycleStateful.dart';
import 'package:wechat/async/async_main.dart';
import 'package:wechat/basewidget/ChannelWidget.dart';
import 'package:wechat/basewidget/LifeWidget.dart';
import 'package:wechat/listview/listview_main.dart';
import 'package:wechat/mvvm/page_router.dart';
import 'package:wechat/principle/BottomComponent.dart';
import 'package:wechat/principle/ButtonDemo.dart';
import 'package:wechat/principle/CircleProgressBar.dart';
import 'package:wechat/principle/ExpandDemo.dart';
import 'package:wechat/principle/KeyPrinciple.dart';
import 'package:wechat/principle/OffstateOpacity.dart';
import 'package:wechat/principle/Overdraw.dart';
import 'package:wechat/principle/PluginDemo.dart';
import 'package:wechat/principle/SharedPreference.dart';
import 'package:wechat/route_transition/route_transition_main.dart';
import 'package:wechat/router/router_main.dart';
import 'package:wechat/state/bloc/bloc_main.dart';
import 'package:wechat/state/inheritate/my_inheratite.dart';
import 'package:wechat/state/provider/provider_main.dart';
import 'package:wechat/state/provider2/provider_app.dart';
import 'package:wechat/state/provider3/Provider3App.dart';
import 'package:wechat/state/provider4/Provider4App.dart';
import 'package:wechat/state/redux/redux_main.dart';
import 'package:wechat/state/setstate/myhome_state.dart';
import 'package:wechat/state/stream/count_page.dart';
import 'package:wechat/widget/test_main.dart';
import 'package:wechat/widget/test_state.dart';

class Discover extends StatefulWidget {
  @override
  _DiscoverState createState() => _DiscoverState();
}

//https://juejin.im/post/5d2144596fb9a07ed2248f51
class _DiscoverState extends State<Discover> {
  List<Widget> _list = [];

  @override
  void didUpdateWidget(covariant Discover oldWidget) {
    super.didUpdateWidget(oldWidget);
    if (_list.isNotEmpty) _list.clear();
  }

  @override
  Widget build(BuildContext context) {
    return gridViewCount();
  }

//GridView.count
  Widget gridViewCount() {
    return GridView.count(
      //水平子Widget之间间距
      crossAxisSpacing: 10.0,
      //垂直子Widget之间间距
      mainAxisSpacing: 10.0,
      //GridView内边距
      padding: EdgeInsets.all(10.0),
      //一行的Widget数量
      crossAxisCount: 4,
      //子Widget宽高比例
      childAspectRatio: 2.0,
      //子Widget列表
      children: getWidgetLists(),
    );
  }

  List<Widget> getWidgetLists() {
    _list.add(_MyWidget(context));
    _list.add(_ExpandDemo(context));
    _list.add(_ListviewDemo(context));
    _list.add(_BaseWidget(context));
    _list.add(_ChannelWidget(context));
    _list.add(_BottomComponentWidget(context));
    _list.add(_OffstateOpacityWidget(context));
    _list.add(_ButtonWidget(context));
    _list.add(_CircleProgressBarWidget(context));
    _list.add(_SharedWidget(context));
    _list.add(_OverdrawWidget(context));
    _list.add(_lifeWidget(context));
    _list.add(_lifelessWidget(context));
    _list.add(_HomePageWidget(context));
    _list.add(_setStateWidget(context));
    _list.add(_inhertatiteWidget(context));
    _list.add(_ReduxMainWidget(context));
    _list.add(_BlocWidget(context));
    _list.add(_providerWidget(context));
    _list.add(_streamWidget(context));
    _list.add(_asyncWidget(context));
    _list.add(_routeTransitonWidget(context));
    _list.add(_routerWidget(context));
    _list.add(_provider2Widget(context));
    _list.add(_provider3Widget(context));
    _list.add(_provider4Widget(context));
    _list.add(_testMainWidget(context));
    _list.add(_testStateWidget(context));
    return _list;
  }

  Widget _testStateWidget(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.push(context, MaterialPageRoute(builder: (ctx) => TestState()));
      },
      child: Container(
        decoration: BoxDecoration(
          border: Border.all(width: 1.0, color: Colors.blueAccent),
          borderRadius: BorderRadius.all(Radius.circular(5.0)),
        ),
        alignment: Alignment.center,
        child: Text('TestState', style: TextStyle(color: Colors.blue, fontSize: 13.0)),
      ),
    );
  }

  Widget _testMainWidget(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.push(context, MaterialPageRoute(builder: (ctx) {
          return TestMain();
        }));
      },
      child: Container(
        decoration: BoxDecoration(
          border: Border.all(width: 1.0, color: Colors.blueAccent),
          borderRadius: BorderRadius.all(Radius.circular(5.0)),
        ),
        alignment: Alignment.center,
        child: Text('Element', style: TextStyle(color: Colors.blue, fontSize: 13.0)),
      ),
    );
  }

  Widget _provider4Widget(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.push(context, MaterialPageRoute(builder: (ctx) {
          return Provider4App();
        }));
      },
      child: Container(
        decoration: BoxDecoration(
          border: Border.all(width: 1.0, color: Colors.blueAccent),
          borderRadius: BorderRadius.all(Radius.circular(5.0)),
        ),
        alignment: Alignment.center,
        child: Text('Provider4', style: TextStyle(color: Colors.blue, fontSize: 13.0)),
      ),
    );
  }

  Widget _provider3Widget(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.push(context, MaterialPageRoute(builder: (ctx) {
          return Provider3App();
        }));
      },
      child: Container(
        decoration: BoxDecoration(
          border: Border.all(width: 1.0, color: Colors.blueAccent),
          borderRadius: BorderRadius.all(Radius.circular(5.0)),
        ),
        alignment: Alignment.center,
        child: Text('Provider3', style: TextStyle(color: Colors.blue, fontSize: 13.0)),
      ),
    );
  }

  Widget _provider2Widget(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.push(context, MaterialPageRoute(builder: (ctx) {
          return ProviderApp();
        }));
      },
      child: Container(
        decoration: BoxDecoration(
          border: Border.all(width: 1.0, color: Colors.blueAccent),
          borderRadius: BorderRadius.all(Radius.circular(5.0)),
        ),
        alignment: Alignment.center,
        child: Text('Provider', style: TextStyle(color: Colors.blue, fontSize: 13.0)),
      ),
    );
  }

  Widget _routerWidget(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.push(context, MaterialPageRoute(builder: (ctx) {
          return RouterMain();
        }));
      },
      child: Container(
        decoration: BoxDecoration(
          border: Border.all(width: 1.0, color: Colors.blueAccent),
          borderRadius: BorderRadius.all(Radius.circular(5.0)),
        ),
        alignment: Alignment.center,
        child: Text('路由', style: TextStyle(color: Colors.blue, fontSize: 14.0)),
      ),
    );
  }

  Widget _routeTransitonWidget(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.push(context, MaterialPageRoute(builder: (ctx) {
          return RouteTransitionMain();
        }));
      },
      child: Container(
        decoration: BoxDecoration(
          border: Border.all(width: 1.0, color: Colors.blueAccent),
          borderRadius: BorderRadius.all(Radius.circular(5.0)),
        ),
        alignment: Alignment.center,
        child: Text('路由动画', style: TextStyle(color: Colors.blue, fontSize: 14.0)),
      ),
    );
  }

  Widget _asyncWidget(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.push(context, MaterialPageRoute(builder: (ctx) {
          return AsyncMain();
        }));
      },
      child: Container(
        decoration: BoxDecoration(
          border: Border.all(width: 1.0, color: Colors.blueAccent),
          borderRadius: BorderRadius.all(Radius.circular(5.0)),
        ),
        alignment: Alignment.center,
        child: Text('async', style: TextStyle(color: Colors.blue, fontSize: 14.0)),
      ),
    );
  }

  Widget _setStateWidget(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.push(context, MaterialPageRoute(builder: (ctx) {
          return Myhome_State();
        }));
      },
      child: Container(
        decoration: BoxDecoration(
          border: Border.all(width: 1.0, color: Colors.blueAccent),
          borderRadius: BorderRadius.all(Radius.circular(5.0)),
        ),
        alignment: Alignment.center,
        child: Text('setState', style: TextStyle(color: Colors.blue, fontSize: 14.0)),
      ),
    );
  }

  Widget _inhertatiteWidget(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.push(context, MaterialPageRoute(builder: (ctx) {
          return MyInheratite();
        }));
      },
      child: Container(
        decoration: BoxDecoration(
          border: Border.all(width: 1.0, color: Colors.blueAccent),
          borderRadius: BorderRadius.all(Radius.circular(5.0)),
        ),
        alignment: Alignment.center,
        child: Text('inherited', style: TextStyle(color: Colors.blue, fontSize: 14.0)),
      ),
    );
  }

  Widget _streamWidget(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.push(context, MaterialPageRoute(builder: (ctx) {
          return CountPage();
        }));
      },
      child: Container(
        decoration: BoxDecoration(
          border: Border.all(width: 1.0, color: Colors.blueAccent),
          borderRadius: BorderRadius.all(Radius.circular(5.0)),
        ),
        alignment: Alignment.center,
        child: Text('Stream', style: TextStyle(color: Colors.blue, fontSize: 14.0)),
      ),
    );
  }

  Widget _providerWidget(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.push(context, MaterialPageRoute(builder: (ctx) {
          return ProviderMain();
        }));
      },
      child: Container(
        decoration: BoxDecoration(
          border: Border.all(width: 1.0, color: Colors.blueAccent),
          borderRadius: BorderRadius.all(Radius.circular(5.0)),
        ),
        alignment: Alignment.center,
        child: Text('Provider', style: TextStyle(color: Colors.blue, fontSize: 14.0)),
      ),
    );
  }

  Widget _BlocWidget(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.push(context, MaterialPageRoute(builder: (ctx) {
          return BlocMain();
        }));
      },
      child: Container(
        decoration: BoxDecoration(
          border: Border.all(width: 1.0, color: Colors.blueAccent),
          borderRadius: BorderRadius.all(Radius.circular(5.0)),
        ),
        alignment: Alignment.center,
        child: Text('Bloc', style: TextStyle(color: Colors.blue, fontSize: 14.0)),
      ),
    );
  }

  Widget _ReduxMainWidget(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.push(context, MaterialPageRoute(builder: (ctx) {
          return ReduxMain();
        }));
      },
      child: Container(
        decoration: BoxDecoration(
          border: Border.all(width: 1.0, color: Colors.blueAccent),
          borderRadius: BorderRadius.all(Radius.circular(5.0)),
        ),
        alignment: Alignment.center,
        child: Text('Redux', style: TextStyle(color: Colors.blue, fontSize: 14.0)),
      ),
    );
  }

  Widget _HomePageWidget(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.push(context, MaterialPageRoute(builder: (ctx) {
          return page_router();
        }));
      },
      child: Container(
        decoration: BoxDecoration(
          border: Border.all(width: 1.0, color: Colors.blueAccent),
          borderRadius: BorderRadius.all(Radius.circular(5.0)),
        ),
        alignment: Alignment.center,
        child: Text('MVVM', style: TextStyle(color: Colors.blue, fontSize: 14.0)),
      ),
    );
  }

  Widget _lifelessWidget(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.push(context, MaterialPageRoute(builder: (ctx) {
          return LifeCycleStateful();
        }));
      },
      child: Container(
        decoration: BoxDecoration(
          border: Border.all(width: 1.0, color: Colors.blueAccent),
          borderRadius: BorderRadius.all(Radius.circular(5.0)),
        ),
        alignment: Alignment.center,
        child: Text('Stateful', style: TextStyle(color: Colors.blue, fontSize: 15.0)),
      ),
    );
  }

  Widget _lifeWidget(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.push(context, MaterialPageRoute(builder: (ctx) {
          return LifeCycleStateLess();
        }));
      },
      child: Container(
        decoration: BoxDecoration(
          border: Border.all(width: 1.0, color: Colors.blueAccent),
          borderRadius: BorderRadius.all(Radius.circular(5.0)),
        ),
        alignment: Alignment.center,
        child: Text('StateLess', style: TextStyle(color: Colors.blue, fontSize: 14.0)),
      ),
    );
  }

  Widget _OverdrawWidget(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.push(context, MaterialPageRoute(builder: (ctx) {
          return Overdraw();
        }));
      },
      child: Container(
        decoration: BoxDecoration(
          border: Border.all(width: 1.0, color: Colors.blueAccent),
          borderRadius: BorderRadius.all(Radius.circular(5.0)),
        ),
        alignment: Alignment.center,
        child: Text('绘制', style: TextStyle(color: Colors.blue, fontSize: 16.0)),
      ),
    );
  }

  Widget _PluginWidget(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.push(context, MaterialPageRoute(builder: (ctx) {
          return PluginDemo();
        }));
      },
      child: Container(
        decoration: BoxDecoration(
          border: Border.all(width: 1.0, color: Colors.blueAccent),
          borderRadius: BorderRadius.all(Radius.circular(5.0)),
        ),
        alignment: Alignment.center,
        child: Text('Plugin', style: TextStyle(color: Colors.blue, fontSize: 16.0)),
      ),
    );
  }

  Widget _SharedWidget(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.push(context, MaterialPageRoute(builder: (ctx) {
          return SharedPreference();
        }));
      },
      child: Container(
        decoration: BoxDecoration(
          border: Border.all(width: 1.0, color: Colors.blueAccent),
          borderRadius: BorderRadius.all(Radius.circular(5.0)),
        ),
        alignment: Alignment.center,
        child: Text('Shared', style: TextStyle(color: Colors.blue, fontSize: 16.0)),
      ),
    );
  }

  Widget _CircleProgressBarWidget(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.push(context, MaterialPageRoute(builder: (ctx) {
          return CircleProgressBar();
        }));
      },
      child: Container(
        decoration: BoxDecoration(
          border: Border.all(width: 1.0, color: Colors.blueAccent),
          borderRadius: BorderRadius.all(Radius.circular(5.0)),
        ),
        alignment: Alignment.center,
        child: Text('Paint', style: TextStyle(color: Colors.blue, fontSize: 16.0)),
      ),
    );
  }

  Widget _ButtonWidget(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.push(context, MaterialPageRoute(builder: (ctx) {
          return ButtonDemo();
        }));
      },
      child: Container(
        decoration: BoxDecoration(
          border: Border.all(width: 1.0, color: Colors.blueAccent),
          borderRadius: BorderRadius.all(Radius.circular(5.0)),
        ),
        alignment: Alignment.center,
        child: Text('Button', style: TextStyle(color: Colors.blue, fontSize: 16.0)),
      ),
    );
  }

  Widget _OffstateOpacityWidget(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.push(context, MaterialPageRoute(builder: (ctx) {
          return OffstateOpacity();
        }));
      },
      child: Container(
        decoration: BoxDecoration(
          border: Border.all(width: 1.0, color: Colors.blueAccent),
          borderRadius: BorderRadius.all(Radius.circular(5.0)),
        ),
        alignment: Alignment.center,
        child: Text('显示', style: TextStyle(color: Colors.blue, fontSize: 16.0)),
      ),
    );
  }

  Widget _BottomComponentWidget(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.push(context, MaterialPageRoute(builder: (ctx) {
          return BottomComponent();
        }));
      },
      child: Container(
        decoration: BoxDecoration(
          border: Border.all(width: 1.0, color: Colors.blueAccent),
          borderRadius: BorderRadius.all(Radius.circular(5.0)),
        ),
        alignment: Alignment.center,
        child: Text('封装', style: TextStyle(color: Colors.blue, fontSize: 16.0)),
      ),
    );
  }

  Widget _ChannelWidget(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.push(context, MaterialPageRoute(builder: (ctx) {
          return ChannelWidget();
        }));
      },
      child: Container(
        decoration: BoxDecoration(
          border: Border.all(width: 1.0, color: Colors.blueAccent),
          borderRadius: BorderRadius.all(Radius.circular(5.0)),
        ),
        alignment: Alignment.center,
        child: Text('通信', style: TextStyle(color: Colors.blue, fontSize: 16.0)),
      ),
    );
  }

  Widget _BaseWidget(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.push(context, MaterialPageRoute(builder: (ctx) {
          return LifeWidget();
        }));
      },
      child: Container(
        decoration: BoxDecoration(
          border: Border.all(width: 1.0, color: Colors.blueAccent),
          borderRadius: BorderRadius.all(Radius.circular(5.0)),
        ),
        alignment: Alignment.center,
        child: Text('生命周期', style: TextStyle(color: Colors.blue, fontSize: 16.0)),
      ),
    );
  }

  //  TurnBox
  Widget _ListviewDemo(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.push(context, MaterialPageRoute(builder: (ctx) {
          return ListViewMain();
        }));
      },
      child: Container(
        decoration: BoxDecoration(
          border: Border.all(width: 1.0, color: Colors.blueAccent),
          borderRadius: BorderRadius.all(Radius.circular(5.0)),
        ),
        alignment: Alignment.center,
        child: Text('Listview', style: TextStyle(color: Colors.blue, fontSize: 16.0)),
      ),
    );
  }

  //  TurnBox
  Widget _ExpandDemo(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.push(context, MaterialPageRoute(builder: (ctx) {
          return ExpandDemo();
        }));
      },
      child: Container(
        decoration: BoxDecoration(
          border: Border.all(width: 1.0, color: Colors.blueAccent),
          borderRadius: BorderRadius.all(Radius.circular(5.0)),
        ),
        alignment: Alignment.center,
        child: Text('Expand', style: TextStyle(color: Colors.blue, fontSize: 16.0)),
      ),
    );
  }

  //  TurnBox
  Widget _MyWidget(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.push(context, MaterialPageRoute(builder: (ctx) => KeyPrinciple()));
      },
      child: Container(
        decoration: BoxDecoration(
          border: Border.all(width: 1.0, color: Colors.blueAccent),
          borderRadius: BorderRadius.all(Radius.circular(5.0)),
        ),
        alignment: Alignment.center,
        child: Text('Key', style: TextStyle(color: Colors.blue, fontSize: 16.0)),
      ),
    );
  }

//GridView.builder
  Widget gridViewBuilder() {
    List<String> datas = getDataList();
    return GridView.builder(
      itemCount: datas.length,
      gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
        crossAxisSpacing: 10.0,
        crossAxisCount: 3,
        childAspectRatio: 2.0,
        mainAxisSpacing: 10.0,
      ),
      cacheExtent: 0,
      padding: EdgeInsets.all(10),
      //设置 GridView 如何响应用户的滑动行为，值为一个 ScrollPhysics 对象，它的实现类常用的有：
      //AlwaysScrollableScrollPhysics：总是可以滑动
      //NeverScrollableScrollPhysics：禁止滚动
      //BouncingScrollPhysics：内容超过一屏，上拉有回弹效果
      //ClampingScrollPhysics：包裹内容，不会有回弹，感觉跟 AlwaysScrollableScrollPhysics 差不多
      physics: BouncingScrollPhysics(),
      //Item 的顺序是否反转，若为 true 则反转，这个翻转只是行翻转，即第一行变成最后一行，但是每一行中的子组件还是从左往右摆放的
      //GirdView 的方向，为 Axis.vertical 表示纵向，为 Axis.horizontal 表示横向，横向的话 CrossAxis 和 MainAxis 表示的轴也会调换
      scrollDirection: Axis.vertical,
      itemBuilder: (BuildContext context, int index) {
        return getItemContainer(datas[index]);
      },
    );
  }

  //GridView.builder
  Widget gridViewBuilderAxis() {
    List<String> datas = getDataList();
    return GridView.builder(
      itemCount: datas.length,
      itemBuilder: (BuildContext context, int index) {
        return getItemContainer(datas[index]);
      },
      gridDelegate: SliverGridDelegateWithMaxCrossAxisExtent(
          maxCrossAxisExtent: 100, mainAxisSpacing: 20.0, crossAxisSpacing: 10.0),
    );
  }

  //GridView.builder
  Widget gridViewCustom() {
    List<String> datas = getDataList();
    return GridView.custom(
        gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
          crossAxisCount: 3,
          mainAxisSpacing: 10.0,
          crossAxisSpacing: 20.0,
        ),
        childrenDelegate: SliverChildBuilderDelegate((context, position) {
          return getItemContainer(datas[position]);
        }, childCount: datas.length));
  }

  List<String> getDataList() {
    List<String> list = [];
    for (int i = 0; i < 60; i++) {
      list.add(i.toString());
    }
    return list;
  }

  List<Widget> getWidgetList() {
    return getDataList().map((item) => getItemContainer(item)).toList();
  }

  Widget getItemContainer(String item) {
    return Container(
      color: Colors.blue,
      alignment: Alignment.center,
      child: Text(
        item,
        style: TextStyle(color: Colors.white, fontSize: 20),
      ),
    );
  }
}
