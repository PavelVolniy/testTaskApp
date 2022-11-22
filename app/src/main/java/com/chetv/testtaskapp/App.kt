package com.chetv.testtaskapp

import android.app.Application

class App: Application() {
  override fun onCreate() {
    super.onCreate()
    initDi()
  }

  private fun initDi() {

  }
}