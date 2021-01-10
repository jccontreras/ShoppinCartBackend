package com.shoppingcart.ShoppinCartBackend

import com.shoppingcart.ShoppinCartBackend.dao.ProductRepository
import com.shoppingcart.ShoppinCartBackend.model.Product
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ShoppinCartBackendApplication: CommandLineRunner {

	@Autowired
	val productRepository: ProductRepository? = null
	override fun run(vararg args: String?) {
		val product1 = Product("laptop", 123, "Asus Core i7")

		productRepository!!.save(product1)
	}

}

fun main(args: Array<String>) {
	runApplication<ShoppinCartBackendApplication>(*args)
}
