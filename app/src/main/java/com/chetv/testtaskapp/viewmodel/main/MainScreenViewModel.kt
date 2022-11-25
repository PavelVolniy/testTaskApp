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

//  private val api = NetworkComponent.createApi()

  private val _data = MutableLiveData<List<MainScreenListItem>>()
  val data: MutableLiveData<List<MainScreenListItem>> = _data

  init {
    viewModelScope.launch(Dispatchers.IO) {
      val items = getItems()
      _data.postValue(items)
    }
  }


  private suspend fun getItems(): List<MainScreenListItem> {
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
      HotSalesList(jsonMainScreen.home_store, resources.string(R.string.hot_sales)),
      BestSellerList(jsonMainScreen.best_seller, resources.string(R.string.best_seller))
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