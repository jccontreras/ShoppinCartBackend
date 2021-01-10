package com.shoppingcart.ShoppinCartBackend.model

import javax.persistence.*
/*
* Created by Ragnarok
* Product Table Model
* */
@Entity
@Table(name = "product")
data class Product(val name:String = "",
                   val sku:Long = 0, val description:String = "") {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id:Long = 0
}