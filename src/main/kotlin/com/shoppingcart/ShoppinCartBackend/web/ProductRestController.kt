package com.shoppingcart.ShoppinCartBackend.web

import com.shoppingcart.ShoppinCartBackend.business.IProductBusiness
import com.shoppingcart.ShoppinCartBackend.exception.BusinessException
import com.shoppingcart.ShoppinCartBackend.exception.NotFoundException
import com.shoppingcart.ShoppinCartBackend.model.Product
import com.shoppingcart.ShoppinCartBackend.utils.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(Constants.URL_BASE_PRODUCTS)
class ProductRestController {

    @Autowired
    val productBusiness: IProductBusiness? = null

    @GetMapping("")
    fun list(): ResponseEntity<List<Product>> {
        return try {
            ResponseEntity(productBusiness!!.list(), HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/{id}")
    fun load(@PathVariable("id") idProduct: Long): ResponseEntity<Product> {
        return try {
            ResponseEntity(productBusiness!!.load(idProduct), HttpStatus.OK)
        } catch (e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        } catch (e: NotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping("")
    fun insert(@RequestBody product: Product): ResponseEntity<Any> {
        return try {
            productBusiness!!.save(product)
            val responeHeaders = HttpHeaders()
            responeHeaders.set("location", Constants.URL_BASE_PRODUCTS + "/" + product.id)
            ResponseEntity(responeHeaders, HttpStatus.CREATED)
        } catch (e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PutMapping("")
    fun update(@RequestBody product: Product): ResponseEntity<Any> {
        return try {
            productBusiness!!.save(product)
            ResponseEntity(HttpStatus.OK)
        } catch (e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable("id") idProduct: Long): ResponseEntity<Any> {
        return try {
            productBusiness!!.remove(idProduct)
            ResponseEntity(HttpStatus.OK)
        } catch (e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        } catch (e: NotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

}