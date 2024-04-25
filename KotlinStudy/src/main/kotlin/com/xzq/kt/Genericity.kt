package com.xzq.kt

fun main() {

//    val students = listOf(
//            Student("Alice", 80),
//            Student("Bob", 90),
//            Student("Charlie", 70)
//    )
//
//    val passingStudents = filterPassingStudents(students) { it.score > 75 }
//    println("passingStudents  $passingStudents")
}

fun runOnUiThread(action: () -> Unit) {
    //11
    action
    //22
}

// 在后台线程执行代码块
fun runOnBackgroundThread(action: () -> Unit) {
    Thread {
        action()
    }.start()
}


data class Item(val name: String, val price: Double)

// 过滤价格大于 50 的商品
fun filterExpensiveItems(items: List<Item>): List<Item> {
    return items.filter { it.price > 50 }
}

// 映射商品列表为商品名称列表
fun mapItemNames(items: List<Item>): List<String> {
    return items.map { it.name }
}

// 对商品列表按价格进行排序
fun sortItemsByPrice(items: List<Item>): List<Item> {
    return items.sortedBy { it.price }
}


// 在 Activity 中使用高阶函数处理商品列表
val itemList = listOf(Item("Item1", 30.0), Item("Item2", 60.0), Item("Item3", 40.0))

val expensiveItems = filterExpensiveItems(itemList)
val itemNames = mapItemNames(itemList)
val sortedItems = sortItemsByPrice(itemList)

fun doAsyncOperation(callBack: (result: String) -> Unit) {
    //11

    //22
}


//inline fun <T> makeRequest(url: String, crossinline onSuccess: (response: T) -> Unit, crossinline onError: (error: Throwable) -> Unit) {
//    // 在这里执行网络请求，然后调用回调函数
//    // 成功时调用 onSuccess，传递响应数据
//    // 失败时调用 onError，传递错误信息
//}

inline fun <T> makeRequest(url: String, onSuccess: (response: T) -> Unit, onError: (error: Throwable) -> UInt) {

}

inline fun measureTime(block: () -> Unit) {
    val startTime = System.currentTimeMillis()
    block()
    val endTime = System.currentTimeMillis()
    val executionTime = endTime - startTime
    println("Execution time: $executionTime milliseconds")
}

data class Student(val name: String, val score: Int)

inline fun filterPassingStudents(students: List<Student>, predicate: (Student) -> Boolean): List<Student> {
    return students.filter { predicate(it) }.toList()
}

fun calculateTotalPrice(items: List<Int>, discount: Double): Double {

    fun calculateDiscountedPrice(price: Double): Double {
        return price * (1 - discount)
    }

    var totalPrice = 0.0
    for (item in items) {
        totalPrice += calculateDiscountedPrice(1.0)
    }

    return totalPrice
}


fun sum(vararg numbers: Int): Int {
    var total = 0
    numbers.forEach {
        total += it
    }
    return total
}

infix fun String.toDo(str: String): String {
    return str + ""
}

fun printNumbers(vararg number: Number) {

}


fun <T> printInfo(item: T) where T : Number, T : Comparable<T> {
    println("Value: $item")
}

val box: Box<*> = Box("")


interface Consumer<in T> {
    fun consume(item: T)
}

interface Producer<out T> {
    fun produnce(): T
}

fun <T : Number> convertToInt(value: T): Int {
    return value.toInt()
}


class Pair<A, B>(val first: A, val second: B)


class Box<T>(private val item: T) {

    fun getItem(): T {
        return item
    }
}


fun <T> printItem(item: T) {
    println(item.toString())
}
