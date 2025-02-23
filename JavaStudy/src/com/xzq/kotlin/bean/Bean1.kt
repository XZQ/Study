package com.xzq.kotlin.bean

class Bean1 : Bean3 {
    var name: String? = null
    var male: String? = null

    constructor(name: String?, male: String?) : super(name, male) {
        println("Bean1 constructor")
    }

    init {
        println("Bean1 init1")
    }

    init {
        println("Bean1 init2")
    }

}


data class Bean2(
    var name: String? = null, var male: String? = null
)


open class Bean3 {

    constructor(name: String?, male: String?) {
        println("Bean3 constructor")
    }

    init {
        println("Bean3 init1")
    }

    init {
        println("Bean3 init2")
    }

    @JvmOverloads
    fun greet(name: String = "World", greeting: String = "Hello") {
        println("$greeting, $name!")
    }
}