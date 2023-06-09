/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package practices

// top+Level 
var topLevelVar: Int = 0

class App {
    val greeting: String
        get() {
            // top+Level ++
            topLevelVar++

            return "Hello World!"   
        }

    // Static
    companion object {
        var idx: Int = 0
        const val DAY_TIME: Long = 3600 * 24 * 1 

        fun increment() {
            idx++
            println("call by increment : " + idx)
        }
    }

}

// Pure Java 15 -> record, ex) public record Junk() {}
data class Junk(
    val name: String,
    val time: Long
)

// Singletone
object GlobalVariable {
    const val hour: Int = 60*60 
}

// ext
fun String.checkEmail(): Boolean {
    val email_regex = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})";
    println(this)
    return email_regex.toRegex().matches(this)
}

// ext 
fun String.appendSubfix(subfix: String): String {
    // 문자열 템플릿 
    return "${this} ${subfix}"
}

fun main() {
    println(App().greeting)
    
    // new없이 가능. 
    val junk = Junk("TestJunk", 10L)
    println(junk.toString())
    println(junk.name.toString())

    // Singletone
    println(GlobalVariable.hour)
    
    // Static 
    App.increment()
    App.increment()
    
    println("DAY_TIME: "+ App.DAY_TIME)

    val num: Int = 13
    // 삼항연산자 if else 
    val result: String = if (num%2 == 0) "odd" else "even"
    println("ODD or EVEN : " + result)
    println(" \n ")
    
    // ext 
    println("hyeongmeme@naver.com".checkEmail())
    println("danaka-ojisang.com".checkEmail())
    println("danaka".appendSubfix(",Sir"))

    // NPE: Null Point Exception 
    var name: String? = null
    // compile error :  Only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type String?
    // name.length 

    // safe-call : null 일수도있음, null인경우 length 실행 안함 (정상처리)
    name?.length

    // Null이 확실히 아니다 : Exception in thread "main" java.lang.NullPointerException
    // name!!.length


    // val(value) , var(variable)

    println(" topLevel ... : "+ topLevelVar)
    
    println(" \n ")

    whatIs(sound = "mongmong.")
    whatIs("cat", "meow~")

    println(" \n ")

    val scheduleOH = when (6) {
        6 -> "sleeping"
        7 -> "sleeping"
        else -> "sad.."
    }
    
    println(scheduleOH)

    val scheduleOHEnumType = when (ENUM_DAY.FIR) {
        ENUM_DAY.SAT, ENUM_DAY.SUN -> "sleeping"
        else -> "sad.."
    }
    
    println(scheduleOHEnumType)

    val numbers = arrayOf(0,1,2,3)
    for(i in numbers){
        print(i)
    }
    println(" ")
    for(i in 0 until 3){
        print(i)
    }
    println(" ")
    for(i in 0 until 6 step 2){
        print(i)
    }
    println(" ")
    for(i in 6 downTo 0){
        print(i)
    }

    println("\n ===== while test =====")
    var incrementData: Int = 0 
    while(true) {
        print(incrementData)
        if (incrementData == 5) break; 
        incrementData++
    }


}

enum class ENUM_DAY {
    MON, TUE, WED, THU, FIR, SAT, SUN
}

fun whatIs(animal: String = "dog", sound: String) {
    println("$animal: $sound")
}