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
fun readValidateAmount(): Double {
    print("Enter Amount   :   ")
    val amount = readln().toDouble()
    return amount
}

fun deposit(currentBalance: Double, amount: Double): Double {
    return currentBalance + amount
}

fun withdraw(currentBalance: Double, amount: Double): Double {
    return currentBalance - amount
}

fun checkBalance(currentBalance: Double) {
    println("Current Balance    : $currentBalance")
}

fun exit() {
    println("Exit Process Initiated....")
    println("Thank you for choosing RK Bank!")
    return
}

fun operateOnMenu(menuChoice: String){

    //val accountHolderName: String
    var currentBalance: Double
    var amount: Double
    currentBalance = 0.0

    when (menuChoice) {
        "1" -> {
            amount = readValidateAmount()
            currentBalance = deposit(currentBalance, amount)
            println("Updated Balance After Deposit    :   $currentBalance")
        }

        "2" -> {
            amount = readValidateAmount()
            currentBalance = withdraw(currentBalance, amount)
            println("Updated Balance After Withdrawal    :   $currentBalance")

        }

        "3" -> {
            checkBalance(currentBalance)
        }

        "4" -> {
            exit()
        }

    }
}

fun main() {
    // var amount: Double

    println("-------------")
    println("---RK Bank---")
    println("-------------")

    displayMenu()
    println()
    print("Enter Your Choice  :   ")
    val menuChoice: String = readln().trim()

    operateOnMenu(menuChoice)
}
