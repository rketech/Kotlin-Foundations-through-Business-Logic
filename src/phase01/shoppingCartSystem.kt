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

data class Product(
    val name: String,
    val price: Double,
    private var quantity: Int
) {
    fun getQuantity(): Int {
        return quantity
    }

    // Member Function
    fun updateQuantity(newQuantity: Int) {
        if (newQuantity > 0) {
            quantity = newQuantity
        }
    }

    // Member Function
    fun calculateTotal(): Double {
        return quantity * price
    }
}

fun addProduct(
    products: MutableList<Product>,
) {
    println()
    print("Enter Product Name       : ")
    val productName = readln()

    print("Enter Product Price      : ")
    val productPrice = readln().toDouble()

    print("Enter Product Quantity   : ")
    val productQuantity = readln().toInt()

    if (productQuantity<=0){
        println("Quantity must be greater than zero.")
        return
    }

    val product = Product(
        name = productName,
        price = productPrice,
        quantity = productQuantity
    )
    products.add(product)
}

fun viewCart(
    products: List<Product>
) {
    for (product in products) {
        println("Product Name       : ${product.name}")
        println("Product Price      : ${product.price}")
        println("Product Quantity   : ${product.getQuantity()}")
        println()
    }
}

fun calculateBill(
    products: List<Product>
): Double {
    var total = 0.0
    for (product in products) {
        total += product.calculateTotal()
    }
    return total
}

fun displayBill(totalBill: Double) {
    println()
    println("-------------------------")
    println("Total Bill             :   ₹$totalBill")
    println("-------------------------")
}

fun displayTotalItems(products: List<Product>) {
    println()
    println("-------------------------")
    println("Total Items             :  ${products.size}")
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
    val products = mutableListOf<Product>()

    do {
        menuDisplay()
        println()
        print("Enter Your Choice        : ")
        val menuChoice = readln().trim()

        when (menuChoice) {
            "1" -> {
                addProduct(products)
            }

            "2" -> {
                if (products.isEmpty()) {
                    println("Cart Is Empty")
                    continue
                } else {
                    viewCart(products)
                }
            }

            "3" -> {
                val totalBill = calculateBill(products)
                displayBill(totalBill)
            }

            "4" -> {
                displayTotalItems(products)
            }
        }
    } while (menuChoice != "5")

}

fun main() {
    println()
    println("----------- RK Shopping Cart -----------")
    operateMenu()
}