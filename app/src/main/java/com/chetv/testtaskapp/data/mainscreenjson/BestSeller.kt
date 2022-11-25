package com.chetv.testtaskapp.data.mainscreenjson

import com.chetv.testtaskapp.model.base.MainScreenListItem

data class BestSeller(
    val id: Long,
    val is_favorites: Boolean,
    val title: String,
    val price_without_discount: Int,
    val discount_price: Int,
    val picture: String
): MainScreenListItem{
    override val itemID: Long
        get() = id
}