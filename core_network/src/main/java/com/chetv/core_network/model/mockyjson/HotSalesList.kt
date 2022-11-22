package com.chetv.testtaskapp.data.mockyjson


data class HotSalesList(
    val id: Long,
    val is_buy: Boolean,
    var is_new: Boolean,
    val picture: String,
    val subtitle: String,
    val title: String
)