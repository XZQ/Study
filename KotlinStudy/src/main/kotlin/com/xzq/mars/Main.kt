package com.xzq.mars


val list = listOf("abc.png", "ppt2.gif", "ppt.gif", "1word.jpg", "12text2.gif", "java.gif", "3kotlin3.gif", "compose1a.gif")


fun main() {

    val resul = list.sortedWith(object : Comparator<String> {
        override fun compare(a: String?, b: String?): Int {
            return a!!.compareTo(b!!)
        }
    })

    resul.forEach { println(it) }

}

