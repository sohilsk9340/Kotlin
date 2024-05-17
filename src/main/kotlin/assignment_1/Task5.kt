package assignment_1
data class Task5(
    val id: Int,
    val amount: Double,
    val date: String, // For simplicity, we'll use String to represent the date
    val category: String
)

class TransactionList {
    private val transactions = mutableListOf<Task5>()
    private var nextId = 1

    // Function to add a new transaction
    fun addTransaction(amount: Double, date: String, category: String): Task5 {
        val transaction = Task5(nextId, amount, date, category)
        transactions.add(transaction)
        nextId++
        return transaction
    }

    // Function to delete a transaction by ID
    fun deleteTransaction(id: Int): Boolean {
        return transactions.removeIf { it.id == id }
    }

    // Function to edit an existing transaction by ID
    fun editTransaction(id: Int, newAmount: Double, newDate: String, newCategory: String): Boolean {
        val transaction = transactions.find { it.id == id }
        return if (transaction != null) {
            transactions[transactions.indexOf(transaction)] = transaction.copy(
                amount = newAmount,
                date = newDate,
                category = newCategory
            )
            true
        } else {
            false
        }
    }

    // Function to list all transactions
    fun listTransactions() {
        if (transactions.isEmpty()) {
            println("No transactions available.")
        } else {
            transactions.forEach { println(it) }
        }
    }
}

fun main() {
    val transactionList = TransactionList()

    while (true) {
        println("\nOptions:")
        println("1. Add new transaction")
        println("2. Edit existing transaction")
        println("3. Delete a transaction")
        println("4. List all transactions")
        println("5. Exit")
        print("Choose an option: ")

        when (readLine()?.trim()) {
            "1" -> {
                print("Enter amount: ")
                val amount = readLine()?.toDoubleOrNull()
                print("Enter date (yyyy-MM-dd): ")
                val date = readLine()?.trim()
                print("Enter category: ")
                val category = readLine()?.trim()

                if (amount != null && date != null && category != null) {
                    val transaction = transactionList.addTransaction(amount, date, category)
                    println("Transaction added successfully: $transaction")
                } else {
                    println("Invalid input. Please try again.")
                }
            }
            "2" -> {
                print("Enter transaction ID to edit: ")
                val id = readLine()?.toIntOrNull()
                if (id != null) {
                    print("Enter new amount: ")
                    val newAmount = readLine()?.toDoubleOrNull()
                    print("Enter new date (yyyy-MM-dd): ")
                    val newDate = readLine()?.trim()
                    print("Enter new category: ")
                    val newCategory = readLine()?.trim()

                    if (newAmount != null && newDate != null && newCategory != null) {
                        val editSuccess = transactionList.editTransaction(id, newAmount, newDate, newCategory)
                        if (editSuccess) {
                            println("Transaction edited successfully.")
                        } else {
                            println("Transaction not found.")
                        }
                    } else {
                        println("Invalid input. Please try again.")
                    }
                } else {
                    println("Invalid ID. Please try again.")
                }
            }
            "3" -> {
                print("Enter transaction ID to delete: ")
                val id = readLine()?.toIntOrNull()
                if (id != null) {
                    val deleteSuccess = transactionList.deleteTransaction(id)
                    if (deleteSuccess) {
                        println("Transaction deleted successfully.")
                    } else {
                        println("Transaction not found.")
                    }
                } else {
                    println("Invalid ID. Please try again.")
                }
            }
            "4" -> {
                println("List of transactions:")
                transactionList.listTransactions()
            }
            "5" -> {
                println("Exiting the Transaction Manager. Goodbye!")
                break
            }
            else -> {
                println("Invalid option. Please choose a valid option.")
            }
        }
    }
}
