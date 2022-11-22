package com.chetv.testtaskapp.data.mockyjson

import com.chetv.testtaskapp.model.base.ListItem

data class HomeStore(
    val id: Long,
    val is_buy: Boolean,
    var is_new: Boolean,
    val picture: String,
    val subtitle: String,
    val title: String
): ListItem{
    override val itemID: Long = id
}