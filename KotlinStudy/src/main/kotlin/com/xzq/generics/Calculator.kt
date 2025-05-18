package generics

class Calculator<T : Number> {

    fun test() {

    }
}

class Calculator1<T> where T : Number, T : Runnable, T : Cloneable {
    fun test() {

    }
}
