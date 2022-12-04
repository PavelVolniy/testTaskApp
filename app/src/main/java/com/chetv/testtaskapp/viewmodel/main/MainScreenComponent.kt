package com.chetv.testtaskapp.viewmodel.main

import androidx.lifecycle.ViewModel
import com.chetv.core_network.api.MockyApi
import com.chetv.testtaskapp.Di
import com.chetv.testtaskapp.di.ScreenScope
import com.chetv.testtaskapp.di.ViewModelFactory
import com.chetv.testtaskapp.di.ViewModelKey
import com.chetv.testtaskapp.util.ResourceProvider
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
  interface Builder {
    @BindsInstance
    fun resource(resourceProviderImpl: ResourceProvider): Builder

    @BindsInstance
    fun api(api: MockyApi): Builder

    fun build(): MainScreenComponent
  }

  companion object {
    fun create() = with(Di.appComponent) {
      DaggerMainScreenComponent.builder()
        .resource(resources())
        .api(Di.networkComponent.api())
        .build()
    }
  }
}

@Module
abstract class MainScreenModule {
  @Binds
  @IntoMap
  @ViewModelKey(MainScreenViewModel::class)
  abstract fun mainScreenViewModel(viewModel: MainScreenViewModel): ViewModel
}
