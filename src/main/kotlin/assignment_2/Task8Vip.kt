package assignment_2

open class Event3(open val name: String, open val date: String, open val attendeeCount: Int)

interface Display2 {
    fun showDetails()
}

class Task8Vip : Display2 {
    private val events = mutableListOf<Event3>()

    fun addEvent(event: Event3) {
        events.add(event)
    }

    fun removeEvent(eventName: String) {
        events.removeIf { it.name == eventName }
    }

    override fun showDetails() {
        events.forEach {
            println(it)
            if (it is SpecialEvent) {
                println("VIP List: ${it.vipList}")
                println("Premium Services: ${it.premiumServices}")
            }
        }
    }
}

data class SpecialEvent(
    override val name: String,
    override val date: String,
    override val attendeeCount: Int,
    val vipList: List<String>,
    val premiumServices: List<String>
) : Event3(name, date, attendeeCount)

fun main() {
    val eventManager = Task8Vip()

    // Adding regular events
//    eventManager.addEvent(Event3("Kotlin Workshop", "2024-06-01", 100))
//    eventManager.addEvent(Event3("Tech Conference", "2024-07-15", 200))

    // Adding a special event
    val specialEvent = SpecialEvent(
        "Bob Marley Concert",
        "2024-08-20",
        150000,
        listOf("Sohil", "Rihan", "Aayush"),
        listOf("Special Treatment", "Private Seating")
    )
    eventManager.addEvent(specialEvent)

    println("VIP Added:")
    eventManager.showDetails()
    // Showing event details
//    println("Events:")
//    eventManager.showDetails()

    // Removing a regular event
//    eventManager.removeEvent("Kotlin Workshop")

    // Showing event details after removal
//    println("\nEvents after removing 'Kotlin Workshop':")
//    eventManager.showDetails()
}
