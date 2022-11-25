package com.chetv.core_network.di

import com.chetv.core_network.BuildConfig
import com.chetv.core_network.api.MockyApi
import dagger.Component
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Component(modules = [NetWorkModule::class])
@Singleton
interface NetworkComponent {

  fun api(): MockyApi
}
@Module
abstract class NetWorkModule {

  companion object{
    private const val BASE_URL = "https://run.mocky.io"

    @Provides
    @Singleton
    fun provideApi():MockyApi = Retrofit.Builder()
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
