package practices
import java.util.*
import java.util.stream.Collectors
import kotlin.collections.ArrayList

class RegulerX<T>(val t: T) {}

fun main() {
    val regX = RegulerX("ex!")
    val data1 = mutableMapOf(1 to "z", 2 to "y", Pair(3, "x"))
    data1[5]  = "gap"
    data1[6]  = "sol"
    
    println(data1)

    val list1: List<*> = listOf<String>("안", "녕")
    println(list1)

    /**
    https://seob.dev/posts/%EA%B3%B5%EB%B3%80%EC%84%B1%EC%9D%B4%EB%9E%80-%EB%AC%B4%EC%97%87%EC%9D%B8%EA%B0%80/
    PECS
        Producer -Extends, Consumer-Super
        공변성은 자바 제네릭의 extends 코틀린에서 out
        반공변성은 자바 제네릭의 super 코틀린에서 in 
    */ 
    val bag = Bag<String>()
    bag.saveAll(mutableListOf<CharSequence>("1", "2"), mutableListOf<String>("3", "4"))
}


class Bag<T> {

    fun saveAll(
        to: MutableList<in T>,
        from: MutableList<T>,
    ) {
        to.addAll(from)
    }
}
    