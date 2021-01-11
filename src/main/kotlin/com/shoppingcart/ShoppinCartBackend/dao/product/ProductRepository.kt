package com.shoppingcart.ShoppinCartBackend.dao.product

import com.shoppingcart.ShoppinCartBackend.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/*
* Created by Ragnarok
* Product Repository
* */
@Repository
interface ProductRepository: JpaRepository<Product, Long> {
}