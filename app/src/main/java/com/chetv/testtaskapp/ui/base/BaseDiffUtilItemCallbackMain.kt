package com.chetv.testtaskapp.ui.base

import androidx.recyclerview.widget.DiffUtil
import com.chetv.testtaskapp.model.base.MainScreenListItem

open class BaseDiffUtilItemCallbackMain : DiffUtil.ItemCallback<MainScreenListItem>() {
  override fun areItemsTheSame(
    oldItem: MainScreenListItem,
    newItem: MainScreenListItem
  ): Boolean {
    return oldItem.itemID == newItem.itemID
  }

  override fun areContentsTheSame(
    oldItem: MainScreenListItem,
    newItem: MainScreenListItem
  ): Boolean {
    return oldItem.equals(newItem)
  }

}