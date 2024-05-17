package assignment_1
data class Task6(
    val amount: Double,
    val date: String, // For simplicity, we'll use String to represent the date
    val category: String
)

class User(private val username: String, private val password: String) {
    private val transactions = mutableListOf<Task6>()

    fun login(inputUsername: String, inputPassword: String): Boolean {
        return inputUsername == username && inputPassword == password
    }

    fun addTransaction(amount: Double, date: String, category: String) {
        transactions.add(Task6(amount, date, category))
    }

    fun displayExpenseSummary() {
        val summary = transactions.groupBy { it.category }
            .mapValues { entry -> entry.value.sumByDouble { it.amount } }
        println("Expense Summary:")
        summary.forEach { (category, total) ->
            println("Category: $category, Total: $total")
        }
    }
}

fun main() {
    val user = User("sohil", "123")

    print("Enter username: ")
    val username = readLine()?.trim() ?: ""
    print("Enter password: ")
    val password = readLine()?.trim() ?: ""

    if (user.login(username, password)) {
        println("Login successful. Welcome, $username!")
        user.addTransaction(100.0, "2024-05-01", "Food")
        user.addTransaction(50.0, "2024-05-02", "Utilities")
        user.displayExpenseSummary()
    } else {
        println("Login failed. Incorrect username or password.")
    }
}
