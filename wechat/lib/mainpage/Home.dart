import 'package:flutter/material.dart';
import 'package:wechat/detail/Tabbar.dart';

class Home extends StatefulWidget {
  createState() => HomeState();
}

class HomeState extends State<Home> {
  HomeState() {
    // print("HomeState -------------------");
  }

  @override
  Widget build(BuildContext context) {
    // print("HomeState ------------------->build");
    return Scaffold(
      body: _buildListView(),
    );
  }

  @override
  void initState() {
    super.initState();
    // print("HomeState ------------------->initState");
  }

  @override
  void didChangeAppLifecycleState(AppLifecycleState state) {
    print(state.toString());
  }

  @override
  void didChangeDependencies() {
    super.didChangeDependencies();
    // print("HomeState ------------------->didChangeDependencies");
  }

  @override
  void didUpdateWidget(Home oldWidget) {
    super.didUpdateWidget(oldWidget);
    // print("HomeState ------------------->didUpdateWidget");
  }

  @override
  void reassemble() {
    super.reassemble();
    // print("HomeState ------------------->reassemble");
  }

  @override
  void deactivate() {
    super.deactivate();
    // print("HomeState ------------------->deactivate");
  }

  @override
  void dispose() {
    super.dispose();
    // print("HomeState ------------------->dispose");
  }

  Widget _buildListView() {
    return ListView.builder(
      itemCount: 50,
      itemBuilder: (context, index) {
        return _item(context, "");
      },
    );
  }

  Widget _item(BuildContext context, String str) {
    return ListTile(
      onTap: () {
        Navigator.push(context, MaterialPageRoute(builder: (ctx) {
          return Tabbar();
        }));
      },
      leading: Image.asset(
        "images/img.jpg",
        width: 40.0,
        height: 40.0,
      ),
      title: Text("京东到家" + str),
      subtitle: Text("京东到家,便捷到家"),
      trailing: Text("20.45"),
    );
  }
}
