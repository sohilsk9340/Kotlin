package assignment_1

data class Transaction1(val amount: Double, val type: TransactionType)

enum class TransactionType {
    EXPENSE, INCOME
}

fun List<Transaction1>.totalExpenses(): Double {
    return this.filter { it.type == TransactionType.EXPENSE }.sumOf { it.amount }
}

fun List<Transaction1>.totalIncomes(): Double {
    return this.filter { it.type == TransactionType.INCOME }.sumOf { it.amount }
}

fun main() {
    val transactions = listOf(
        Transaction1(amount = 100.0, type = TransactionType.INCOME),
        Transaction1(amount = 50.0, type = TransactionType.EXPENSE),
        Transaction1(amount = 200.0, type = TransactionType.INCOME),
        Transaction1(amount = 150.0, type = TransactionType.EXPENSE)
    )

    val totalExpenses = transactions.totalExpenses()
    val totalIncomes = transactions.totalIncomes()

    println("Total expenses: $totalExpenses")
    println("Total incomes: $totalIncomes")
}