package com.chetv.core_network.api

import com.chetv.testtaskapp.data.mockyjson.JsonMainScreenFromServer
import retrofit2.http.GET

interface MockyApi {

  @GET("/v3/654bd15e-b121-49ba-a588-960956b15175")
  suspend fun mainScreenData(): JsonMainScreenFromServer

}