data class Task5(val name: String, val date: String, val attendeeCount: Int)

class EventManager {
    private val events = mutableListOf<Task5>()

    fun addEvent(event: Task5) {
        events.add(event)
    }

    fun removeEvent(eventName: String) {
        events.removeIf { it.name == eventName }
    }

    fun listEvents() {
        events.forEach { println(it) }
    }
}

fun main() {
    val eventManager = EventManager()


    eventManager.addEvent(Task5("Ted-X", "2023-04-04", 2000))
    eventManager.addEvent(Task5("Bonsai Workshop", "2024-01-10", 100))
    eventManager.addEvent(Task5("Art Display","2024-05-17", 500))


    println("Events after adding:")
    eventManager.listEvents()


    eventManager.removeEvent("Art Display")


    println("\nEvents after removing 'Art Display':")
    eventManager.listEvents()
}
