package com.shoppingcart.ShoppinCartBackend.business.cart

import com.shoppingcart.ShoppinCartBackend.model.Cart

interface ICartBusiness {

    fun list(): List<Cart>
    fun load(idCart: Long): Cart
    fun save(cart: Cart): Cart
    fun remove(idCart: Long)
}