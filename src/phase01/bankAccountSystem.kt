package phase01

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

fun deposit(currentBalance: Double): Double {
    val depositAmount = readValidateAmount()
    return currentBalance + depositAmount
}

fun withdraw(currentBalance: Double): Double {
    val withdrawAmount = readValidateAmount()
    return currentBalance - withdrawAmount
}

fun checkBalance(currentBalance: Double): Double {
    return currentBalance
}

fun exit() {
    println("Exit Process Initiated....")
    println("Thank you for choosing RK Bank!")
    return
}

fun main() {
    val accountHolderName: String
    var currentBalance: Double
    val menuChoice: String
    var amount: Double

    println("-------------")
    println("---RK Bank---")
    println("-------------")

    currentBalance = 10000.0

    displayMenu()
    println()
    print("Enter Your Choice  :   ")
    menuChoice = readln().trim()

    when (menuChoice) {
        "1" -> {
            currentBalance = deposit(currentBalance)
            println("Updated Balance After Deposit    :   $currentBalance")
        }

        "2" -> {
            currentBalance= withdraw(currentBalance)
            println("Updated Balance After Withdrawal    :   $currentBalance")

        }

        "3" -> {
            currentBalance=checkBalance(currentBalance)
            println("Current Balance    :   $currentBalance")
        }

        "4" -> {
            exit()
        }

    }
}
