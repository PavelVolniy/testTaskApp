package com.chetv.testtaskapp.model.test

import com.chetv.testtaskapp.model.base.MainScreenListItem

class SelectCategoryList(
  val listCategory: List<SelectCategoryItem>
) : MainScreenListItem{
  override val itemID: Long = this.hashCode().toLong()
}