package phase01

import jdk.jfr.DataAmount

/*
    Project Information
    ------------------
        Project         : RK Bank Account System
        Version         : 1.0
        Phase           : Kotlin Foundations through Business Logic
        
    🎯 Topics Covered
        Exception Handling (try-catch)
        Input Validation
        Defensive Programming

    Revision:
        Functions
        if/else
        MutableList (optional later)
        Loops
        Business Problem

    A bank wants a simple application for a cashier.

    The cashier can:
        Deposit Money
        Withdraw Money
        Check Balance
        Exit

    Business Rules:
    --------------
        Deposit
            Amount must be greater than 0.

        Withdraw
            Amount must be greater than 0.
            Amount cannot exceed current balance.

        Check Balance
            Display current balance.

        Exit
            Close the application.

    Decision Table
    --------------
        Rule	    Condition	        Result
        1	        Deposit ≤ 0	        Invalid Deposit
        2	        Withdraw ≤ 0	    Invalid Withdrawal
        3	        Withdraw > Balance	Insufficient Balance
        4	        Otherwise	        Transaction Successful

    Step 1 — Data Identification
        Variable	        Data Type	    val/var
        accountHolderName   String          val
        currentBalance      Double          var
        menuChoice          String          val
        amount              Double          var

    Step 2 — Function Design

    Business Logic
    --------------
    depositMoney()
        Returns:
            Double

    withdrawMoney()
        Returns:
            Double

    Presentation
    ------------
        displayMenu()
        displayAccountDetails()

    Step 3 — Program Flow
        Start
            ↓
        Read Account Holder Name
            ↓
        Current Balance = 0
            ↓
        Show Menu
            1 Deposit
            2 Withdraw
            3 Balance
            4 Exit
            ↓
        User Chooses (Read Choice)
            ↓
        Process (Process Choice)

        Show Menu Again
            ↓
        Exit
*/

// Presentation
fun displayMenu() {
    println()
    println("---Menu Choice---")
    println("1. Deposit")
    println("2. Withdraw")
    println("3. Check Balance")
    println("4. Exit")
    println()
}

// Reads and validates input.
/*
    Responsible for:
        ✓ Read input
        ✓ Number validation
        ✓ Positive amount validation

        Architecture
            Technical Problem
                ↓
            try-catch

        Business Problem
                ↓
            if / when
*/

// Read + Technical validation + Business validation
fun readAndValidateAmount(): Double {
    while (true) {
        try {
            print("Enter Amount   :   ")
            val amount = readln().toDouble()
            if (amount <= 0.0) {
                println("Amount must be greater than zero.")
                continue
            }
            return amount
        } catch (e: NumberFormatException) {
            println(e)
            println("Please enter number only.")
        }
    }
}

// Deposit business logic
fun deposit(currentBalance: Double, amount: Double): Double {
    return currentBalance + amount
}

/*
    Responsible for:
        ✓ Insufficient balance
        ✓ Daily withdrawal limit (future)
        ✓ Minimum balance rule (future)
        ✓ Withdrawal fee (future)
*/
// Withdrawal business logic
fun withdraw(currentBalance: Double): Double {
    while (true) {
        val amount = readAndValidateAmount()
        if (amount > currentBalance) {
            println("Insufficient balance")
            continue
        }
            return currentBalance - amount
    }
}

// Presentation
fun checkBalance(initialBalance: Double) {
    println("Current Balance    : $initialBalance")
}

fun exit() {
    println("Exit Process Initiated....")
    println("Thank you for choosing RK Bank!")
}

// Application flow
fun operateOnMenu(initialBalance: Double) {

    var currentBalance = initialBalance
    var amount: Double

    do {

        displayMenu()
        println()
        print("Enter Your Choice  :   ")
        val menuChoice: String = readln().trim()

        when (menuChoice) {
            "1" -> {
                amount = readAndValidateAmount()
                currentBalance = deposit(currentBalance, amount)
                println("Updated Balance After Deposit    :   $currentBalance")
            }

            "2" -> {
                currentBalance = withdraw(currentBalance)
                println("Updated Balance After Withdrawal    :   $currentBalance")

            }

            "3" -> {
                checkBalance(currentBalance)
            }

            "4" -> {
                exit()
            }

            else -> {
                println("Invalid Choice")
            }
        }
    } while (menuChoice != "4")

}

// Application entry point
fun main() {
    // var amount: Double

    println("-------------")
    println("---RK Bank---")
    println("-------------")

    // Because main() represents the lifetime of the application.
    // The bank account exists while the application is running.
    // So this variable should live here:
    val currentBalance = 0.0

    operateOnMenu(currentBalance)
}
