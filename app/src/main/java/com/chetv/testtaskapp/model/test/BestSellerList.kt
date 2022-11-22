package com.chetv.testtaskapp.model.test

import com.chetv.testtaskapp.data.mockyjson.BestSeller
import com.chetv.testtaskapp.model.base.ListItem

class BestSellerList(val json: List<BestSeller>): ListItem {
  override val itemID: Long = this.hashCode().toLong()
}