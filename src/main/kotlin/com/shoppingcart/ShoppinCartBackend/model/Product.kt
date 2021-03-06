package com.shoppingcart.ShoppinCartBackend.model

import org.springframework.context.annotation.Primary
import javax.persistence.*

/*
* Created by Ragnarok
* Product Table Model
* */
@Entity
@Table(name = "products")
data class Product(
    val name: String = "",
    val sku: Long = 0, val description: String = ""
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
}