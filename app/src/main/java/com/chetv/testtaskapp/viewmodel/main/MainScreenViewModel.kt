package com.chetv.testtaskapp.viewmodel.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.chetv.core_network.di.NetworkComponent
import com.chetv.testtaskapp.R
import com.chetv.testtaskapp.data.mockyjson.BestSeller
import com.chetv.testtaskapp.data.mockyjson.HomeStore
import com.chetv.testtaskapp.data.mockyjson.JsonMainScreen
import com.chetv.testtaskapp.data.mockyjson.JsonMainScreenFromServer
import com.chetv.testtaskapp.model.base.ListItem
import com.chetv.testtaskapp.model.test.*
import com.chetv.testtaskapp.util.ResourceProvider
import com.chetv.testtaskapp.viewmodel.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainScreenViewModel @Inject constructor(
  private val resources: ResourceProvider
) : BaseViewModel() {

  private val api = NetworkComponent.createApi()

  private val _data = MutableLiveData<List<ListItem>>()
  val data: MutableLiveData<List<ListItem>> = _data

  init {
    viewModelScope.launch(Dispatchers.IO) {
      val items = getItems()
      _data.postValue(items)
    }
  }




  private suspend fun getItems(): List<ListItem> {
    val jsonMainScreen = mappingData(api.mainScreenData())
    //test data
//    delay(2000L)
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
      HotSalesList(jsonMainScreen.home_store),
      BestSellerList(jsonMainScreen.best_seller)
    )
  }

  private fun mappingData(jsonMainScreenFromServer: JsonMainScreenFromServer): JsonMainScreen {
    val listBestSeller = mutableListOf<BestSeller>()
    for (i in jsonMainScreenFromServer.bestSeller) {
      listBestSeller.add(
        BestSeller(
          i.id,
          i.is_favorites,
          i.title,
          i.price_without_discount,
          i.discount_price,
          i.picture
        )
      )
    }
    val listHotSales = mutableListOf<HomeStore>()
    for (i in jsonMainScreenFromServer.hotSales) {
      listHotSales.add(
        HomeStore(
          i.id,
          i.is_buy,
          i.is_new,
          i.picture,
          i.subtitle,
          i.title
        )
      )
    }
    return JsonMainScreen(listBestSeller, listHotSales)
  }
}