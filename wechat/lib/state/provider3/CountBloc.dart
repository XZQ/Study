import 'dart:async';

class CountBloc {
  final StreamController<int> _controller = new StreamController();

  int count = 0;
  Stream<int> stream;

  CountBloc() {
    stream = _controller.stream.asBroadcastStream();
  }

  add() {
    _controller.add(++count);
  }

  dispose() {
    _controller?.close();
  }
}
