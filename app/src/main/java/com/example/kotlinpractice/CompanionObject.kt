package com.example.kotlinpractice

// Companion Object
// 다른 곳에서 생성 못하게 막는 private constructor
class Book private constructor(val id : Int, val name : String) {

    companion object BookFactory : IdProvider {
        val myBook = "new Book"
        fun create() = Book(getId(), myBook)
        override fun getId(): Int {
           return 444
        }
    }
}

// 상속도 가능함.
interface IdProvider {
    fun getId() : Int
}

fun main() {
    // Conpanion : private 프로퍼티나 메소드를 읽어올 수 있게 함. static 역할
    // Companion 생략 가능
    val book = Book.create()

    val bookId = Book.BookFactory.getId()
    println(bookId)
    println("${book.id} ${book.name}")
}