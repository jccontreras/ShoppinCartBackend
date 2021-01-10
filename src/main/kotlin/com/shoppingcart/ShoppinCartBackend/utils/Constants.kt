package com.shoppingcart.ShoppinCartBackend.utils

class Constants {

    companion object {
        private const val URL_API_BASE = "/api"
        private const val URL_API_VERSION = "/v1"
        private const val URL_BASE = URL_API_BASE + URL_API_VERSION

        //url for products
        const val URL_BASE_PRODUCTS = "$URL_BASE/products"
    }
}