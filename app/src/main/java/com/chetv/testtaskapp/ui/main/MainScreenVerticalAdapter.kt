package com.chetv.testtaskapp.ui.main

import com.chetv.testtaskapp.model.base.ListItem
import com.chetv.testtaskapp.ui.base.BaseDiffUtilItemCallback
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class MainScreenVerticalAdapter :
  AsyncListDifferDelegationAdapter<ListItem>(BaseDiffUtilItemCallback()) {
  init {
    delegatesManager.addDelegate(MainScreenDelegate.selectCategoryDelegate())
                    .addDelegate(MainScreenDelegate.hotSalesHorizontalDelegate())
                    .addDelegate(MainScreenDelegate.bestSellerDelegate())
  }
}