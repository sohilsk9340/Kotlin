package assignment_1

import java.lang.Exception
import java.util.Scanner

class Day4Task2{
    var sc = Scanner(System.`in`)
    var amount: Double = sc.nextDouble()
    var date: String = sc.nextLine()

    fun exception(){
        try {
            if (amount>0 ){
                println("Amount: $amount , Date: $date")
            }

        }catch (e: Exception){
            println("Enter a valid Amount")
        }
    }
}

fun main(){
    println("Enter Amount & Date(dd/mm/yyyy)")
    var obj = Day4Task2()
    obj.exception()
}

