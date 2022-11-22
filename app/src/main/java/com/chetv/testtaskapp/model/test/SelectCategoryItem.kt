package com.chetv.testtaskapp.model.test

import com.chetv.testtaskapp.model.base.ListItem

class SelectCategoryItem(
  val id: Long,
  val enabled: Boolean,
  val nameCategory: String,
  val icon: Int
):ListItem{
  override val itemID: Long = id
}