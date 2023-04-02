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
    /**
     *  함수명      수신자 객체 참조      반환 값              확장 함수 여부 
     *  let         it                  함수의 결과             O 
     *  run         this                함수의 결과             O
     *  with        this                함수의 결과             X
     *  apply       this                컨텍스트 객체           O
     *  also        it                  컨텍스트 객체           O
     */


    // let : 어떤 형태의 확장
    // inline fun <T, R> T.let(block: (T) -> R): R
    var str = "lowercase".let { it.uppercase() }
    println(str)
    println("lowercase".let(String::uppercase))

    // return이 없어도 반환 
    val result: Int = 123.let {
        it
    }
    println(result)

    // with with는 let과 달리 확장 함수가 없다. 
    // inline fun <T, R> with(receiver: T, block: T.() -> R): R
    val str1 = with("lowercase") { this.uppercase() }
    println(str1)

    val str2 = "lowercase".run { uppercase() }
    println(str2)
    
    // infix
    println("hello".appendEndfix("bot"))

    //Pair Triple,  data class -> value로 되어있음 변수 재할당 불가 -> copy로 새로운 변수 지정해서는 가능
    println(plus(Pair(1, 2)))
    var triple1: Triple<Int, Int, Int> = Triple(1, 2, 3)
    
    println(plus(triple1))
    var triple2 = triple1.copy(first = 3)
    println(plus(triple2))
    
    // run 수신부 끝의 return값을 반환함 
    var db = DBCon().run {
        url = "localhost:5601"
        dbSource = "mysql:en-k2"
        conn()
    }
    println(db)

    var db1 = with(DBCon()) {
        url = "localhost:5601"
        dbSource = "mysql:en-k2"
        conn()
    }
    println(db1)
    
    // apply -> return시 this 객체를 반환 함 
    var db2:DBCon = DBCon().apply {
        url = "localhost:5601"
        dbSource = "mysql:en-k2"
    }
    println("data validation :" + db2)
    println("ok")
    db2.conn()
    
    // also 
    db2.also{
        it.valid()
    }

}

// infix 중간 표기법 함수
infix fun String.appendEndfix(endFix: String): String {
    return this + endFix
}

fun plus(pair: Pair<Int, Int>) = pair.first + pair.second
fun plus(triple: Triple<Int, Int, Int>) = triple.first + triple.second + triple.third


class DBCon {
    var url: String? = null
    var dbSource: String? = null
    
    fun conn(): Boolean {
        println("connected")
        return true; 
    }

    fun valid(): Boolean {
        println("validation checked")
        return true; 
    }
}
