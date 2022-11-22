package com.chetv.core_network.di

import com.chetv.core_network.BuildConfig
import com.chetv.core_network.api.MockyApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface NetworkComponent {

  companion object {
    private const val BASE_URL = "https://run.mocky.io"
    fun createApi(): MockyApi = Retrofit.Builder()
      .baseUrl(BASE_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .client(
        OkHttpClient.Builder()
          .addInterceptor(HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                    else HttpLoggingInterceptor.Level.NONE
          })
          .build()
      )
      .build()
      .create(MockyApi::class.java)
  }
}