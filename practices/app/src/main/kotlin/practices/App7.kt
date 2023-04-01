package practices
import java.util.*
import java.util.stream.Collectors
import kotlin.collections.ArrayList

fun main() {
    val numbers = listOf(5, 1, 3, 2, 9, 6, 7, 8, 4)
    
    val sorted = numbers.sortedBy { it }
    println(sorted)
    
    val biggerThan5 = numbers.sortedBy { it }.filter { it > 5 }
    println(biggerThan5)

    // 범위함수 
    // let : 어떤 형태의 확장
    // inline fun <T, R> T.let(block: (T) -> R): R
    var str = "lowercase".let { it.uppercase() }
    println(str)
    println("lowercase".let(String::uppercase))

    // with with는 let과 달리 확장 함수가 없다. 
    // inline fun <T, R> with(receiver: T, block: T.() -> R): R
    val str1 = with("lowercase") { this.uppercase() }
    println(str1)

    val str2 = "lowercase".run { uppercase() }
    println(str2)

    // infix

    println("hello".appendEndfix("bot"))

}

// infix 중간 표기법 함수
infix fun String.appendEndfix(endFix: String): String {
    return this + endFix
}