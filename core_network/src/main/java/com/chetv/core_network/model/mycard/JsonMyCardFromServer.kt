package com.chetv.core_network.model.mycard

data class JsonMyCardFromServer(
    val basket: List<Basket>,
    val delivery: String,
    val id: String,
    val total: Int
)