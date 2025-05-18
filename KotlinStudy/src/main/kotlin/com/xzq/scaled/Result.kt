package com.xzq.scaled

sealed class Result

data class Success<T>(val data: T) : Result()

data class Failure(val error: String) : Result()

object Loadint : Result()



// https://www.jianshu.com/p/8e57545398af
// https://www.jianshu.com/p/acb0f4c35a02
fun main() {

}