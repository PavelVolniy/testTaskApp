package com.chetv.testtaskapp.viewmodel.productdetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.chetv.core_network.api.MockyApi
import com.chetv.testtaskapp.data.productdetailsjson.*
import com.chetv.testtaskapp.model.base.ProductDetailsListItem
import com.chetv.testtaskapp.viewmodel.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProductDetailsViewModel @Inject constructor(
  private val api: MockyApi
) : BaseViewModel() {


  private val _data = MutableLiveData<List<ProductDetailsListItem>>()
  val data: MutableLiveData<List<ProductDetailsListItem>> = _data

  init {
    viewModelScope.launch(Dispatchers.IO) {
      val data = getItems()
      _data.postValue(data)
    }
  }

  private suspend fun getItems(): List<ProductDetailsListItem> {

    val data = api.productDetailsData()
    val listImages = ListImages(data.images.map { ImagesItem(it) })

    return listOf(
      listImages,
      ListItemDetails(
        listOf(
          DetailsTitleItem(
            title = data.title,
            rating = data.rating,
            isFavorites = data.isFavorites
          ),
          DetailsParamsItem(
            cpu = data.CPU,
            camera = data.camera,
            sd = data.sd,
            ssd = data.ssd
          ),
          CapacityColorPriceItem(
            capacity = data.capacity,
            color = data.color,
            price = data.price.toString()
          )
        )
      )

    )
  }


}