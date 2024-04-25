class DataEntity {
  Data data;
  int errorcode;
  String errormsg;

  DataEntity({this.data, this.errorcode, this.errormsg});

  DataEntity.fromJson(Map<String, dynamic> json) {
    data = json['data'] != null ? new Data.fromJson(json['data']) : null;
    errorcode = json['errorCode'];
    errormsg = json['errorMsg'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    if (this.data != null) {
      data['data'] = this.data.toJson();
    }
    data['errorCode'] = this.errorcode;
    data['errorMsg'] = this.errormsg;
    return data;
  }
}

class Data {
  int curpage;
  List<Datas> datas;
  int offset;
  bool over;
  int pagecount;
  int size;
  int total;

  Data(
      {this.curpage,
      this.datas,
      this.offset,
      this.over,
      this.pagecount,
      this.size,
      this.total});

  Data.fromJson(Map<String, dynamic> json) {
    curpage = json['curPage'];
    if (json['datas'] != null) {
      datas = new List<Datas>();
      json['datas'].forEach((v) {
        datas.add(new Datas.fromJson(v));
      });
    }
    offset = json['offset'];
    over = json['over'];
    pagecount = json['pageCount'];
    size = json['size'];
    total = json['total'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['curPage'] = this.curpage;
    if (this.datas != null) {
      data['datas'] = this.datas.map((v) => v.toJson()).toList();
    }
    data['offset'] = this.offset;
    data['over'] = this.over;
    data['pageCount'] = this.pagecount;
    data['size'] = this.size;
    data['total'] = this.total;
    return data;
  }
}

class Datas {
  String apklink;
  String author;
  int chapterid;
  String chaptername;
  bool collect;
  int courseid;
  String desc;
  String envelopepic;
  bool fresh;
  int id;
  String link;
  String nicedate;
  String origin;
  String projectlink;
  int publishtime;
  int superchapterid;
  String superchaptername;
  // List<Null> tags;
  String title;
  int type;
  int userid;
  int visible;
  int zan;

  Datas(
      {this.apklink,
      this.author,
      this.chapterid,
      this.chaptername,
      this.collect,
      this.courseid,
      this.desc,
      this.envelopepic,
      this.fresh,
      this.id,
      this.link,
      this.nicedate,
      this.origin,
      this.projectlink,
      this.publishtime,
      this.superchapterid,
      this.superchaptername,
      // this.tags,
      this.title,
      this.type,
      this.userid,
      this.visible,
      this.zan});

  Datas.fromJson(Map<String, dynamic> json) {
    apklink = json['apkLink'];
    author = json['author'];
    chapterid = json['chapterId'];
    chaptername = json['chapterName'];
    collect = json['collect'];
    courseid = json['courseId'];
    desc = json['desc'];
    envelopepic = json['envelopePic'];
    fresh = json['fresh'];
    id = json['id'];
    link = json['link'];
    nicedate = json['niceDate'];
    origin = json['origin'];
    projectlink = json['projectLink'];
    publishtime = json['publishTime'];
    superchapterid = json['superChapterId'];
    superchaptername = json['superChapterName'];
//    if (json['tags'] != null) {
//      tags = new List<Null>();
//      json['tags'].forEach((v) {
//        tags.add(new Null.fromJson(v));
//      });
//    }
    title = json['title'];
    type = json['type'];
    userid = json['userId'];
    visible = json['visible'];
    zan = json['zan'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['apkLink'] = this.apklink;
    data['author'] = this.author;
    data['chapterId'] = this.chapterid;
    data['chapterName'] = this.chaptername;
    data['collect'] = this.collect;
    data['courseId'] = this.courseid;
    data['desc'] = this.desc;
    data['envelopePic'] = this.envelopepic;
    data['fresh'] = this.fresh;
    data['id'] = this.id;
    data['link'] = this.link;
    data['niceDate'] = this.nicedate;
    data['origin'] = this.origin;
    data['projectLink'] = this.projectlink;
    data['publishTime'] = this.publishtime;
    data['superChapterId'] = this.superchapterid;
    data['superChapterName'] = this.superchaptername;
//    if (this.tags != null) {
//      data['tags'] = this.tags.map((v) => v.toJson()).toList();
//    }
    data['title'] = this.title;
    data['type'] = this.type;
    data['userId'] = this.userid;
    data['visible'] = this.visible;
    data['zan'] = this.zan;
    return data;
  }
}
