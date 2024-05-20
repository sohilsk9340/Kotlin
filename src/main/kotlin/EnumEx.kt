enum class EnumEx(var color: String) {
    Sunday("yellow"),
    Monday(""),
    Tuesday(""),
    Wednesday(""),
    Thursday(""),
    Friday(""),
    Saturday("")
}

fun main() {
    val color = EnumEx.Sunday.color;
    println(color)
}