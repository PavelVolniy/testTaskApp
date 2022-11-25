package com.chetv.testtaskapp.data.productdetailsjson

import com.chetv.testtaskapp.model.base.ProductDetailsListItem

class DetailsTitleItem(
  val title: String,
  val rating: Float,
  val isFavorites: Boolean
): ProductDetailsListItem {
  override val itemID: Long = this.hashCode().toLong()
}