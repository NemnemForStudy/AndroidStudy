package com.example.kotlinpractice

// 상속 받게 할 수 있게 open을 해줘야함.
open class Human(val name : String = "defaultName") {

    // 부생성자는 주생성자의 위임을 받아야함. this로
    constructor(name : String, age : Int) : this(name){
        println("my name is ${name}, ${age} years old")

    }

    // 코드 블록을 넣기위한 init
    // init를 사용하면 같이 생성이 됨.
    init {
        println("New human has been born!!")
    }

    fun eatingCake(){
        println("This is so yummy~")
    }

    open fun singASong() {
        println("lalala")
    }
}

// class 상속
// 여기서 Human이라는 부모 생성자를 불렀고 부모 생성자에는 init가 있으니 init에 있는 println이 출력이 됨.
class Korean : Human() {
    override fun singASong() {
        super.singASong()
        println("라라라")
        // human에서 defaultName을 지정해줬기 때문에 name을 사용할 수 있음.
        println("my name is : ${name}")
    }
}

fun main() {
//    val human = Human("nemnem")
//
//    val stranger = Human()
//    human.eatingCake()

//    val mom = Human("seonOk", 59)

//    println("this human's name is ${stranger.name}")

    val korean = Korean()
    korean.singASong()
}