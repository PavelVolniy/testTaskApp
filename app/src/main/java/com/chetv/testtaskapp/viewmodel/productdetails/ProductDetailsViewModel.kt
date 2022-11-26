package com.chetv.testtaskapp.viewmodel.productdetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.chetv.core_network.api.MockyApi
import com.chetv.testtaskapp.data.productdetailsjson.ItemJsonMocky
import com.chetv.testtaskapp.viewmodel.base.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProductDetailsViewModel @Inject constructor(
  private val api: MockyApi
) : BaseViewModel() {


  private val _data = MutableLiveData<List<ItemJsonMocky>>()
  val data: MutableLiveData<List<ItemJsonMocky>> = _data

  init {
    viewModelScope.launch {
      getItems()
    }
  }

  private suspend fun getItems() {

    api.mainScreenData()

  }

}