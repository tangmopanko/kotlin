package practices

class Car(var name: String, var price: Int = 2000) {
    val proto: String get() {
        return "this is string of CAR-Typea Proto"
    }
    // Backing Field는 accessor안에서 field keyword로 접근할 수 있음 
    // field가 아닌 변수를 지정한다면 재귀호출이 되어 stack of flow가 발생한다. 
    var bigSalePercent: Int = 0
        set(value) {
            if (value > 0) {
                field = value 
                disCountAmount = (price * (bigSalePercent * 0.01)).toInt()
            }
    }
    
    var disCountAmount: Int = 0 

    fun printData() {
        println("${name}, ${price}, ${proto}, ${disCountAmount}")
    }

}

// 상속 extend 
open class Adapter {
    // 자식에서 변경 못하도록 
    final val type: String = "ADAP"

    open var watt: Int = 220
    open fun sync() {
        println("sync && sync ")
    }
}
// 상속 extend 
class EuroAdapter(override var watt: Int = 0): Adapter(){

    override fun sync() {
        super.sync()
    }
}


fun main() {
    println("running.. practices.App1")
    val car = Car("pony")
    car.printData()

    car.bigSalePercent = 10
    car.printData()

    println(" \n ")
    val adap = EuroAdapter(110)
    println("${adap.type}, ${adap.watt}")
    adap.sync()

    println("     \n        ")
    
    val danaka = Danaka(name = "danaka", age = 34)
    danaka.eat("wasabi")
    
    println("     \n        ")

    val item1 = Item("/tmp/d/test1.text", 32)
    val chunk = ProcChunk(1)
    chunk.add(item1)
    chunk.remove(item1)

}

abstract class Human {
    abstract var name: String 
    abstract var age: Int 
    abstract fun eat(food: String)
}

class Danaka(override var name: String, override var age: Int ): Human() {
    
    override fun eat(food: String) {
        println("${name} .. eating.. ${food}")
    }
}

interface Messager {
    fun add(item: Item) {
        println("added File and send to the message..")
    }
}

class Item(val filePath: String, val size: Int) 

interface Chunk {
    var count: Int 

    fun add(item: Item) 

    fun remove(item: Item) {
        println("delete to the item.")
    }
}
// interface를 추가함 
class ProcChunk(override var count: Int): Chunk, Messager {

    override fun add(item: Item) {
        println("add to the item")
        // Super<T>( generic ) 로 명확하게 지정해줌 
        super<Messager>.add(item)
    }

    

}

