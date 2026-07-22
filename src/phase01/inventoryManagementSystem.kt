package phase01

/*
    Business Problem
        A shop owner wants to know whether a product needs restocking.

    The employee enters:
        Product Name
        Current Stock
        Minimum Required Stock

    The software tells:
        Out of Stock
            or
        Low Stock
            or
        In Stock

    Business Rules
    Let's define them clearly.

    Rule   Condition       	        Status
    1	   Stock = 0	            Out of Stock
    2	   Stock ≤ Minimum Stock	Low Stock
    3	   Stock > Minimum Stock	In Stock

    Step 1 - Data Identification
        Variable	    Data Type	val/var (Does the variable get reassigned after it's created?)
        productName	    String      val
        currentStock    Int         val
        minimumStock    Int         val
        stockStatus     String      val

    Step 2 - Algorithm
        Algorithm in your own words.
            START
            Read Product Name
            Read Current Stock
            Read Minimum Stock
            Determine Stock Status
            Display Inventory Report
            END

    Step 3 - Function Design
            Without writing Kotlin, answer this:
            Question 1
            What should be the function name?
            Example:
            main()
            getStockStatus() // Category 1 - Business Logic
            displayInventoryRepost() // Category 2 - Presentation

            Question 2
            What parameters should it receive?
            getStockStatus(currentStock: Int, minimumStock: Int)
            displayInventoryReport(stockStatus: String)

            Question 3
            What should it return?
            getStockStatus(currentStock: Int, minimumStock: Int): String
            displayInventoryReport(productName, currentStock, minimumStock, stockStatus)
*/

fun getStockStatus(currentStock: Int, minimumStock: Int): String {
    return if (currentStock == 0) {
        "Out Of Stock"
    } else if (currentStock <= minimumStock) {
        "Low Stock"
    } else {
        "In Stock"
    }
}

fun displayInventoryReport(productName: String, currentStock: Int, minimumStock: Int, stockStatus: String) {
    println()
    println("------------------")
    println("  Stock Report")
    println("------------------")
    println()

    println("Product        : $productName")
    println("Current Stock  : $currentStock")
    println("Minimum Stock  : $minimumStock")
    println("Stock Status   : $stockStatus")
}

fun main() {
    println()
    println("--------------------------------------------------")
    println("   RK Inventory Management System (Version 1)")
    println("--------------------------------------------------")
    println()

    // Input
    print("Product Name             :   ")
    val productName = readln()

    print("Current Stock Quantity   :   ")
    val currentStock = readln().toInt()

    print("Minimum Stock Quantity   :   ")
    val minimumStock = readln().toInt()

    // Business Logic (Process)
    val stockStatus = getStockStatus(currentStock, minimumStock)

    // Presentation (Output)
    displayInventoryReport(productName, currentStock, minimumStock, stockStatus)
}

/*
    Although the business problems are different, every project follows the same template.

        Business Problem
            ↓
        Identify Data
            ↓
        Business Rules
            ↓
        Functions
            ↓
        Input
            ↓
        Business Logic
            ↓
        Presentation
*/