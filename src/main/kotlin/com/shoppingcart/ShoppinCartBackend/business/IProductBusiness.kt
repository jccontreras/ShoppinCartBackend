package com.shoppingcart.ShoppinCartBackend.business

import com.shoppingcart.ShoppinCartBackend.model.Product

interface IProductBusiness {

    fun list(): List<Product>
    fun load(idProduct: Long): Product
    fun save(product: Product): Product
}