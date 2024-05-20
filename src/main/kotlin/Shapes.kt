class Shapes {
    fun area(): Double{
        return 0.0
    }
}

fun main(){
    fun Shapes.parameter(): Double{
        return 0.0
    }

    var a = Shapes()
    a.area()
    a.parameter()
}