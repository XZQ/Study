library adpicture;

part 'AdPicture.g.dart';

///首页轮播图
class AdPicture {
  final String imageUrl; //图片链接

  AdPicture({
    this.imageUrl,
  });

  factory AdPicture.fromJson(Map<String, dynamic> json) =>
      _$AdPictureFromJson(json);
}
