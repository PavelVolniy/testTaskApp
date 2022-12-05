package com.chetv.testtaskapp.ui.mycard

import com.chetv.testtaskapp.model.base.MyCardListItem
import com.chetv.testtaskapp.ui.base.BaseDiffUtilItemCallbackMyCard
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class MyCardAdapter :
  AsyncListDifferDelegationAdapter<MyCardListItem>(BaseDiffUtilItemCallbackMyCard()) {
  init {
    delegatesManager.addDelegate(MyCardDelegate.myCardDelegate())
  }
}