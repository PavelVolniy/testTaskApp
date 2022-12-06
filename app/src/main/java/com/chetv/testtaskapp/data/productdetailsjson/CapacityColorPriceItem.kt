package com.chetv.testtaskapp.data.productdetailsjson

import com.chetv.testtaskapp.model.base.ProductDetailsListItem

class CapacityColorPriceItem(
  val capacity: List<String>,
  val color: List<String>,
  val price: String
) : ProductDetailsListItem {
  override val itemID: Long = this.hashCode().toLong()
}
