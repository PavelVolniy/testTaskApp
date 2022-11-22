package com.chetv.testtaskapp.data.mockyjson

data class BestSellerList(
    val id: Long,
    val is_favorites: Boolean,
    val title: String,
    val price_without_discount: Int,
    val discount_price: Int,
    val picture: String
)