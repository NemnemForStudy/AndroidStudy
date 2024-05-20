package com.example.kotlinpractice

// 싱글톤 패턴 -> Car 객체를 실행될 때 객체 생성하고 다시는 생성 X -> 불필요한 메모리 누수 X
object CarFactory {
    val cars = mutableListOf<Car>()
    fun makeCar(horsePower: Int) : Car {
        val car = Car(horsePower)
        cars.add(car)
        return car
    }
}

data class Car(val horsePower : Int)

fun main() {
    val car = CarFactory.makeCar(10)
    val car2 = CarFactory.makeCar(200)

    println(car)
    println(car2)
    // CarFactory의 size
    println(CarFactory.cars.size.toString())
}