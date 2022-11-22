package com.chetv.testtaskapp.viewmodel.main

import androidx.lifecycle.ViewModel
import com.chetv.testtaskapp.di.ScreenScope
import com.chetv.testtaskapp.di.ViewModelFactory
import com.chetv.testtaskapp.di.ViewModelKey
import com.chetv.testtaskapp.util.AndroidResourceProviderImpl
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.multibindings.IntoMap

@Component(modules = [MainScreenModule::class])
@ScreenScope
interface MainScreenComponent {
  fun viewModelFactory(): ViewModelFactory

  @Component.Builder
  interface Builder{
    @BindsInstance
    fun resource(resourceProviderImpl: AndroidResourceProviderImpl): Builder
    fun build(): MainScreenComponent
  }
}

@Module
abstract class MainScreenModule {

  @Binds
  @IntoMap
  @ViewModelKey(MainScreenViewModel::class)
  abstract fun mainScreenViewModel(viewModel: MainScreenViewModel): ViewModel
}