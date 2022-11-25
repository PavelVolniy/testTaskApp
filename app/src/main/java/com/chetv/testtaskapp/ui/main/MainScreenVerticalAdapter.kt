package com.chetv.testtaskapp.ui.main

import com.chetv.testtaskapp.model.base.MainScreenListItem
import com.chetv.testtaskapp.ui.base.BaseDiffUtilItemCallbackMain
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class MainScreenVerticalAdapter :
  AsyncListDifferDelegationAdapter<MainScreenListItem>(BaseDiffUtilItemCallbackMain()) {
  init {
    delegatesManager.addDelegate(MainScreenDelegate.selectCategoryDelegate())
                    .addDelegate(MainScreenDelegate.hotSalesHorizontalDelegate())
                    .addDelegate(MainScreenDelegate.bestSellerDelegate())
  }
}