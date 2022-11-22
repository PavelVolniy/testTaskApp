package com.chetv.testtaskapp.ui.base

import androidx.recyclerview.widget.DiffUtil
import com.chetv.testtaskapp.model.base.ListItem

open class BaseDiffUtilItemCallback: DiffUtil.ItemCallback<ListItem>() {
      override fun areItemsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
        return oldItem.itemID == newItem.itemID
      }
      override fun areContentsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
        return oldItem.equals(newItem)
      }

}