package com.chetv.testtaskapp

import android.app.Application
import com.chetv.core_network.di.DaggerNetworkComponent
import com.chetv.testtaskapp.di.AppComponent
import com.chetv.testtaskapp.di.DaggerAppComponent
import com.chetv.testtaskapp.viewmodel.main.DaggerMainScreenComponent

class App : Application() {
  override fun onCreate() {
    super.onCreate()
    initDi()
  }

  private fun initDi() {
    Di.appComponent = DaggerAppComponent.builder()
      .appContext(this)
      .build()

    Di.networkComponent = DaggerNetworkComponent.create()

  }
}