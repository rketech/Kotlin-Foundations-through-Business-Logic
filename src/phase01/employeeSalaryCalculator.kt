package phase01

/*
    Business Problem
        You work for a company with 500 employees.
        Every month, HR needs to calculate salaries.

    The owner tells you:

        Rule 1
            If an employee works more than 40 hours,
            they receive overtime.

        Rule 2
            Overtime is paid at
            ₹500
            per extra hour

        Rule 3
            Final Salary
                Base Salary
                +
                Overtime

    Business Requirements
        The HR Executive enters:
            Employee Name
            Base Salary
            Hours Worked

        Software calculates:
            Overtime Hours
            Overtime Amount
            Final Salary

    Variable	    Data Type	val/var
    employeeName    String      val
    baseSalary      Double      val
    hoursWorked     Double      val
    overtimeHours   Double      val
    overtimeAmount  Double      val
    finalSalary     Double      val

    Decision Table :
        | Rule | Condition  | Overtime? |
        | ---- | ---------- | --------- |
        | 1    | Hours ≤ 40 | No        |
        | 2    | Hours > 40 | Yes       |

    calculation rules separately:
        If overtime applies
                ↓
        Overtime Hours = Hours Worked - 40
                ↓
        Overtime Amount = Overtime Hours × ₹500
                ↓
        Final Salary = Base Salary + Overtime Amount

*/
const val OVERTIME_RATE = 500.0

fun calculateOvertimeHours(hoursWorked: Double, normalWorkingHours: Double): Double {
    if (hoursWorked > normalWorkingHours) {
        return hoursWorked - normalWorkingHours
    }
    return 0.0
}

fun calculateOvertimeAmount(overtimeHours: Double): Double {
    return overtimeHours * OVERTIME_RATE
}

fun calculateFinalSalary(baseSalary: Double, overtimeAmount: Double): Double {
    return baseSalary + overtimeAmount
}

fun generateSalarySlip(
    employeeName: String,
    baseSalary: Double,
    expectedWorkingHours: Double,
    hoursWorked: Double,
    overtimeHours: Double,
    overtimeAmount: Double,
    finalSalary: Double
) {


    // Generating Salary Slip
    println()
    println("=================================")
    println("Salary Slip")
    println("=================================")
    println()
    println("Employee Name          : $employeeName")
    println("Base Salary            : $baseSalary")
    println("Expected Working Hours : $expectedWorkingHours")
    println("Hours Worked           : $hoursWorked")
    println()
    println("---------------------------------")
    println("Overtime Hours         : $overtimeHours")
    println("Overtime Pay           : $overtimeAmount")
    println("---------------------------------")
    println()
    println("Final Salary           : $finalSalary")
    println("=================================")
}

fun main() {

    // Header
    println()
    println("--------------------------------")
    println(" Employee Salary Slip Generator")
    println("--------------------------------")
    println()

    // Business Rules - User Input
    print("Employee Name :  ")
    // Variables Declared
    val employeeName: String = readln()

    print("Base Salary  :   ")
    val baseSalary: Double = readln().toDouble()

    print("Total Normal Working Hours :   ")
    val expectedWorkingHours: Double = readln().toDouble()

    print("Hours worked :   ")
    val hoursWorked: Double = readln().toDouble()


    // Business Rule - Calculate Overtime Hours
    val overtimeHours = calculateOvertimeHours(hoursWorked, expectedWorkingHours)

    // Business Rule - Calculate Overtime Amount
    val overtimeAmount: Double = calculateOvertimeAmount(overtimeHours)

    // Business Rule - Calculate Final Salary
    val finalSalary = calculateFinalSalary(baseSalary, overtimeAmount)

    // Generate Salary Slip
    generateSalarySlip(
        employeeName,
        baseSalary,
        expectedWorkingHours,
        hoursWorked,
        overtimeHours,
        overtimeAmount,
        finalSalary
    )
}

