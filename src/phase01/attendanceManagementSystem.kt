package phase01

/*
    Project Information
    -------------------

        Project: RK Attendance Management System
        Version: 1.0
        Phase: Kotlin Foundations through Business Logic

    Business Problem
    -------------------

        A school teacher wants to record attendance for a class.

        For each student, the teacher enters:

            Student Name
            Attendance Status

        Attendance can be:

            P → Present
            A → Absent
            L → Leave

        After all students are entered, the software should display:

            Student Name
            Attendance Status

        Finally display:

            Total Students
            Present Students
            Absent Students
            Leave Students

    Business Rules
    -------------------
        Business Twist (Today's Learning)

        The principal now gives an additional rule.

        If the teacher types EXIT, stop taking attendance immediately.

            Example:

            Student Name : Rakesh
            Status : P

            Student Name : Amit
            Status : A

            Student Name : EXIT

                The program should immediately stop taking input.

                This introduces break naturally.

        Another Business Rule

            Suppose the teacher accidentally presses Enter without typing a name.

            Example:

            Student Name :

                The software should ignore that entry and ask again.

                This introduces continue naturally.

    Today's Design Question

    Before writing any code, answer these.

        Step 1 – Data Identification

            Variable	        Data Type	                    val/var
            studentNames        mutableListOf<String>           val
            attendanceStatuses  mutableListOf<String>
            presentStudents     Int
            absentStudents      Int
            leaveStudents       Int

        Step 2 – Decision Table

            Rule	Condition	Result
            1	Status = P	Present
            2	Status = A	Absent
            3	Status = L	Leave

        Then add the two new rules:

            EXIT
                Blank Name [ note: .isBlank() checks if the string is: Empty (""), Only spaces (" "), Tabs ("\t"), New lines ("\n")]
            If the teacher enters a blank name → continue.

        After all students are entered, the software should display:

         Student Name
         Attendance Status

        Finally display:

            Total Students
            Present Students
            Absent Students
            Leave Students


    Architecture
    --------------
*/

fun main() {
    println()
    println("-------------------------------")
    println("RK Attendance Management System")
    println("-------------------------------")
    println()

    val studentNames = mutableListOf<String>()
    val attendanceStatuses = mutableListOf<String>()
    val presentStudents: Int
    val absentStudents: Int
    val leaveStudents: Int

    // Input
    do {
        println()
        print("Enter Student Name       :   ")
        val studentName = readln()

        if (studentName.isBlank()) {
            continue
        } else if (!studentName.equals("EXIT", ignoreCase = true)) {
            studentNames.add(studentName)
            print("Attendance Status[P/A/L] :   ")
            attendanceStatuses.add(readln())
        } else
            break

    } while (true)

    println()
    println("---Attendance Report---")
    for (report in studentNames.indices) {
        println("Student Name       : ${studentNames[report]}")
        println("Attendance Status  : ${attendanceStatuses[report]}")
        println()
    }
}