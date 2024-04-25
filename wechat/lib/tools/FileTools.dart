import 'dart:io';

readFile(String name) async {
  var file = File(name);
  try {
    bool exists = await file.exists();
    if (exists) {
      print(await file.length()); //文件大小(字节)
      print(await file.lastModified()); //最后修改时间-
      print(file.parent.path); //获取父文件夹的路径
      return await file.readAsString(); //读取文件并返回
    } else {
      await file.create(recursive: true); //不存在则创建文件
      return "未发现文件,已为您创建!Dart机器人:2333";
    }
  } catch (e) {
    print(e); //异常处理
  }
}
// readFile(String name) async {
//   var file = File(name);
//   try {
//     bool exists = await file.exists();
//     if (exists) {
//       print(await file.length()); //文件大小(字节)
//       print(await file.lastModified()); //最后修改时间-
//       print(file.parent.path); //获取父文件夹的路径
//       return await file.readAsString(); //读取文件并返回
//     } else {
//       await file.create(recursive: true); //不存在则创建文件
//       return "未发现文件,已为您创建!Dart机器人:2333";
//     }
//   } catch (e) {
//     print(e); //异常处理
//   }
// }
