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
fun getPresentStudents(attendanceStatuses: List<String>): Int {
    var countPresent = 0
    for (result in attendanceStatuses) {
        if (result == "P" || result == "p") {
            countPresent++
        }
    }
    return countPresent
}

fun getAbsentStudents(attendanceStatuses: List<String>): Int {
    var countAbsent = 0
    for (result in attendanceStatuses) {
        if (result == "A" || result == "a") {
            countAbsent++
        }
    }
    return countAbsent
}

fun getLeaveStudents(attendanceStatuses: List<String>): Int {
    var countLeave = 0
    for (result in attendanceStatuses) {
        if (result == "L" || result == "l") {
            countLeave++
        }
    }
    return countLeave
}

fun main() {
    println()
    println("-------------------------------")
    println("RK Attendance Management System")
    println("-------------------------------")
    println()

    val studentNames = mutableListOf<String>()
    val attendanceStatuses = mutableListOf<String>()

    // Input
    do {
        println()
        print("Enter Student Name       :   ")
        val studentNameLocal = readln()

        if (studentNameLocal.isBlank()) {
            continue
        } else if (!studentNameLocal.equals("EXIT", ignoreCase = true)) {

            print("Attendance Status[P/A/L] :   ")
            val attendanceStatusLocal = readln()
            if (attendanceStatusLocal.isNotBlank()) {
                studentNames.add(studentNameLocal)
                attendanceStatuses.add(attendanceStatusLocal)
            } else {
                println("Attendance Cannot Be Blank...")
                continue
            }
        } else
            break

    } while (true)

    println()
    println("---Attendance Report---")
    println()
    for (report in studentNames.indices) {
        println("Student Name       : ${studentNames[report]}")
        println("Attendance Status  : ${attendanceStatuses[report].uppercase()}")
        println()
    }
    println("----------------")
    println()
    println("Total Students     :   ${studentNames.size}")

    val presentStudents = getPresentStudents(attendanceStatuses)
    println("Present Students   :   $presentStudents")

    val absentStudents = getAbsentStudents(attendanceStatuses)
    println("Absent Students    :   $absentStudents")

    val leaveStudents = getLeaveStudents(attendanceStatuses)
    println("Leave Students     :   $leaveStudents")
    println()
    println("----------------")

}