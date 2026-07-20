package phase01

/*

            Project : RK Mart Billing System

            Business Objective:
            Generate the bill for one product by calculating GST,
            discount and final payable amount.

            Version : 1.0

            Current Assumptions:
            - One product only
            - Quantity by count
            - GST fixed at 5%
            - Discount fixed at 10%

            -------------------------------------------

    Step 1 :    Identify Variables:
            Variable	        Data Type	    val/var	        Reason
            productName	        String	        val	            Identifier entered once
            price	            Double	        val	            Used in calculations
            quantity	        Int	            val	            Quantity by count in V1
            gstPercentage	    Double	        val	            Business configuration
            discountPercentage	Double	        val	            Business configuration
            subtotal	        Double	        val	            Calculated value
            gstAmount	        Double	        val	            Calculated value
            discountAmount	    Double	        val	            Calculated value
            finalAmount	        Double	        val	            Calculated value

            ---------------------------------------------

    Step 2 :    Draw the Flow

        Every software has a flow.
        Algorithm :

        Program Starts
               │
               ▼
        Display Welcome Message
               │
               ▼
        Ask Product Name
               │
               ▼
        Ask Price
               │
               ▼
        Ask Quantity
               │
               ▼
        Calculate Subtotal
               │
               ▼
        Calculate GST
               │
               ▼
        Calculate Discount
               │
               ▼
        Calculate Final Amount
               │
               ▼
        Display Bill
               │
               ▼
        Program Ends

            ---------------------------------------------

        Step 3  :   Let's Think About Responsibilities
            Responsibility 1 ( INPUT )      :   Collect Data ( readln() ) [TextField (Android), API, Barcode Scanner, QR Code, Voice Input]
            Responsibility 2 ( PROCESS )    :   Process Data ( Business Calculations )
            Responsibility 3 ( OUTPUT )     :   Display Data ( println() )

            ---------------------------------------------

        Step 4  :   Pseudocode
            Before Kotlin, professional developers often write pseudocode.
                START

                Display Heading

                Read Product Name

                Read Price

                Read Quantity

                GST = 5

                Discount = 10

                Subtotal = Price × Quantity

                GST Amount = ...

                Discount Amount = ...

                Final Amount = ...

                Display Bill

                END

            ---------------------------------------------

            Processing Rules :
                Subtotal = Price × Quantity
                GST Amount = Subtotal × GST /100
                Discount Amount = Subtotal × Discount /100
                Final Amount = Subtotal + GST Amount - Discount Amount

            ---------------------------------------------

            Display

                    RK MART
                    Product Name
                    Price
                    Quantity
                    Subtotal
                    GST
                    Discount
                    Final Amount

            ---------------------------------------------

            Project : RK Mart Billing System

            Business Objective:
            Generate the bill for one product by calculating GST,
            discount and final payable amount.

            Version : 1.0

            Current Assumptions:
            - One product only
            - Quantity by count
            - GST fixed at 5%
            - Discount fixed at 10%
*/

fun main() {
    // Header
    println()
    println("=============================")
    println("RK Mart Billing System")
    println("=============================")
    println()

    // User Input
    print("Enter The Item Name              :   ")
    val productName = readln()

    print("Enter The Item Selling Price     :   ")
    val price = readln().toInt()

    print("Enter The Quantity Sold          :   ")
    val quantity = readln().toInt()

    // Configuration
    val gstPercentage = 5.0
    val discountPercentage = 10.0

    // Calculating Values
    val subTotal = price * quantity
    val gstAmount = subTotal * (gstPercentage / 100)
    val discountAmount = subTotal * (discountPercentage / 100)
    val finalAmount = subTotal + gstAmount - discountAmount

    // Displaying the calculated bill
    println()
    println("====================================")
    println("      RK MART (Final Bill)")
    println("====================================")
    println()
    println("Item           :   $productName")
    println("Price          :   $price")
    println("Quantity       :   $quantity")
    println("Subtotal       :   $subTotal")
    println()
    println("-------------------------------------")
    println("GST (+)        :   $gstAmount")
    println("Discount (-)   :   $discountAmount")
    println("-------------------------------------")
    println("TOTAL          :   $finalAmount")
    println("-------------------------------------")

}