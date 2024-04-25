package generics

class Bean(name: String, private val sex: String, val age: String)


data class Bean1(val name: String, private val sex: String, val age: String) {
    val male: String? = null
}