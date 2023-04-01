package practices
import java.util.*
import java.util.stream.Collectors
import kotlin.collections.ArrayList

const val LUCKY_SEVEN: Int = 7

fun main() {
    checkAny("String")
    checkAny(12)

    val aArg: Int = 1
    val bArg: Int = 2
    println("$aArg + $bArg = ${add(aArg, bArg)} \t\t\t END \n")

    // 함수 참조 
    var plus = ::add
    println(plus(1, 2))

    // cast 
    var clazSuper: ClassSuper = ClassChild()
    var clazChild: ClassChild = clazSuper as ClassChild
    
    val library:String? = null
    println(library?.uppercase())
    // Exception in thread "main" java.lang.NullPointerException
    // println(library!!.uppercase()) 

    voidFun()

    multiArgs("A", "B", "C")
    val arrInt = arrayOf("A", "B", "C")
    multiArgs(*arrInt)

    val simple: () -> String = { " Is Simple " }
    println("\n simple : " + simple)
    
    val hello: () -> String = { "Hello world!" }
    printlnFunc(hello)
}

fun multiArgs(vararg args: String) {
    args.forEach {
        print(it)
    }   
}

fun printlnFunc(func: () -> String) {
    println("${func()}")
}

open class ClassSuper() {}
class ClassChild(): ClassSuper() {}

// return 값 없음 
fun voidFun(): Unit {
    println("Hello")
}

fun add(aArg: Int, bArg: Int): Int {
    return aArg + bArg
}

// object -> any
fun checkAny(arg: Any?) {
    when (arg) {
        is Int -> println("Is Int : $arg")
        is Char -> println("Is Char : $arg")
        is String -> println("Is String : $arg")
        else -> "other Kind"
    }
}
