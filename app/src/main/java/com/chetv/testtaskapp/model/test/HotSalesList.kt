package com.chetv.testtaskapp.model.test

import com.chetv.testtaskapp.data.mockyjson.HomeStore
import com.chetv.testtaskapp.model.base.ListItem

class HotSalesList(val json: List<HomeStore>): ListItem {
  override val itemID: Long = this.hashCode().toLong()
}