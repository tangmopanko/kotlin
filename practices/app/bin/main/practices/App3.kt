package practices
import java.util.*
import java.util.stream.Collectors
import kotlin.collections.ArrayList

// https://kotlinlang.org/docs/collections-overview.html#list
fun main() {

    // immutable
    val nationCodes = listOf("en", "ko", "ero")
    
    // mutable 
    val nationCodesMutable = mutableListOf<String>().apply {
        add("en")
        add("ko")
    }
    nationCodesMutable.add("ero")
    println(nationCodesMutable.toString())

    // immutable
    val numberSet = setOf(1,2,3,4,4)
    println(numberSet)

    val numberSetMutable = mutableSetOf<Int>().apply {
        add(1)
        add(1)
        add(2)
        add(1)
    }

    numberSetMutable.add(4)
    println(numberSetMutable)

    // immutable
    val dataMap = mapOf("dankdolgi" to 1, "ggubuki" to 2)

    val dataMapMutable = mutableMapOf<String, Int>()
    dataMapMutable["dankdolgi"] = 1
    dataMapMutable["ggubuki"] = 2
    println(dataMapMutable)

    // build -> mutable이지만 return은 immutable
    val dataList: List<Int> = buildList{
        add(1)
        add(2)
        add(3)
    }
    println(dataList)

    val arrList = ArrayList<String>().apply  {
        add("dc")
        add("marble")
    }

    val iter = arrList.iterator() 
    while (iter.hasNext()) {
        print(iter.next())
    }
    println()
    arrList.forEach {
        print(it)
    }

    /**
    val filtered = arrList.filter{ it.equals("dc") };
    println(filtered)
     */
    
    val filtered = arrList.stream().filter{ it.equals("dc") }.collect(Collectors.toList())
    println(filtered)
        
    // terminal operator toList 
    // filter같은 연산자가 많을 수록 조건에 다른 Collection이 생성되어 memory issue가 있음 그래서 asSequence를 사용하여 이를 방지 (terminal operator 실행시 collection을 생성) ex 단 5~10 만건일 경우는 그냥 사용하는게 좋음. 
    val filteredList = arrList
    .asSequence()
    .filter { it.equals("dc") }
    .toList()



}