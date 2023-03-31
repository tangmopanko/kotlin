package practices
import java.util.*
import java.util.stream.Collectors
import kotlin.collections.ArrayList

data class Animal(val name: String, val age: Int){}

fun main() {
    val dog = Animal("dog", 2)
    println(dog.toString())
    
    val cat = dog.copy(name = "cat", age = 1)
    println(dog.toString() + cat.toString())
    println("${dog.component1()}, ${dog.component2()}")


    val cat1 = Cat("cat", 1)
    cat1.eat("dd")
    val dog1 = Dog("dog", 1)
    cat1.eat("dd")
    Animals.add(cat1)

    Animals.add(dog1)
    //println(Animals.get("cat"))

}

sealed class SealedAnimal {
    abstract val name: String
    abstract val age: Int
    abstract fun eat(foodKind: String)
}

data class Cat(override val name: String, override val age: Int): SealedAnimal() {
    
    override fun eat(foodKind: String) {
        //println(" CAT is eat: ${food}")
    }
    
}

data class Dog(override val name: String, override val age: Int): SealedAnimal() {
    
    override fun eat(foodKind: String) {
        //println(" Dog is eat: ${food}")
    }
}

object OtherAnimal : SealedAnimal() {

    override val name: String = "익명"
    override val age: Int = 999
    override fun eat(foodKind: String) {}

}


object Animals {
    val animals = mutableMapOf<String, SealedAnimal>()

    fun add(animal: SealedAnimal) = when(animal) {
        is Cat -> animals[animal.name] = animal
        is Dog -> animals[animal.name] = animal
        is OtherAnimal -> println("")
    }

    fun get(name: String) = animals[name]
}