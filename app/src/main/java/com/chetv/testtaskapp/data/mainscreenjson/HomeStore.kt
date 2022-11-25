package com.chetv.testtaskapp.data.mainscreenjson

import com.chetv.testtaskapp.model.base.MainScreenListItem

data class HomeStore(
    val id: Long,
    val is_buy: Boolean,
    var is_new: Boolean,
    val picture: String,
    val subtitle: String,
    val title: String
): MainScreenListItem{
    override val itemID: Long = id
}