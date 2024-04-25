import 'package:flutter/material.dart';
import 'package:wechat/mvvm/abstract_base_viewmodel.dart';
import 'package:wechat/mvvm/network.dart';
import 'package:rxdart/rxdart.dart';

class HomeViewModel extends BaseViewModel {
  BehaviorSubject<String> _dataObservable = BehaviorSubject();

  Stream<String> get dataStream => _dataObservable.stream;

  @override
  void dispose() {
    _dataObservable.close();
  }

  @override
  void doInit(BuildContext context) {
    refreshData(context);
  }

  @override
  Future refreshData(BuildContext context) {
    return NetWork.query().then((String text) {
      _dataObservable.add(text);
    }).catchError((error) {
      _dataObservable.addError(error);
    });
  }
}
