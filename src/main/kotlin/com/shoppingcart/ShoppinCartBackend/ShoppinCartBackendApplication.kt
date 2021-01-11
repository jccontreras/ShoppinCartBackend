package com.shoppingcart.ShoppinCartBackend

import com.shoppingcart.ShoppinCartBackend.dao.cart.CartRepository
import com.shoppingcart.ShoppinCartBackend.dao.product.ProductRepository
import com.shoppingcart.ShoppinCartBackend.dao.product_cart.ProductCartRepository
import com.shoppingcart.ShoppinCartBackend.model.Cart
import com.shoppingcart.ShoppinCartBackend.model.Product
import com.shoppingcart.ShoppinCartBackend.model.Product_Cart
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ShoppinCartBackendApplication: CommandLineRunner {

	@Autowired
	val productRepository: ProductRepository? = null
	@Autowired
	val cartRepository: CartRepository? = null
	@Autowired
	val productCarRepository: ProductCartRepository? = null
	override fun run(vararg args: String?) {
		val product1 = Product("laptop", 123, "Asus Core i7")
		val cart1 = Cart("pending")
		val productcart1 = Product_Cart(1, 1, 0, "cart1")

		productRepository!!.save(product1)
		cartRepository!!.save(cart1)
		productCarRepository!!.save(productcart1)
	}

}

fun main(args: Array<String>) {
	runApplication<ShoppinCartBackendApplication>(*args)
}
