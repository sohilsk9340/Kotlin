package assignment_1

class Task10 {
    private var amount: Double = 0.0
    private var date: String = ""
    private var category: String = ""

    fun getAmount(): Double {
        return amount
    }

    fun setAmount(value: Double) {
        if (value > 0) {
            amount = value
        } else {
            throw IllegalArgumentException("Amount must be positive.")
        }
    }

    fun getDate(): String {
        return date
    }

    fun setDate(value: String) {
        if (value.matches("""\d{4}-\d{2}-\d{2}""".toRegex())) {
            date = value
        } else {
            throw IllegalArgumentException("Date must be in YYYY-MM-DD format.")
        }
    }

    fun getCategory(): String {
        return category
    }

    fun setCategory(value: String) {
        if (value.isNotEmpty()) {
            category = value
        } else {
            throw IllegalArgumentException("Category cannot be empty.")
        }
    }
}

fun main(){
    val transaction = Task10()
    transaction.setAmount(100.0)
    transaction.setDate("2023-01-01")
    transaction.setCategory("Groceries")

    println("Amount: ${transaction.getAmount()}")
    println("Date: ${transaction.getDate()}")
    println("Category: ${transaction.getCategory()}")
}