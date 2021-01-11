package com.shoppingcart.ShoppinCartBackend.model

import javax.persistence.*

/*
* Created by Ragnarok
* Product Table Model
* */

@Entity
@Table(name = "product_carts")
data class Product_Cart(
    val product_id: Long = 0,
    val cart_id: Long = 0,
    val quantity: Long = 0,
    @Id val id: String = ""
){
}