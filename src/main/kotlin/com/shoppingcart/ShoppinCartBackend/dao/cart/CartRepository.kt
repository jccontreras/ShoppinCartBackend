package com.shoppingcart.ShoppinCartBackend.dao.cart

import com.shoppingcart.ShoppinCartBackend.model.Cart
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/*
* Created by Ragnarok
* Cart Repository
* */
@Repository
interface CartRepository: JpaRepository<Cart, Long> {
}