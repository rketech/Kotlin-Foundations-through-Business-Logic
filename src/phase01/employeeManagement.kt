package phase01

/*
    Coding Task

    Without looking at any notes, create a Kotlin console program that:

    Declares variables for:
        Employee Name
        Employee ID
        Age
        Department
        Salary
        Permanent Employee
        Assigns sample values.

    Prints them in a clean format like:

        ==============================
        Employee Information
        ==============================

        Employee Name : Rakesh Sharma
        Employee ID   : EMP101
        Age           : 40
        Department    : Sales
        Salary        : 45000.50
        Permanent     : true
*/

fun main() {
    // Declaring Variables
    // Since for this version / session none of the variables are been reassigned, hence val
    val employeeName = "Rakesh Sharma"
    val employeeID = "EMP101"
    val age = 40
    val department = "Sales"
    val salary = 45000.00
    val ispermanentEmployee = true

    // Display - Header
    println()
    println("=============================")
    println("Employee Information")
    println("=============================")
    println()

    // Display - Values
    println("Employee Name  : $employeeName")
    println("Employee ID    : $employeeID")
    println("Age            : $age")
    println("Department     : $department")
    println("Salary         : $salary")
    println("Permanent      : $ispermanentEmployee")
}