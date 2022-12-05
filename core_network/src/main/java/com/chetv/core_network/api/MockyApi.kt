package com.chetv.core_network.api

import com.chetv.core_network.model.mycard.JsonMyCardFromServer
import com.chetv.core_network.model.productdetails.JsonProductDetailsFromServer
import com.chetv.testtaskapp.data.mainscreenjson.JsonMainScreenFromServer
import retrofit2.http.GET

interface MockyApi {

  @GET("/v3/654bd15e-b121-49ba-a588-960956b15175")
  suspend fun mainScreenData(/*@StringRes res: Map<String, String>*/): JsonMainScreenFromServer

  @GET("/v3/6c14c560-15c6-4248-b9d2-b4508df7d4f5")
  suspend fun productDetailsData(): JsonProductDetailsFromServer

  @GET("v3/53539a72-3c5f-4f30-bbb1-6ca10d42c149")
  suspend fun myCardData(): JsonMyCardFromServer
}