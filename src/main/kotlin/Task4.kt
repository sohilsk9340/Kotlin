import java.time.LocalDate

// Define the Transaction class
class Task4(
    val amount: Double,
    val date: LocalDate,
    val description: String,
    var category: String = "Uncategorized" // Default value
) {
    // Function to categorize transactions
    fun categorizeTransaction() {
        category = when {
            description.contains("grocery", ignoreCase = true) -> "Food"
            description.contains("restaurant", ignoreCase = true) -> "Food"
            description.contains("cafe", ignoreCase = true) -> "Food"
            description.contains("utility", ignoreCase = true) -> "Utilities"
            description.contains("electricity", ignoreCase = true) -> "Utilities"
            description.contains("water bill", ignoreCase = true) -> "Utilities"
            description.contains("movie", ignoreCase = true) -> "Entertainment"
            description.contains("concert", ignoreCase = true) -> "Entertainment"
            description.contains("theater", ignoreCase = true) -> "Entertainment"
            else -> "Miscellaneous"
        }
    }

    // Override toString method for easy printing
    override fun toString(): String {
        return "Transaction(amount=$amount, date=$date, description='$description', category='$category')"
    }
}

fun main() {
    // Create some transactions
    val transactions = listOf(
        Task4(50.0, LocalDate.of(2024, 5, 14), "grocery shopping"),
        Task4(100.0, LocalDate.of(2024, 5, 12), "electricity bill"),
        Task4(30.0, LocalDate.of(2024, 5, 13), "movie night"),
        Task4(20.0, LocalDate.of(2024, 5, 15), "restaurant lunch"),
        Task4(15.0, LocalDate.of(2024, 5, 16), "cafe coffee"),
        Task4(45.0, LocalDate.of(2024, 5, 17), "concert ticket"),
        Task4(60.0, LocalDate.of(2024, 5, 18), "water bill")
    )

    // Categorize each transaction
    transactions.forEach {
        it.categorizeTransaction()
        println(it)
    }
}
