package phase01

/*
        *Business Problem:
            A school teacher checks exam results.

        *The teacher enters:
            Student Name
            Marks

        *The software should determine:
            Marks >= 35
                    ↓
                   PASS

            Marks < 35
                    ↓
                   FAIL

        *After entering all students, the software displays:
            Student Name
            Marks
            Result

        *Finally, display:
            Total Students
            Passed Students
            Failed Students

        *Step 1 – Data Identification:
            Variable	    Data Type	                val/var
            studentNames    MutableList<String>         val
            studentMarks    MutableList<Double>         val
            studentResults  MutableList<String>         val
            totalStudents   Int                         val
            passedStudents  Int                         val
            failedStudents  Int                         val

        *Step 2 – Decision Table
            Rule	Condition	Result
            1	    Marks ≥ 35	Pass
            2	    Marks < 35	Fail
*/

/*
===============================================================================
    Project         : RK Student Management System
    Version         : 1.0
    Phase           : Phase 01 - Kotlin Foundations through Business Logic

    Topics Covered
    ---------------
    - Variables (val / var)
    - User Input
    - Functions
    - Parameters & Return Types
    - if / else
    - do-while Loop
    - for Loop
    - MutableList
    - Collections
    - Business Logic Separation

    Business Problem
    ----------------
    A school teacher needs software to record student marks and determine whether
    each student has passed or failed.

    Business Requirements
    ---------------------
    Input:
    - Student Name
    - Student Marks

    Output:
    - Student Name
    - Marks
    - Result (PASS / FAIL)

    Summary:
    - Total Students
    - Total Passed
    - Total Failed

    Business Rules
    --------------
    Rule 1:
    Marks >= 35
    Result = PASS

    Rule 2:
    Marks < 35
    Result = FAIL

    Data Identification
    -------------------
    studentNames      : MutableList<String>
    studentMarks      : MutableList<Int>
    studentResults    : MutableList<String>

    Architecture
    ------------
    Input
        ↓
    Business Logic
        ↓
    Store Data
        ↓
    Business Analytics
        ↓
    Presentation

    Functions
    ---------
    main()
        Controls the application flow.

    getResult()
        Determines whether a student has passed or failed.

    totalPassedStudents()
        Counts all passed students.

    totalFailedStudents()
        Counts all failed students.

    Design Decisions
    ----------------
    - MutableList is used because the number of students is not fixed.
    - Business logic is separated from presentation.
    - Analytics (pass/fail count) is implemented using dedicated functions.
    - do-while ensures at least one student is entered.

    Future Improvements
    -------------------
    Version 2
    - Validate marks (0-100)
    - Handle invalid input using Exception Handling

    Version 3
    - Create Student data class
    - Store MutableList<Student>

    Version 4
    - Generate formatted report
    - Save report to file/database

    Author
    ------
    Rakesh Sharma

    Last Updated
    ------------
    27 July 2026
===============================================================================
*/

// Business Logic
fun getresult(studentMarks: Double): String {
    return if (studentMarks >= 35)
        "PASS"
    else
        "FAIL"
}

// Business Logic
fun totalPassedStudents(studentResults: MutableList<String>): Int {
    var passedCount = 0
    for (result in studentResults) {
        if (result == "PASS")
            passedCount++
    }
    return passedCount
}

// Business Logic
fun totalFailedStudents(studentResults: List<String>): Int {
    var failedCount = 0
    for (result in studentResults) {
        if (result == "FAIL")
            failedCount++
    }
    return failedCount
}

fun main() {
    println()
    println("------------------------------")
    println(" RK Student Management System")
    println("------------------------------")
    println()

    val studentNames = mutableListOf<String>()
    val studentMarks = mutableListOf<Double>()
    val studentResults = mutableListOf<String>()

    println()

    // Input
    do {
        print("Enter Student Name :   ")
        studentNames.add(readln())

        print("Enter The Marks    :   ")
        studentMarks.add(readln().toDouble())

        studentResults.add(getresult(studentMarks.last())) // last() returns the most recently added mark.

        println()
        print("Want to enter more students? [Y/N] :  ")
        val moreEntry = readln()
        println()


    } while (moreEntry == "Y" || moreEntry == "y")
    println()

    println("---Student Report---")
    println()

    println("Total Students     : ${studentNames.size}")

    val passedStudents = totalPassedStudents(studentResults)
    println("Passed Students    : $passedStudents")

    val failedStudents = totalFailedStudents(studentResults)
    println("Failed Students    : $failedStudents")

    println()

    for (index in studentNames.indices) {
        println("${studentNames[index]} : ${studentMarks[index]}  :   ${studentResults[index]}")
    }
}