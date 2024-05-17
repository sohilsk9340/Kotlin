data class Event1(val name: String, val date: String, val attendeeCount: Int)

interface Display {
    fun showEventDetails()
    fun showDetails()
}

class Task6 : Display1 {
    private val events = mutableListOf<Event2>()

    fun addEvent(event: Event2) {
        events.add(event)
    }

    fun removeEvent(eventName: String) {
        events.removeIf { it.name == eventName }
    }

    override fun showEventDetails() {
        events.forEach { println("Event: ${it.name}, Date: ${it.date}, Attendees: ${it.attendeeCount}") }
    }
}

fun main() {
    val eventManager = Task7Notification()


    eventManager.addEvent(Event2("Ted-X", "2023-04-04", 2000))
    eventManager.addEvent(Event2("Bonsai Workshop", "2024-01-10", 100))
    eventManager.addEvent(Event2("Art Display","2024-05-17", 500))



    println("Event Details:")
    eventManager.showEventDetails()


    eventManager.removeEvent("Bonsai Workshop")


    println("\nEvent Details after removing 'Bonsai Workshop':")
    eventManager.showEventDetails()
}
