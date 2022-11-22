package com.chetv.testtaskapp.data.mockyjson

import com.google.gson.annotations.SerializedName

data class JsonMainScreenFromServer(
    @SerializedName("best_seller") val bestSeller: List<BestSellerList>,
    @SerializedName("home_store") val hotSales: List<HotSalesList>
)