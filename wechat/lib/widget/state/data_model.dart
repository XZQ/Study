class DataModel {
  DataModel._internal() {}

  static DataModel get instace => _getInstance();

  static DataModel _instance;

  factory DataModel() => _getInstance();

  static DataModel _getInstance() {
    if (_instance == null) {
      _instance = new DataModel._internal();
    }
    return _instance;
  }
}
