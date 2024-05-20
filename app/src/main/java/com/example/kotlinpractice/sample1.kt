package com.example.kotlinpractice

import androidx.compose.ui.text.toUpperCase

fun main() {
//    // 3. String Template
//    // 변수 표현하고 싶다면 $를 넣어주자. 만약 쓸거면 띄워쓰고 띄워쓰고 싶지 않다면 대괄호를 넣어주자
//    val name = "Nemnem"
//    val lastName = "wodk"
//    println("My name is ${name + lastName} I'm 27")
//
//    println("is this true? ${1==0}")
//
//    // 만약 $를 쓰고 싶다면 앞에 백슬래쉬 \를 넣어주자
//    println ("this is 2\$a")

}

//// 1. 함수
//// 앞에는 항상 fun
//fun helloWorld() {
//    println("hello World");
//}
//
//// 변수명을 타입보다 먼저 써주기
//fun add(a: Int, b: Int) : Int {
//    return a + b
//}
//
//// 2. val var 차이점
//// val - value(바뀌지 않음) / var 바뀌는거 가능.
//fun hi() {
//    val a : Int = 10
//    var b : Int = 9
//
//    // a = 100 // val로 했으니 바꾸려고 하면 에러가 뜬다
//
//    // Int라고 안적어도 Int라고 인힉함
//    val c = 100
//    var d = 100
//
//    var name = "Nemnem"
//}

// 4. 조건식
fun maxBy(a : Int, b : Int) : Int {
    if(a > b) {
        return a
    } else {
        return b
    }
}

// 이게 3항 연산자
fun maxBy2(a : Int, b: Int) = if(a>b) a else b

fun checkNum(score : Int) {
    // when은 switch느낌
    when(score) {
        0 -> println("this is 0")
        1 -> println("this is 1")
        2,3 -> println("this is 2 or 3")
        else -> println("I don't know")
    }

    var b = when(score) {
        1 -> 1
        2 -> 2
        // when을 사용할 때 else는 필수임.
        else -> 3
    }

    println("b : ${b}")

    when(score){
        // in을 사용할 때는 ..을 사용해주자
        in 90..100 -> println("You are genius")
        in 10..80 -> println("Not Bad")
        else -> println("okay")
    }
}

// Expression VS Statement
// 코틀린의 모든 함수는 Expression

// 5. Array and List
// Array -> 메모리가 할당이 되어있어서 처음에 사이즈를 지정해줘야함. 값 변경 가능

// List -> 수정 불가능. 읽기 전용 / MutableList -> 수정이 가능, 읽기, 쓰기 둘 다 가능

fun array() {
    val array = arrayOf(1,2,3)
    val list = listOf(1,2,3)

    val array2 = arrayOf(1, "d", 3.4f)
    val list2 = listOf(1, "d", 11L)

    array[0] = 3
    // 오류가 뜬다.
    // list[0] = 2

    // get으로 값을 가져올 수는 있지만 바꿀 수는 없다.
    var result = list.get(0)

    var arrayList = arrayListOf<Int>()
    arrayList.add(10)
    arrayList.add(20)
}

// 6. 반복문 for, while
fun forAndWhile() {
    var students = arrayListOf("joyce", "james", "nemnem", "jenny")
    // in을 사용해서 for문 사용
    for(name in students) {
        println("${name}")
    }

    // index, name을 같이 사용 가능
    for((index, name) in students.withIndex()) {
        println("${index + 1}번째 학생 : ${name}")
    }

    // 1~10까지
    var sum : Int = 0
    // step은 2씩 증가
    // downTo <- 10~1까지
    // until 100 <- 1~99까지 ex) i in 1 until 100
    for(i in 1..10 step 2) {
        sum += i
    }
    println(sum)

    var index = 0
    while (index < 10) {
        println("current index : ${index}")
        // index++를 하지 않으면 숫자가 증가될 수 없으니 계속 0만 뜬다.
        index++
    }
}

// 7. Nullable / NonNull
fun nullcheck() {
    // NPE : Null pointer Exception

    var name : String = "joyce"
    var nullName : String? = null // ?를 붙여주면 Nullable 형태로 바뀐다.
    var nameInUpperCase = name.toUpperCase()
    // null이면 null반환함. 아니면 실행.
    var nullNameInUpperCase = nullName?.toUpperCase()

    // ?: <- 엘비스 연산자 라고 함. default값을 주고 싶을 때 사용
    val lastName : String? = "nemnem"
    // 만약 lastName이 없으면 No lastName이라는 default값을 출력함.
    val fullName = name + " " + (lastName?: "NO lastName")
    println(fullName)

}
// !! 연산자 -> null아닌지 알려줄 때 사용
// null이 아니라고 미리 지정
fun ignoreNulls(str : String?) {
    // 정말로 확실하지 않는 이상 사용 x
    val mNotNull : String = str!!
    val upper = mNotNull.toUpperCase()

    // let함수 -> 자신의 리시버 객체를 람다식 내부로 옮겨줌. null이 아니면 저 안으로 email을 옮겨줌
    val email : String? = "nemnem@naver.com"
    // null 체크중
    email?.let {
        println("my email is ${email}")
    }
}

