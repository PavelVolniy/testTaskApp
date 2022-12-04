package com.chetv.testtaskapp.viewmodel.productdetails

import androidx.lifecycle.ViewModel
import com.chetv.core_network.api.MockyApi
import com.chetv.testtaskapp.Di
import com.chetv.testtaskapp.di.ViewModelFactory
import com.chetv.testtaskapp.di.ViewModelKey
import com.chetv.testtaskapp.viewmodel.main.DaggerMainScreenComponent
import com.chetv.testtaskapp.viewmodel.main.MainScreenComponent
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Component(modules = [ProductDetailsModule::class])
@Singleton
interface ProductDetailsComponent {
  fun viewModelFactory(): ViewModelFactory

  @Component.Builder
  interface Builder{

    @BindsInstance
    fun api(api: MockyApi): Builder

    fun build(): ProductDetailsComponent
  }

  companion object {
    fun create() = with(Di.appComponent) {
      DaggerProductDetailsComponent.builder()
        .api(Di.networkComponent.api())
        .build()
    }
  }
}

@Module
abstract class ProductDetailsModule{

  @Binds
  @IntoMap
  @ViewModelKey(ProductDetailsViewModel::class)
  abstract fun productDetailsViewModel(viewModel: ProductDetailsViewModel):ViewModel
}