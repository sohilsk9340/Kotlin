data class Event2(val name: String, val date: String, val attendeeCount: Int)

interface Display1 {
    fun showEventDetails()
}

class Task7Notification : Display1 {
    private val events = mutableListOf<Event2>()
    private val notification = mutableListOf<(Event2) -> Unit>()

    fun addEvent(event: Event2) {
        events.add(event)
        notify(event)
    }

    fun removeEvent(eventName: String) {
        val event = events.find { it.name == eventName }
        if (event != null) {
            events.remove(event)
            notify(event)
        }
    }

    override fun showEventDetails() {
        events.forEach { println("Event: ${it.name}, Date: ${it.date}, Attendees: ${it.attendeeCount}") }
    }

    fun registerListener(listener: (Event2) -> Unit) {
        notification.add(listener)
    }

    private fun notify(event: Event2) {
        notification.forEach { it(event) }
    }
}

fun main() {
    val eventManager = Task7Notification()

    eventManager.registerListener { event ->
        println("Notification: Event '${event.name}' has been updated.")
    }

    eventManager.addEvent(Event2("Ted-X", "2023-04-04", 2000))
    eventManager.addEvent(Event2("Bonsai Workshop", "2024-01-10", 100))
    eventManager.addEvent(Event2("Art Display","2024-05-17", 500))



    println("Event Details:")
    eventManager.showEventDetails()


    eventManager.removeEvent("....")


    println("\nEvent Details after removing '....':")
    eventManager.showEventDetails()
}
