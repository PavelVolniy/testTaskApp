package com.chetv.testtaskapp.ui.prodactdetails

import com.chetv.testtaskapp.model.base.MainScreenListItem
import com.chetv.testtaskapp.ui.base.BaseDiffUtilItemCallbackMain
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class ProductDetailsAdapter: AsyncListDifferDelegationAdapter<MainScreenListItem>(BaseDiffUtilItemCallbackMain()) {
    init {

    }
}