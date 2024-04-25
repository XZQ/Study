import flow.Bean
import java.util.*
import kotlin.collections.ArrayList

object JavaTest {


    fun main(args: Array<String>) {

        // 来源集合A
        val sourceA = ArrayList<Bean>()
        sourceA.add(Bean("111", "1111", false))
        sourceA.add(Bean("222", "2222", false))
        sourceA.add(Bean("333", "3333", false))

        // 来源集合B
//        val sourceB = ArrayList<Bean>()
//        sourceB.add(Bean("111", "1111", true))
//        sourceB.add(Bean("222", "2222", true))
//
//        sourceA.forEach { that ->
//            sourceB.filter { it.service_code == that.service_code }.forEach {
//                that.isSelect = it.isSelect
//            }
//        }

        val string = "Some text"
        // 使用 Base64 编码器对字符串进行编码
        val encoder: Base64.Encoder = Base64.getEncoder()
        val encoded: String = encoder.encodeToString(string.toByteArray())
    }
}
