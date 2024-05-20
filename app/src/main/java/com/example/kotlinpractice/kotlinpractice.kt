package com.example.kotlinpractice


//1. Lamda
// 람다식은 value처럼 다룰 수 있는 익명함수
// 1) 메소드 파라미터로 넘겨줄 수 있다. fun maxBy(a: Int) <- 파라미터
// 2) return 값으로 사용할 수 있다.

// 람다의 기본정의
// val lamdaName : Type = {argumentList -> codeBody}

// Int -> Int를 선언해줘야 타입 추론이 가능함.
// 방법 1
val square = {number : Int -> number * number}

// 방법 2
val square2 : (Int) -> (Int) = {number : Int -> number * number}

val nameAge = {name : String, age : Int ->
    "my name is ${name} I'm ${age}"
}

fun main() {
    println(square(12))
    println(nameAge("Nemnem", 28))

    val a = "nemnem said"
    val b = "joy said"
    println(a.pizzaIsGreat())
    println(b.pizzaIsGreat())

    println(extendString("Nemnem", 28))
    println(calculateGrade(99))
    println(calculateGrade(999))

    // 1. 람다 표현 방법 1
    val lamda = {number : Double ->
        number == 4.3213
    }
    println(invokeLamda(lamda))

    // 2. 람다 표현 방법 2
    // it은 넣는 파라미터가 하나일 때 사용
    println(invokeLamda { it > 3.22 })

    // 첫 번째 파라미터이자 마지막 파라미터 이면 () 생략 가능.
    println(invokeLamda { it > 3.22 })

    // 내부 익명 함수
}

// 확장함수
val pizzaIsGreat : String.() -> String = {
    this + " Pizza is the best!"
}

fun extendString(name : String, age : Int) : String {
    val introduceMyself : String.(Int) -> String = { "I am ${this} and ${it} years old"}
    return name.introduceMyself(age)
}

// 람다의 return
// 항상 String을 return해줘야 하는데 return을 해줘야 하니 else 꼭 지정
val calculateGrade : (Int) -> String = {
    when(it) {
        in 0..40 -> "fail"
        in 41..70 -> "pass"
        in 71.. 100 -> "perfect"
        else -> "Error"
    }
}

// 람다를 표현하는 2가지 방법
fun invokeLamda(lamda : (Double) -> Boolean) : Boolean {
    return lamda(5.2343)
}