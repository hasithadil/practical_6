package practical_6

object q1 {
    // Defining a case class for products
    case class Product(name: String, quantity: Int, price: Double)

    // Example inventories
    var inventory1: Map[Int, Product] = Map(
      101 -> Product("toothBrush", 10, 50.0),
      102 -> Product("Soap", 5, 30.0),
      103 -> Product("pen", 8, 25.0)
    )

    var inventory2: Map[Int, Product] = Map(
      101 -> Product("toothBrush", 20, 50.0),
      102 -> Product("Soap", 2, 33.0),
      103 -> Product("pen", 12, 25.0)
    )

    def retrieveAllProductNames(inventory: Map[Int, Product]): List[String] = {
      inventory.values.map(_.name).toList
    }

    def calculateTotalValue(inventory: Map[Int, Product]): Unit = {
      val temp = inventory.values.map(product => product.quantity * product.price).sum
      println(s"total value of Inventory1 : ${temp}")
    }

    def isInventoryEmpty(inventory: Map[Int, Product]): Unit = {
      if (inventory.nonEmpty) {
        println("Not Empty")
      }
      else {
        println("Empty")
      }
    }

    def mergeInventories(inventory1: Map[Int, Product], inventory2: Map[Int, Product]): Map[Int, Product] = {
      inventory1.map { case (id, product1) =>
        val product2 = inventory2(id)
        val updatedQuantity = product1.quantity + product2.quantity
        val highestPrice = Math.max(product1.price, product2.price)
        id -> Product(product1.name, updatedQuantity, highestPrice)
      }
    }

    // V. Check if a product with a specific ID exists and print its details
    def printProductDetails(inventory: Map[Int, Product], productId: Int): Unit = {
      inventory.get(productId) match {
        case Some(product) =>
          println(s"Product ID: $productId, Name: ${product.name}, Quantity: ${product.quantity}, Price: ${product.price}")
        case None =>
          println(s"Product ID: $productId does not exist in the inventory.")
      }
    }

    def printInventory(invetory: Map[Int, Product]): Unit = {
      invetory.foreach { case (id, product: Product) =>
        println(s"Product ID: $id, Name: ${product.name}, Quantity: ${product.quantity}, Price: ${product.price}")
      }
    }

    def main(args: Array[String]): Unit = {

      val productNames = retrieveAllProductNames(inventory1)

      calculateTotalValue(inventory1)

      isInventoryEmpty(inventory1)

      val inventory3 = mergeInventories(inventory1, inventory2)
      printInventory(inventory3)
      println()

      printProductDetails(inventory1, 101)
    }
}
