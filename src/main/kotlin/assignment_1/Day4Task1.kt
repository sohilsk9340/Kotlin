package assignment_1

import java.util.Scanner

class Day4Task1 {
    fun transaction(){

        var sc = Scanner(System.`in`)
        println("Enter Amount: ")
        var amount: Double? = sc.nextDouble()

        if ( amount != null){
            println(amount)
        }
        else{
            println("Please provide some value to Amount")
        }

    }
}

fun main(){
    val obj = Day4Task1()
    obj.transaction()
}