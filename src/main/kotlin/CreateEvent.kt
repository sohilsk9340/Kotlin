import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

data class Event(
    val name: String,
    val date: LocalDate,
    val attendeeCount: Int
)
fun createEvent(): Event? {
    val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

    // Get event name
    print("Enter event name: ")
    val name = readLine()?.trim()

    if (name.isNullOrEmpty()) {
        println("Event name cannot be empty.")
        return null
    }

    // Get event date
    print("Enter event date (yyyy-MM-dd): ")
    val dateInput = readLine()?.trim()
    val date: LocalDate? = try {
        LocalDate.parse(dateInput, dateFormatter)
    } catch (e: DateTimeParseException) {
        println("Invalid date format. Please use yyyy-MM-dd.")
        return null
    }

    // Get attendee count
    print("Enter attendee count: ")
    val attendeeCountInput = readLine()?.trim()
    val attendeeCount: Int? = try {
        attendeeCountInput?.toInt()
    } catch (e: NumberFormatException) {
        println("Invalid number for attendee count.")
        return null
    }

    if (attendeeCount == null || attendeeCount < 0) {
        println("Attendee count must be a non-negative number.")
        return null
    }

    return Event(name, date!!, attendeeCount)
}
fun main() {
    println("Welcome to the Event Creator!")

    val events = mutableListOf<Event>()

    while (true) {
        println("\nOptions:")
        println("1. Create new event")
        println("2. List all events")
        println("3. Exit")
        print("Choose an option: ")

        when (readLine()?.trim()) {
            "1" -> {
                val event = createEvent()
                if (event != null) {
                    events.add(event)
                    println("Event created successfully: $event")
                } else {
                    println("Failed to create event. Please try again.")
                }
            }
            "2" -> {
                if (events.isEmpty()) {
                    println("No events available.")
                } else {
                    println("List of events:")
                    events.forEach { println(it) }
                }
            }
            "3" -> {
                println("Exiting the Event Creator. Goodbye!")
                break
            }
            else -> {
                println("Invalid option. Please choose 1, 2, or 3.")
            }
        }
    }
}
