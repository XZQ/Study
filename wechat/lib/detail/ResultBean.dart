class ResultBean {
  String msg;
  int code;
  NoteBean data;

  ResultBean.fromJson(Map<String, dynamic> map)
      : msg = map['msg'],
        code = map['code'],
        data = NoteBean.fromJson(map['data']);
}

class NoteBean {
  
  int id;
  String type;
  String name;
  String localPath;
  String jianshuUrl;
  String juejinUrl;
  String imgUrl;
  String createTime;
  String info;
  String area;

  NoteBean.fromJson(Map<String, dynamic> map)
      : id = map['id'],
        type = map['type'],
        name = map['name'],
        localPath = map['localPath'],
        jianshuUrl = map['jianshuUrl'],
        juejinUrl = map['juejinUrl'],
        imgUrl = map['imgUrl'],
        createTime = map['createTime'],
        info = map['info'],
        area = map['area'];
}
