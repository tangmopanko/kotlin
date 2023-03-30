/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package practices

class App {
    val greeting: String
        get() {
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

fun main() {
    println(App().greeting)
    
    // new없이 가능. 
    val junk = Junk("TestJunk", 10L)
    println(junk.toString())
    println(junk.name.toString())

    println(GlobalVariable.hour)
    App.increment()
    App.increment()
    
    println("DAY_TIME: "+ App.DAY_TIME)

    val num: Int = 13
    // 삼항연산자 if else 
    val result: String = if (num%2 == 0) "odd" else "even"
    println("ODD or EVEN : " + result)
    println(" \n ")
    
    println("hyeongmeme@naver.com".checkEmail())
    println("danaka-ojisang.com".checkEmail())


}
