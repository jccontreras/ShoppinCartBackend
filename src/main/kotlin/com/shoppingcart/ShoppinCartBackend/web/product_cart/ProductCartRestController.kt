package com.shoppingcart.ShoppinCartBackend.web.product_cart

import com.shoppingcart.ShoppinCartBackend.business.product_cart.IProductCartBusiness
import com.shoppingcart.ShoppinCartBackend.exception.BusinessException
import com.shoppingcart.ShoppinCartBackend.exception.NotFoundException
import com.shoppingcart.ShoppinCartBackend.model.Product_Cart
import com.shoppingcart.ShoppinCartBackend.utils.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/*
* Created by Ragnarok
* ProductCart Rest Controller
* */
@RestController
@RequestMapping(Constants.URL_BASE_PRODUCTCARTS)
class ProductCartRestController {

    @Autowired
    val productCartBusiness: IProductCartBusiness? = null

    //Call to DB for load all Product Cart list
    @GetMapping("")
    fun list(): ResponseEntity<List<Product_Cart>> {
        return try {
            ResponseEntity(productCartBusiness!!.list(), HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    //Call to DB for load a Product Cart
    @GetMapping("/{idP}/{idC}")
    fun load(@PathVariable("idP") idProduct: Long, @PathVariable("idC") idCart: Long): ResponseEntity<List<Product_Cart>> {
        return try {
            ResponseEntity(productCartBusiness!!.load(idProduct, idCart), HttpStatus.OK)
        } catch (e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        } catch (e: NotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    //Call to DB for save a Product cart
    @PostMapping("")
    fun insert(@RequestBody productCart: Product_Cart): ResponseEntity<Any> {
        return try {
            productCartBusiness!!.save(productCart)
            val responeHeaders = HttpHeaders()
            responeHeaders.set("location", Constants.URL_BASE_PRODUCTS + "/" + productCart.product_id + "/" + productCart.cart_id)
            ResponseEntity(responeHeaders, HttpStatus.CREATED)
        } catch (e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    //Call to DB for update a Product Cart
    @PutMapping("")
    fun update(@RequestBody productCart: Product_Cart): ResponseEntity<Any> {
        return try {
            productCartBusiness!!.save(productCart)
            ResponseEntity(HttpStatus.OK)
        } catch (e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    //Call to DB for delete a Product Cart
    @DeleteMapping("/{idP}/{idC}")
    fun delete(@PathVariable("idP") idProduct: Long, @PathVariable("idC") idCart: Long): ResponseEntity<Any> {
        return try {
            productCartBusiness!!.remove(idProduct, idCart)
            ResponseEntity(HttpStatus.OK)
        } catch (e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        } catch (e: NotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}