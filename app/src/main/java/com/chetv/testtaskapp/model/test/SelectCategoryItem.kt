package com.chetv.testtaskapp.model.test

import com.chetv.testtaskapp.model.base.MainScreenListItem

class SelectCategoryItem(
  val id: Long,
  val enabled: Boolean,
  val nameCategory: String,
  val icon: Int
):MainScreenListItem{
  override val itemID: Long = id
}