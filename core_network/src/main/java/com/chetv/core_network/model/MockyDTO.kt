package com.chetv.core_network.model

import com.google.gson.annotations.SerializedName

data class MockyDTO(
  @SerializedName("id") val id: Long,
  @SerializedName("name") val title: String,
  @SerializedName("picture") val image: String
)