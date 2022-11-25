package com.chetv.testtaskapp.data.productdetailsjson

import com.chetv.testtaskapp.model.base.ProductDetailsListItem

class DetailsParamsItem(
  val cpu: String,
  val camera: String,
  val sd: String,
  val ssd: String,
): ProductDetailsListItem {
  override val itemID: Long = this.hashCode().toLong()

}