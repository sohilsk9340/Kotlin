data class Transactions(val id: Int, val amount: Double, val date: String, val category: String)

// Generic function to print transactions from a List
fun <T : Transactions> printListTransactions(transactions: List<T>) {
    transactions.forEach { println(it) }
}


// Generic function to print transactions from a Set
fun <T : Transactions> printSetTransactions(transactions: Set<T>) {
    transactions.forEach { println(it) }
}

// Generic function to print transactions from a Map
fun <K, V : Transactions> printMapTransactions(transactions: Map<K, V>) {
    transactions.forEach { (key, value) ->
        println("Key: $key, Value: $value")
    }
}

fun main() {
    val transaction1 = Transactions(1, 100.0, "2024-05-01", "Food")
    val transaction2 = Transactions(2, 200.0, "2024-05-02", "Utilities")
    val transaction3 = Transactions(3, 300.0, "2024-05-03", "Entertainment")

    // List of transactions
    val transactionList = listOf(transaction1, transaction2, transaction3)
    println("Transactions in List:")
    printListTransactions(transactionList)

    // Set of transactions
    val transactionSet = setOf(transaction1, transaction2, transaction3)
    println("\nTransactions in Set:")
    printSetTransactions(transactionSet)

    // Map of transactions
    val transactionMap = mapOf(1 to transaction1, 2 to transaction2, 3 to transaction3)
    println("\nTransactions in Map:")
    printMapTransactions(transactionMap)
}
