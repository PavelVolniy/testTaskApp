package com.chetv.testtaskapp.data.productdetailsjson

import com.chetv.testtaskapp.model.base.ProductDetailsListItem

class CapacityColorPriceItem(
  val capacity: List<String>,
  val color: List<Int>,
  val price: String
) : ProductDetailsListItem {
  override val itemID: Long = this.hashCode().toLong()
}
