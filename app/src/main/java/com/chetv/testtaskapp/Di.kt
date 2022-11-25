package com.chetv.testtaskapp

import com.chetv.core_network.di.NetworkComponent
import com.chetv.testtaskapp.di.AppComponent

object Di {
  lateinit var appComponent: AppComponent
    internal set

  lateinit var networkComponent: NetworkComponent
    internal set

}