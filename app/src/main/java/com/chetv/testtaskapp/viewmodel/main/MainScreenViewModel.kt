package com.chetv.testtaskapp.viewmodel.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.chetv.core_network.api.MockyApi
import com.chetv.testtaskapp.R
import com.chetv.testtaskapp.data.mainscreenjson.BestSeller
import com.chetv.testtaskapp.data.mainscreenjson.HomeStore
import com.chetv.testtaskapp.data.mainscreenjson.JsonMainScreen
import com.chetv.testtaskapp.data.mainscreenjson.JsonMainScreenFromServer
import com.chetv.testtaskapp.model.base.MainScreenListItem
import com.chetv.testtaskapp.model.test.*
import com.chetv.testtaskapp.util.ResourceProvider
import com.chetv.testtaskapp.viewmodel.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainScreenViewModel @Inject constructor(
  private val resources: ResourceProvider,
  private val api: MockyApi
) : BaseViewModel() {

  private val _data = MutableLiveData<List<MainScreenListItem>>()
  val data: MutableLiveData<List<MainScreenListItem>> = _data

  init {
    viewModelScope.launch(Dispatchers.IO) {
      val items = getItems()
      _data.postValue(items)
    }
  }


  private suspend fun getItems(): List<MainScreenListItem> {
    val data = api.mainScreenData()
    return listOf(
      SelectCategoryList(
        listOf(
          SelectCategoryItem(0, true, "Phones", R.drawable.ic_sc_phone_iphone_24),
          SelectCategoryItem(1, false, "Health", R.drawable.ic_sc_heart),
          SelectCategoryItem(2, false, "Computer", R.drawable.ic_computer),
          SelectCategoryItem(3, false, "Books", R.drawable.ic_sc_books),
          SelectCategoryItem(4, false, "Settings", R.drawable.ic_sc_settings)
        )
      ),
      HotSalesList(data.hotSales.map { HomeStore(
        id = it.id,
        is_buy = it.is_buy,
        is_new = it.is_new,
        picture = it.picture,
        subtitle = it.subtitle,
        title = it.title
      ) }, resources.string(R.string.hot_sales)),
      BestSellerList(data.bestSeller.map {
        BestSeller(
          id = it.id,
          is_favorites = it.is_favorites,
          title = it.title,
          price_without_discount = it.price_without_discount,
          discount_price = it.discount_price,
          picture = it.picture
        )
      }, resources.string(R.string.best_seller))
    )
  }
}