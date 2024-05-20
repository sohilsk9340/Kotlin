package assignment_1

import java.io.File

// Define the Transaction class
data class Transaction(val amount: Double, val date: String, val category: String)

// Define the Exportable interface
interface Exportable {
    fun exportToCSV(filename: String)
}

// Implement the TransactionList class with Exportable interface
class Task9Csv : Exportable {
    private val transactions = mutableListOf<Transaction>()

    fun addTransaction(transaction: Transaction) {
        transactions.add(transaction)
    }

    fun removeTransaction(transaction: Transaction) {
        transactions.remove(transaction)
    }

    fun editTransaction(oldTransaction: Transaction, newTransaction: Transaction) {
        val index = transactions.indexOf(oldTransaction)
        if (index != -1) {
            transactions[index] = newTransaction
        }
    }

    override fun exportToCSV(filename: String) {
        val file = File(filename)
        file.printWriter().use { out ->
            out.println("Amount,Date,Category")
            transactions.forEach {
                out.println("${it.amount},${it.date},${it.category}")
            }
        }
    }
}

fun main() {
    val transactionList = Task9Csv()

    // Adding transactions
    transactionList.addTransaction(Transaction(100.0, "2024-05-01", "Food"))
    transactionList.addTransaction(Transaction(200.0, "2024-05-02", "Utilities"))
    transactionList.addTransaction(Transaction(3200.0, "2023-02-12", "Shopping"))
    transactionList.addTransaction(Transaction(1000.0, "2024-01-12", "Movie"))
    transactionList.addTransaction(Transaction(1000.0, "2023-12-01", "Rent"))

    // Exporting to CSV
    transactionList.exportToCSV("transactions.csv")

    println("Transactions exported to transactions.csv")
}
