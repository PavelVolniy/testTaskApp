package com.chetv.testtaskapp.model.test

import com.chetv.testtaskapp.data.mainscreenjson.BestSeller
import com.chetv.testtaskapp.model.base.MainScreenListItem

class BestSellerList(val json: List<BestSeller>, val title: String): MainScreenListItem {
  override val itemID: Long = this.hashCode().toLong()
}