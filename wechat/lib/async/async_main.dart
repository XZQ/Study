import 'package:flutter/material.dart';
import 'package:wechat/tools/ThemeColors.dart';

// https://juejin.im/post/5c962b356fb9a0710e47e361
// https://juejin.im/post/5baa4b90e51d450e6d00f12e
// https://juejin.im/post/5d7f5e7c6fb9a06b0c089920
// https://blog.csdn.net/qizewei123/article/details/89190415
// https://www.jianshu.com/p/675f797f8280
class AsyncMain extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    doAsync();
    return new Scaffold(
      appBar: new AppBar(
        title: new Text('Async', style: new TextStyle(color: Colors.white)),
        backgroundColor: ThemeColors.currentColorTheme,
        elevation: 0.0,
      ),
    );
  }

  void doAsync() async {
    new Future(() => futureTask) //  异步任务的函数
        .then((m) => "futueTask execute result:$m") //   任务执行完后的子任务
        .then((m) => m.length) //  其中m为上个任务执行完后的返回的结果
        .then((m) => printLength(m))
        .whenComplete(() => whenTaskCompelete); //  当所有任务完成后的回调函数
  }
}

void a() {
  Future(() => print('task8'))
      .then((_) => Future(() => print('task9')))
      .then((_) => print('task10'));
}

int futureTask() {
  return 21;
}

void printLength(int length) {
  print("Text Length:$length");
}

void whenTaskCompelete() {
  print("Task Complete");
}

void doAsyncs() async {
  new Future(() => futureTask()) //  异步任务的函数
      .then((m) => "1-:$m") //   任务执行完后的子任务
      .then((m) => print('2-$m')) //  其中m为上个任务执行完后的返回的结果
      .then((_) => new Future.error('3-:error'))
      .then((m) => print('4-'))
      .whenComplete(() => print('5-')) //不是最后执行whenComplete，通常放到最后回调
      .catchError((e) => print('6-catchError:' + e), test: (Object o) {
        print('7-:' + o);
        return true; //返回true，会被catchError捕获
      })
      .then((_) => new Future.error('11-:error'))
      .then((m) => print('10-'))
      .catchError((e) => print('8-:' + e));
}
