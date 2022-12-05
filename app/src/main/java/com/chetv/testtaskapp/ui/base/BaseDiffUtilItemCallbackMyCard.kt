package com.chetv.testtaskapp.ui.base

import androidx.recyclerview.widget.DiffUtil
import com.chetv.testtaskapp.model.base.MyCardListItem

open class BaseDiffUtilItemCallbackMyCard : DiffUtil.ItemCallback<MyCardListItem>() {
  override fun areItemsTheSame(oldItem: MyCardListItem, newItem: MyCardListItem): Boolean {
    return oldItem.itemID == newItem.itemID
  }

  override fun areContentsTheSame(oldItem: MyCardListItem, newItem: MyCardListItem): Boolean {
    return oldItem.equals(newItem)
  }
}