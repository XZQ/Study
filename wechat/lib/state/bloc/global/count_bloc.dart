import 'dart:async';

class CountBLoC {
  //
  int _count = 0;

  StreamController<int> _countController = StreamController<int>.broadcast();

//输出流
  Stream<int> get stream => _countController.stream;

  int get value => _count;

  increment() {
    _countController.sink.add(++_count);
  }

  dispose() {
    _countController.close();
  }
}

CountBLoC bLoC = CountBLoC();
