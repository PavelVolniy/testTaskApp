package com.chetv.testtaskapp.data.mycardjson

import com.chetv.testtaskapp.model.base.MyCardListItem

data class MyCardJson(
    val basket: List<Basket>,
    val delivery: String,
    val id: String,
    val total: Int
): MyCardListItem {
    override val itemID: Long
        get() = id.toLong()
}