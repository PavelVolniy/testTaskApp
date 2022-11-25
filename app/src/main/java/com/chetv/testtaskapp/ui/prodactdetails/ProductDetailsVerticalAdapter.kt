package com.chetv.testtaskapp.ui.prodactdetails

import com.chetv.testtaskapp.model.base.ProductDetailsListItem
import com.chetv.testtaskapp.ui.base.BaseDiffUtilItemCallbackMain
import com.chetv.testtaskapp.ui.base.BaseDiffUtilItemCallbackProductDetails
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class ProductDetailsVerticalAdapter :
  AsyncListDifferDelegationAdapter<ProductDetailsListItem>(BaseDiffUtilItemCallbackProductDetails()) {
  init {
    delegatesManager.addDelegate(ProductDetailsDelegate.productDetailsDelegateHorizontal())
                    .addDelegate(ProductDetailsDelegate.productDetailsDelegate())
  }
}