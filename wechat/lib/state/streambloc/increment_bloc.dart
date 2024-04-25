import 'dart:async';

import 'package:wechat/state/streambloc/blocbase.dart';

class IncrementBloc implements BlocBase {
  int _counter;

  // 处理counter的stream
  StreamController<int> _counterController = StreamController<int>();
  //输入流
  StreamSink<int> get add => _counterController.sink;
  //输出流
  Stream<int> get outCounter => _counterController.stream;

  //监听流
  // StreamSubscription subscription =
  //     _counterController.stream.listen((data) => print("$data"));

// 转换流
  StreamTransformer transformer =
      StreamTransformer<int, String>.fromHandlers(handleData: (value, sink) {
    if (value == 100) {
      sink.add("success");
    } else {
      sink.addError('error');
    }
  });

  // 处理业务逻辑的stream
  StreamController _actionController = StreamController();

  StreamSink get incrementCounter => _actionController.sink;

  IncrementBloc() {
    _counter = 0;
    _actionController.stream.listen(_handleLogic);
  }

  void _handleLogic(data) {
    _counter = _counter + 1;
    add.add(_counter);
  }

  @override
  void dispose() {
    _counterController.close();
    _actionController.close();
  }
}
