package phase01

/*
RK Order & Payment Management System (OPMS)

1. Create Order
2. Add Product
3. View Order
4. Calculate Total
5. Make Payment
6. View Order Status
7. Exit
*/

/*
Entity	        Property	Data Type	    val/var
Customer_OPMS	name	    String	        val
Customer_OPMS	phone	    String	        val
Product_OPMS	name	    String	        val
Product_OPMS	price	    Double	        val
Product_OPMS	quantity	Int	            val
Order_OPMS	    orderId	    String	        val
Order_OPMS	    customer	Customer	    val
Order_OPMS	    products	List<Product>	val
Payment_OPMS	amount	    Double	        val
Payment_OPMS	method	    String	        val

Conceptually:

Customer_OPMS
      │
      ▼
Order_OPMS
     │
     ├──────────────► Customer_OPMS
     │                   ├── name
     │                   └── phone
     │
     └──────────────► List<Product_OPMS>
                         │
                         ├── Product_OPMS
                         ├── Product_OPMS
                         └── Product_OPMS

Payment_OPMS
      │
      └── PaymentMethod
             ├── CASH
             ├── CARD
             └── UPI

This is a big step toward how real applications model data.
*/


data class Customer_OPMS(
    val name: String,
    val phone: String,
)

data class Product_OPMS(
    val name: String,
    val price: Double,
    val quantity: Int,
)

data class Order_OPMS(
    val order_ID: String,
    val customer: Customer_OPMS,
    val products: List<Product_OPMS>
)

enum class PaymentMethod {
    CASH,
    CARD,
    UPI
}

data class Payment_OPMS(
    val amount: Double,
    val method: PaymentMethod
)

sealed class PaymentResult{
    data class Success(val amount: Double) : PaymentResult()
    data class Failure(val error: String): PaymentResult()
    data object Pending: PaymentResult()
}


fun processPayment(payment: Payment_OPMS): PaymentResult{}

fun main(){}