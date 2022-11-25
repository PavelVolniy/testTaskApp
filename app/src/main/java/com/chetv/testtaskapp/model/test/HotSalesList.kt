package com.chetv.testtaskapp.model.test

import com.chetv.testtaskapp.data.mainscreenjson.HomeStore
import com.chetv.testtaskapp.model.base.MainScreenListItem

class HotSalesList(val json: List<HomeStore>, val title: String) : MainScreenListItem {
  override val itemID: Long = this.hashCode().toLong()
}