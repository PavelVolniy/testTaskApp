package com.chetv.core_network.api.params

import androidx.annotation.StringRes

data class ApiParams(
  val page: Int? = null,
  val pageSize: Int? = null,
  val dates: String? = null
) {
  fun toMap(): Map<String, String> = mutableMapOf<String, String>().apply {
    page?.let { put("page", it.toString()) }
    pageSize?.let { put("pageSize", it.toString()) }
    dates?.let { put("dates", it) }
  }
}