/*
 * @Author: XZQ 
 * @Date: 2019-10-17 16:39:51 
 * @Last Modified time: 2019-10-17 16:39:51 
 */

import 'package:build/build.dart';
import 'package:source_gen/source_gen.dart';
import 'TestGenerator.dart';

Builder testBuilder(BuilderOptions options) => LibraryBuilder(TestGenerator());
