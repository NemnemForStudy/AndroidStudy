package com.example.kotlinpractice

// dataClass

data class Ticket(val companyName : String, val name : String, var date : String, var seatNember : Int)

// toString(), hashCode(), equals(), copy()

class TicketNormal(val companyName : String, val name : String, var date : String, var seatNember : Int)

fun main() {
    val ticketA = Ticket("KoreanAir", "Nemnem", "24/05/20", 8)
    val ticketB = TicketNormal("KoreanAir", "Nemnem", "24/05/20", 8)

    // data Class와 class 차이점
    println(ticketA)
    println(ticketB)
}