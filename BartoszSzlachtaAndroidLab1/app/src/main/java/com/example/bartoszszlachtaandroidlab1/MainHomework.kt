package com.example.bartoszszlachtaandroidlab1

open class Animal(
    private val name: String,
    private val age: Int,
    private val species: String
) {
    open fun move() {
        println("$name is moving.")
    }

    override fun toString(): String {
        return "Hi I am $name I am $age years old and my species is $species!"
    }
}

class Fish(
    private val name: String,
    private val age: Int,
    private val species: String
) : Animal(name, age, species) {
    override fun move() {
        println("$name is swimming.")
    }
}

class Dog(
    private val name: String,
    private val age: Int,
    private val species: String
) : Animal(name, age, species) {
    override fun move() {
        println("$name is running.")
    }
}

fun main() {
    val fish = Fish("Fish", 52, "Fish")
    val dog = Dog("Dog", 52, "Dog")
    fish.move()
    println(fish)
    dog.move()
    println(dog)
    val animalFish: Animal = Fish("AnimalFish", 52, "Fish")
    animalFish.move()
    println(animalFish)
}