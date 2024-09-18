package com.xzq.util

import okio.Okio
import okio.buffer
import okio.source
import java.io.File
import java.io.IOException

// https://blog.csdn.net/lyabc123456/article/details/88830541
// https://www.jianshu.com/p/784733fb18aa
object OkioTest {

    @JvmStatic
    fun main(args: Array<String>) {
        val filePath = "/Users/zhiqiang.xia1/Documents/NT3/NT3"
        readLines1(File(filePath))
    }

    @Throws(IOException::class)
    fun readLines1(file: File?) {
        file!!.source().buffer().use { source ->
            while (!source.exhausted()) {
                val line = source.readUtf8LineStrict(1024L)
                println(line)
            }
        }
    }


    @Throws(IOException::class)
    fun readLines(file: File?) {
        val bufferedSource = file!!.source().buffer()
        var line: String?
        while ((bufferedSource.readUtf8Line().also { line = it }) != null) {
            println(line)
        }
        bufferedSource.close()
    }

}