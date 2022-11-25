package com.chetv.testtaskapp.data.productdetailsjson

import com.chetv.testtaskapp.model.base.ProductDetailsListItem

class ImagesItem(
  val image : String
): ProductDetailsListItem {
  override val itemID: Long = this.hashCode().toLong()

}