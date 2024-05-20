data class User(val id: Int, val name: String, val email: String)

class Task12 {
    private val users = mutableListOf<User>()

    // Function to add a user
    fun addUser(user: User) {
        if (users.any { it.id == user.id }) {
            println("User with id ${user.id} already exists.")
        } else {
            users.add(user)
            println("${user.name} added.")
        }
    }

    // Function to remove a user by id
    fun removeUser(userId: Int) {
        val user = users.find { it.id == userId }
        if (user != null) {
            users.remove(user)
            println("${user.name} removed.")
        } else {
            println("User with id $userId not found.")
        }
    }

    // Function to display all users
    fun displayUsers() {
        if (users.isEmpty()) {
            println("No users available.")
        } else {
            users.forEach { println(it) }
        }
    }
}

fun main() {
    val userManager = Task12()

    // Adding users
    userManager.addUser(User(1, "Sohil", "sohilskkhan9340@gmai.com"))
    userManager.addUser(User(2, "Rihan", "rihan@gmal.com"))
    userManager.addUser(User(3, "Eshan", "eshan144@gmal.com"))
    userManager.addUser(User(4, "Sadan", "sad1324@gmal.com"))


    println("All Users:")
    userManager.displayUsers()


    userManager.removeUser(4)


    println("Users after removal:")
    userManager.displayUsers()
}
