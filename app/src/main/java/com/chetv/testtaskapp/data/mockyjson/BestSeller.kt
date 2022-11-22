package com.chetv.testtaskapp.data.mockyjson

import com.chetv.testtaskapp.model.base.ListItem

data class BestSeller(
    val id: Long,
    val is_favorites: Boolean,
    val title: String,
    val price_without_discount: Int,
    val discount_price: Int,
    val picture: String
): ListItem{
    override val itemID: Long
        get() = id
}