package phase01

/*
Next Project (Day 11)

    We'll start introducing collections with richer business operations.

    🛒 RK Shopping Cart System

    You'll build a mini shopping cart where the user can:

        1. Add Product
        2. View Cart
        3. Remove Product
        4. Calculate Bill
        5. Exit

    Through this single project, you'll naturally learn and practice:

        MutableList
        for loops
        searching
        removing items
        aggregation (totals)
        function decomposition
        cleaner menu-driven architecture

    It's also much closer to a real e-commerce app, so every concept will directly transfer to Android screens later.
*/

fun addProduct(
    productName: MutableList<String>,
    productPrice: MutableList<Double>,
    productQuantity: MutableList<Int>,
) {
    println()
    print("Enter Product Name       : ")
    productName.add(readln())

    print("Enter Product Price      : ")
    productPrice.add(readln().toDouble())

    print("Enter Product Quantity   : ")
    productQuantity.add(readln().toInt())
}

fun viewCart(
    productName: MutableList<String>,
    productPrice: MutableList<Double>,
    productQuantity: MutableList<Int>,
) {
    for (index in productName.indices) {
        println("Product Name       : ${productName[index]}")
        println("Product Price      : ${productPrice[index]}")
        println("Product Quantity   : ${productQuantity[index]}")
        println()
    }
}

fun calculateBill(
    productPrice: MutableList<Double>,
    productQuantity: MutableList<Int>
): Double {
    var total = 0.0
    for (index in productPrice.indices) {
        total += productPrice[index] * productQuantity[index]
    }
    return total
}

fun displayBill(totalBill: Double) {
    println()
    println("-------------------------")
    println("Total Bill             :   ₹$totalBill")
    println("-------------------------")
}

fun displayTotalItems(productName: List<String>) {
    println()
    println("-------------------------")
    println("Total Items             :  ${productName.size}")
    println("-------------------------")
}

fun menuDisplay() {
    println()
    println("----------- Menu -----------")
    println("1. Add Product")
    println("2. View Cart")
    println("3. Calculate Bill")
    println("4. Total Products")
    println("5. Exit")
    println("----------------------------------------")
    println()
}

fun operateMenu() {
    val productNames = mutableListOf<String>()
    val productPrices = mutableListOf<Double>()
    val productQuantities = mutableListOf<Int>()

    do {
        menuDisplay()
        println()
        print("Enter Your Choice        : ")
        val menuChoice = readln().trim()

        when (menuChoice) {
            "1" -> {
                addProduct(productNames, productPrices, productQuantities)
            }

            "2" -> {
                if (productNames.isEmpty()) {
                    println("Cart Is Empty")
                    continue
                } else {
                    viewCart(productNames, productPrices, productQuantities)
                }
            }

            "3" -> {
                val totalBill = calculateBill(productPrices, productQuantities)
                displayBill(totalBill)
            }

            "4" -> {
                displayTotalItems(productNames)
            }
        }
    } while (menuChoice != "5")

}

fun main() {
    println()
    println("----------- RK Shopping Cart -----------")
    operateMenu()
}