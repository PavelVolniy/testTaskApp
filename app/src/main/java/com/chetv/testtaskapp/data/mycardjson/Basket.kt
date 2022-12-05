package com.chetv.testtaskapp.data.mycardjson

import com.chetv.testtaskapp.model.base.MyCardListItem

data class Basket(
    val id: Int,
    val images: String,
    val price: Int,
    val title: String
): MyCardListItem {
    override val itemID: Long
        get() = id.toLong()
}