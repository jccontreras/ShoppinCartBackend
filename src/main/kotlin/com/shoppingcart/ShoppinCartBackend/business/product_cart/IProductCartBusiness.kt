package com.shoppingcart.ShoppinCartBackend.business.product_cart

import com.shoppingcart.ShoppinCartBackend.model.Product_Cart

interface IProductCartBusiness {

    fun list(): List<Product_Cart>
    fun load(idProduct: Long, idCart: Long): List<Product_Cart>
    fun save(product_cart: Product_Cart): Product_Cart
    fun remove(idProduct: Long, idCart: Long)
}