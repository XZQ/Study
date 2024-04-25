import 'package:flutter/foundation.dart';

class User with ChangeNotifier {
  var name;
  var age;

  User(this.name, this.age);

  void setName(String name) {
    this.name = name;
    notifyListeners();
  }

  void setAge(var age) {
    this.age = age;
    notifyListeners();
  }

  String get getName => this.name;

  get getAge => this.age;
}
