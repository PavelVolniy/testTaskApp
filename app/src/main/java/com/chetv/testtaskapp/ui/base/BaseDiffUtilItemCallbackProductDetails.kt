package com.chetv.testtaskapp.ui.base

import androidx.recyclerview.widget.DiffUtil
import com.chetv.testtaskapp.model.base.MainScreenListItem
import com.chetv.testtaskapp.model.base.ProductDetailsListItem

open class BaseDiffUtilItemCallbackProductDetails : DiffUtil.ItemCallback<ProductDetailsListItem>() {
  override fun areItemsTheSame(
    oldItem: ProductDetailsListItem,
    newItem: ProductDetailsListItem
  ): Boolean {
    return oldItem.itemID == newItem.itemID
  }

  override fun areContentsTheSame(
    oldItem: ProductDetailsListItem,
    newItem: ProductDetailsListItem
  ): Boolean {
    return oldItem.equals(newItem)
  }

}