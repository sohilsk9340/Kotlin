package assignment_1

fun main(){
    var a = 10
    var b = 2
    println("a + b = " + (a + b))
    println("a - b = " + (a - b))
    println("a * b = " + (a.times(b)))
    println("a / b = " + (a / b))
    println("a % b = " + (a.rem(b)))

    println("********* For Loop ************")

    for (i in 1..10){
        println(i)
    }
}