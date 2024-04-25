/*
 * @Author: XZQ 
 * @Date: 2019-10-17 15:53:41 
 * @Last Modified time: 2019-10-17 15:53:41 
 */
import 'package:analyzer/dart/element/element.dart';
import 'package:build/build.dart';
import 'package:source_gen/source_gen.dart';
import 'package:wechat/annotation/TestMetadata.dart';
import 'package:wechat/tools/Log.dart';

class TestGenerator extends GeneratorForAnnotation<TestMetadata> {
  @override
  generateForAnnotatedElement(
      Element element, ConstantReader annotation, BuildStep buildStep) {
    Log.e(
        "XZQ",
        element.toString() +
            "   " +
            annotation.toString() +
            "  " +
            buildStep.toString());

    return "class Tessss{}";
  }
}
