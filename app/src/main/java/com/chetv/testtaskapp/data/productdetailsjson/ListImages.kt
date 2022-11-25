package com.chetv.testtaskapp.data.productdetailsjson

import com.chetv.testtaskapp.model.base.ProductDetailsListItem

class ListImages(
  val list: List<ImagesItem>
): ProductDetailsListItem {
  override val itemID: Long
    get() = this.hashCode().toLong()
}