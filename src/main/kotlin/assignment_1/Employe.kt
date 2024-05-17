package assignment_1

import java.util.*

data class Employe(
    var id: Int,
    var name: String,
    var position: String,
    var salary: Double
)

class EmployeeManagementSystem {
    private val employees = mutableListOf<Employe>()
    private var nextId = 1

    fun manageEmployees() {
        val scanner = Scanner(System.`in`)
        while (true) {
            println("Choose an operation: add, delete, update, list, or exit")
            when (scanner.nextLine()) {
                "add" -> addEmployee(scanner)
                "delete" -> deleteEmployee(scanner)
                "update" -> updateEmployee(scanner)
                "list" -> listEmployees()
                "exit" -> return
                else -> println("Invalid operation. Please choose again.")
            }
        }
    }

    private fun addEmployee(scanner: Scanner) {
        println("Enter employee name:")
        val name = scanner.nextLine()
        println("Enter employee position:")
        val position = scanner.nextLine()
        println("Enter employee salary:")
        val salary = scanner.nextLine().toDouble()

        val employee = Employe(nextId++, name, position, salary)
        employees.add(employee)
        println("Employee added: $employee")
    }

    private fun deleteEmployee(scanner: Scanner) {
        println("Enter employee ID to delete:")
        val id = scanner.nextLine().toInt()
        val employee = employees.find { it.id == id }
        if (employee != null) {
            employees.remove(employee)
            println("Employee deleted: $employee")
        } else {
            println("Employee not found.")
        }
    }

    private fun updateEmployee(scanner: Scanner) {
        println("Enter employee ID to update:")
        val id = scanner.nextLine().toInt()
        val employee = employees.find { it.id == id }
        if (employee != null) {
            println("Enter new name (leave blank to keep current name):")
            val name = scanner.nextLine()
            if (name.isNotBlank()) employee.name = name

            println("Enter new position (leave blank to keep current position):")
            val position = scanner.nextLine()
            if (position.isNotBlank()) employee.position = position

            println("Enter new salary (leave blank to keep current salary):")
            val salaryInput = scanner.nextLine()
            if (salaryInput.isNotBlank()) employee.salary = salaryInput.toDouble()

            println("Employee updated: $employee")
        } else {
            println("Employee not found.")
        }
    }

    private fun listEmployees() {
        if (employees.isEmpty()) {
            println("No employees found.")
        } else {
            employees.forEach { println(it) }
        }
    }
}

fun main() {
    val employeeManagementSystem = EmployeeManagementSystem()
    employeeManagementSystem.manageEmployees()
}
