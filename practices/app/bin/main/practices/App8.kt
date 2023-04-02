package practices
import java.util.*
import java.util.stream.Collectors
import kotlin.collections.ArrayList

fun throwError(): Nothing = throw Exception("New throw Exception")

fun main() {
    // https://arrow-kt.io/docs/apidocs/arrow-core/arrow.core/-either/index.html#either
    runCatching { throwError() }.getOrElse {
        println(it.message)
    }
    // getOrNull exceptionOrNull getOrDefault 
    /**
    var result: Throwable? = runCatching { throwError() }
        .exceptionOrNull()

    result?.let {
        println(it.message)
        throw it 
    }
    */

    //var func: ()-> Unit = {}
    var print: () -> Unit = { println("Unit print")}
    
    var list = mutableListOf(print)
    val func: () -> Unit = list[0]
    func()
}   
