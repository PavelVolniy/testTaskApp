package com.chetv.testtaskapp.data.productdetailsjson

import com.chetv.testtaskapp.model.base.ProductDetailsListItem

class ListItemDetails(
  val list: List<ProductDetailsListItem>
): ProductDetailsListItem {
  override val itemID: Long
    get() = this.hashCode().toLong()
}