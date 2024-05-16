import java.util.Scanner

class nullStrHandlling {
    fun ok() {
        var s: String? = readLine()

        if(s != null) {
            println()
        } else {
            println("Value is null")
        }

        print(s)
    }
}

fun main() {
    var obj = nullStrHandlling()
    obj.ok()
}