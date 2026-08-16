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


                    Payment_OPMS
                         │
                         ▼
                 processPayment()
                  Business Logic
                         │
                         ▼
                  PaymentResult
              ┌──────────┼──────────┐
              ▼          ▼          ▼
          Success      Failed     Pending
              │          │          │
              └──────────┼──────────┘
                         ▼
             displayPaymentResult()
                    Presentation
                         │
                         ▼
                  User sees result
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

sealed class PaymentResult {
    data class Success(val amount: Double) : PaymentResult()
    data class Failure(val error: String) : PaymentResult()
    data object Pending : PaymentResult()
}

// Business Logic
fun processPayment(payment: Payment_OPMS): PaymentResult {
    if (payment.amount <= 0) {
        return PaymentResult.Failure("Payment amount must be greater than zero.")
    }
    return when (payment.method) {
        PaymentMethod.CASH -> {
            PaymentResult.Success(payment.amount)
        }

        PaymentMethod.CARD -> {
            PaymentResult.Pending
        }

        PaymentMethod.UPI -> {
            PaymentResult.Pending
        }
    }
}

// Presentation
fun displayPaymentResult(result: PaymentResult) {
    when (result) {
        is PaymentResult.Success -> {
            println("Payment Successful")
            println("Amount : ${result.amount}")
        }

        is PaymentResult.Failure -> {
            println("Payment Failed")
            println("Error: ${result.error}")
        }

        is PaymentResult.Pending -> {
            println("Payment Pending")
            println("Please wait for the confirmation")
        }
    }
}

fun main() {
    val invalidPayment = Payment_OPMS(0.0, PaymentMethod.CASH)
    val cashPayment = Payment_OPMS(500.0, PaymentMethod.CARD)
    val upiPayment = Payment_OPMS(300.0, PaymentMethod.UPI)

    val result1 = processPayment(invalidPayment)
    val result2 = processPayment(cashPayment)
    val result3 = processPayment(upiPayment)

    displayPaymentResult(result1)
    displayPaymentResult(result2)
    displayPaymentResult(result3)
}