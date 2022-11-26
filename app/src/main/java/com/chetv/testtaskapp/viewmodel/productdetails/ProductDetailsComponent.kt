package com.chetv.testtaskapp.viewmodel.productdetails

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.multibindings.IntoMap

@Component
interface ProductDetailsComponent {
}

@Module
abstract class ProductDetailsModule{

  @Binds
  @IntoMap
  abstract fun productDetailsViewModel(viewModel: ProductDetailsViewModel):ViewModel
}