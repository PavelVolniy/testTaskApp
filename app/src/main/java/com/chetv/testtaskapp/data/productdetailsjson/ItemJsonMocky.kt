package com.chetv.testtaskapp.data.productdetailsjson

import com.chetv.testtaskapp.model.base.ProductDetailsListItem

data class ItemJsonMocky(
    val CPU: String,
    val camera: String,
    val capacity: List<String>,
    val color: List<String>,
    val id: String,
    val images: List<String>,
    val isFavorites: Boolean,
    val price: Int,
    val rating: Double,
    val sd: String,
    val ssd: String,
    val title: String
): ProductDetailsListItem {
    override val itemID: Long
        get() = id.toLong()
}