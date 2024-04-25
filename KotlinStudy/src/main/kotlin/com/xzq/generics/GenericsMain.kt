package generics

// 泛型的本质就是能够创建参数化的对象和函数，以实现复用
fun main() {
    val names: List<String> = listOf("James", "Kerin")
    val box: Box<Int> = Box<Int>(1)
    val case: Box<String> = Box<String>("Goat")
    val animal: List<*> = mutableListOf<Any>()

    val animals = MyList<Animal>()
    val dogs = MyList<Dog>()


    animals.addAll(dogs)


}

class MyList<E> {

    fun addAll(from: MyList<out E>) {

    }

    fun getAll(to: MyList<in E>) {

    }
}


class Box<T>(t: T) {
    var value = t
}

open class Animal

class Dog : Animal()