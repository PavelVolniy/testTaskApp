package com.chetv.testtaskapp.viewmodel.mycard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.chetv.core_network.api.MockyApi
import com.chetv.testtaskapp.data.mycardjson.Basket
import com.chetv.testtaskapp.data.mycardjson.MyCardJson
import com.chetv.testtaskapp.model.base.MyCardListItem
import com.chetv.testtaskapp.viewmodel.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MyCardViewModel @Inject constructor(
  private val api: MockyApi
) : BaseViewModel() {

  private val _data = MutableLiveData<List<MyCardListItem>>()
  val data: MutableLiveData<List<MyCardListItem>> = _data

  init {
    viewModelScope.launch(Dispatchers.IO) {
      _data.postValue(getData())
    }
  }

  private suspend fun getData(): List<MyCardListItem> {
    val data = api.myCardData()

    return listOf(
      MyCardJson(
        basket = data.basket.map { Basket(
          id = it.id,
          images = it.images,
          price = it.price,
          title = it.title
        ) },
        delivery = data.delivery,
        id = data.id,
        total = data.total
      )
    )
  }

}