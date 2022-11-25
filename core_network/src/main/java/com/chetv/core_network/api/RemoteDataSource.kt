package com.chetv.core_network.api

import com.chetv.core_network.api.params.ApiParams
import com.chetv.testtaskapp.data.mainscreenjson.BestSellerList
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
  private val api: MockyApi
) {

  private val channel = ConflatedBroadcastChannel<PagingState<List<BestSellerList>>>()

  suspend fun initialLoading(params: ApiParams){
    channel.send(PagingState.Initial)
    val response = api.mainScreenData()

    channel.send(PagingState.Content(response.bestSeller))
  }

  suspend fun loadMore(){
    //TODO
  }

  fun observe(): Flow<PagingState<List<BestSellerList>>> = channel.asFlow()

}