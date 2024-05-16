class Transaction {
    var amount: Double = 0.0;
    var date: String = "";
    var category: String = "";

    fun info(): String{
        return "Amount: $amount, Date: $date, Category: $category"
    }
}

fun main(){
    var tran1 = Transaction()

    tran1.amount = 2000.0
    tran1.date = "10/01/2023"
    tran1.category = "Shoping"

    print(tran1.info())
}