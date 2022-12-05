package com.chetv.testtaskapp.viewmodel.mycard

import androidx.lifecycle.ViewModel
import com.chetv.core_network.api.MockyApi
import com.chetv.testtaskapp.Di
import com.chetv.testtaskapp.di.ViewModelFactory
import com.chetv.testtaskapp.di.ViewModelKey
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Component(modules = [MyCardModule::class])
@Singleton
interface MyCardComponent {
  fun viewModelFactory(): ViewModelFactory

  @Component.Builder
  interface Builder {

    @BindsInstance
    fun api(api: MockyApi): Builder

    fun build(): MyCardComponent
  }

  companion object {
    fun create() = with(Di.appComponent) {
      DaggerMyCardComponent.builder()
        .api(Di.networkComponent.api())
        .build()
    }
  }
}

@Module
abstract class MyCardModule {

  @Binds
  @IntoMap
  @ViewModelKey(MyCardViewModel::class)
  abstract fun myCardViewModel(viewModel: MyCardViewModel): ViewModel
}