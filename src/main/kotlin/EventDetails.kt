class EventDetails {
    var name: String = ""
    var date: String = ""
    var ateendeeCount: Int = 0

    fun display(): String{
        return "$name, $date, $ateendeeCount"
    }
}

fun main(){
    var event = EventDetails()
    event.name = "Concert of Diljit Dosanj"
    event.date = "04/06/2024"
    event.ateendeeCount = 200000

    println(event.display())
}