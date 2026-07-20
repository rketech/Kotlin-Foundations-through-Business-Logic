package phase01

/*

Step 1 - Understand the Business Problem
    The owner says:
        "Different customers pay different ticket prices."

Step 2 - Who is the User?
    Booking Counter Executive
        Later this could become:
            Mobile App
            Website
            Self-Service Kiosk

Step 3 - Requirements Gathering
    The cinema owner gives you the following pricing policy.

    Customer Type	                    Ticket Price
    Child (Below 12 years)	            ₹150
    Adult (12–59 years)	                ₹250
    Senior Citizen (60 years and above)	₹180

Step 4 - Identify the Data
    Before coding, identify the business information.

    Information	        Data Type	    Why?
    Customer Name	    String	        Identifier
    Customer Age	    Int	            Used to determine category
    Ticket Price	    Int	            Whole rupees in Version 1
    Customer Category	String	        Business classification

Step 5 - Business Rules

    Now we convert the owner's policy into rules.

        IF age < 12
        ↓
        Child
        ↓
        ₹150

            IF age >= 12 AND age < 60
            ↓
            Adult
            ↓
            ₹250

        IF age >= 60
        ↓
        Senior Citizen
        ↓
        ₹180

Step 6 - Algorithm

        START
        Display Welcome
        Read Customer Name
        Read Customer Age
        Determine Category
        Determine Ticket Price
        Display Ticket
        END

IMP : Before writing the code, I want you to do one thing that professional developers often do.

    Create a small Decision Table like this: [This table will become your blueprint. Only after that should you implement the Kotlin program.]

    Rule No.	Condition	Category	        Ticket Price
    1	        Age < 12	Child	            ₹150
    2	        Age 12–59	Adult	            ₹250
    3	        Age ≥ 60	Senior Citizen	    ₹180

*/

fun displayTicketInformation(customerName: String, customerCategory: String, ticketPrice: Int) {
    println()
    println("-------------------------------------------------------")
    println("$customerName, Special Offer Ticket Price for you being $customerCategory : $ticketPrice")
    println("-------------------------------------------------------")
}

fun main() {
    // Header
    println()
    println("--------------------------")
    println(" Welcome to RK Movie Mart")
    println("--------------------------")
    println()

    // [???]
    val customerCategory: String
    val ticketPrice: Int

    // User Input
    print("Customer Name    :   ")
    val customerName = readln()

    print("Customer Age     :   ")
    val customerAge = readln().toInt()

    // Business Rule
    when (customerAge) {
        in 1..<12 -> {
            customerCategory = "Child"
            ticketPrice = 150
        }

        in 12..59 -> {
            customerCategory = "Adult"
            ticketPrice = 250
        }

        in 60..Int.MAX_VALUE  -> {
            customerCategory = "Senior Citizen"
            ticketPrice = 180
        }

        else -> {
            println("Invalid Age")
            return
        }
    }
    displayTicketInformation(customerName, customerCategory, ticketPrice)
}

