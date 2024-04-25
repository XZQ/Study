package com.xzq.kotlin

private fun lambdaFunction(function: (Int, Int) -> Int): Int {
    return function(2, 3)
}


class User {
    var name: String = ""
    var age: Int = 0

    private lateinit var st: String

    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }

    fun printMessage() {
        println("姓名：$name+年龄：$age")
    }
}

//()->R
fun uFun1(funcUnit: () -> Unit, funcUser: () -> User) {
    funcUnit()
    funcUser().printMessage()
}


//(T...)->R
fun uFun2(funcUnit: (user: User) -> Unit, funcUser: (user: User, afterYears: Int) -> String) {
    val user = User("白瑞德", 18)
    funcUnit(user)
    val funcUser1 = funcUser(user, 10)
    println(funcUser1)
}


// T.()->R
fun uFun3(funcUnit: User.() -> Unit, funcUser: User.(afterYears: Int) -> String) {
    val user = User("白瑞德", 18)
    val funcUnit = funcUnit(user)
    val funcString = user.funcUser(10)
    println(funcUnit)
    println(funcString)

}

// 返回值为函数的情况
fun uFun4(): () -> Unit {
    return fun() {
        println(User("白瑞德", 18).name)
    }
}

fun main() {
    val u1 = fun() {
        println("要准备打印个人信息了")
    }
    val u2 = fun(): User {
        return User("白瑞德", 19)
    }
    uFun1(u1, u2)
    uFun1(u1) {
        User("白瑞德", 19)
    }

}


@JvmInline
value class User1(val name: String) {

}