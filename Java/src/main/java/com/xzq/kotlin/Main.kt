package com.xzq.kotlin

fun main() {
//    SearchKeyHelper.clear()
//    println("------------------>0  ${SearchKeyHelper.instance.recordRecentThreeSearchKeys("抖音")}")
//    println("------------------>1  ${SearchKeyHelper.instance.recordRecentThreeSearchKeys("抖音")}")
//    println("------------------>2  ${SearchKeyHelper.instance.recordRecentThreeSearchKeys("抖音极速版")}")
//    println("------------------>3  ${SearchKeyHelper.instance.recordRecentThreeSearchKeys("抖音Lite")}")
//    println("------------------>4  ${SearchKeyHelper.instance.recordRecentThreeSearchKeys("抖音")}")
//    println("------------------>5  ${SearchKeyHelper.instance.recordRecentThreeSearchKeys("抖音Lite")}")


//    val string = "123456789_123"
//
//    if (string.length > 10) {
//        println("  ---   ${string.substring(0, 10150)}")
//    } else {
//        println("  ---   ${string}")
//    }

    var recentSearchKeyList = mutableListOf<String>()
    recentSearchKeyList.add("1")
    recentSearchKeyList.add("2")
    recentSearchKeyList.add("3")
    recentSearchKeyList.add("4")
    recentSearchKeyList.add("5")
//    println("  +++   ${recentSearchKeyList}")
//    if (recentSearchKeyList.size >= 3) {
//        recentSearchKeyList = recentSearchKeyList.subList(0, 3);
//        println("  ---   ${recentSearchKeyList}")
//    }
    if (recentSearchKeyList.size > 3) {
        recentSearchKeyList = recentSearchKeyList.subList(0, 3)
    }

    val stringBuilder: StringBuilder = StringBuilder()
    recentSearchKeyList.forEachIndexed { index, s ->
        stringBuilder.append(s)
        if (index < recentSearchKeyList.size - 1) {
            stringBuilder.append("_")
        }
    }


    stringBuilder.let {

    }


    while (true) {
        println("")
    }


    println("------------------>    ${stringBuilder}")


//    println("------------------>  ${ss.substring(0, ss.length - 1)}")

//    println("------------------>  ${SearchKeyHelper.recentSearchKeys}")
//    SearchKeyHelper.clear()
//    println("------------------>5  ${SearchKeyHelper.recentSearchKeys}")
}