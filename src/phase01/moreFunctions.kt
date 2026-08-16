package phase01

fun printProduct(product: Product_OPMS) {
    println("Own Function")
    println(product.name)
}

fun processProduct(
    product: Product_OPMS,
    action: (Product_OPMS) -> Unit
) {
    action(product)
}

fun main() {

    val products = listOf(
        Product_OPMS("Keyboard", 500.0, 3),
        Product_OPMS("Mouse", 250.0, 5),
        Product_OPMS("Monitor", 7000.0, 3)
    )

    val expensiveProducts = products.filter { it.price > 499 }

    println(expensiveProducts)

//    val productNames = expensiveProducts.map{it.name}
    val productNames = products.map { it.name }
    println(productNames)

    val productTotalPricing = products.map { product -> product.price * product.quantity }
    println(productTotalPricing)

    products.forEach { product -> println(product.name) }

    val productFind = products.find { it.name == "Monitor" }

    if (productFind != null) {
        println("Found : ${productFind.name}")
    } else {
        println("No products found")
    }

    val hasExpensiveProduct = products.any { product -> product.price < 499 }
    println(hasExpensiveProduct)

    val allProductExpensive = products.all { product -> product.price > 249 }
    println(allProductExpensive)

    val total = products.sumOf { product -> product.price * product.quantity }
    println("Total : $total")

    printProduct(products[2])

    processProduct(products[1]) { product -> println("Own Function: ${product.name}") }

    val product1 = products.find { it.name == "Monitor" }

    product1?.let {
        println(it.name)
        println(it.price)
    }

    val product2 = Product_OPMS("Mouse", 250.0, 5)

    product1.also {
        println("Product created: ${it?.name}")
    }
}