package com.chetv.testtaskapp.ui.prodactdetails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import com.chetv.testtaskapp.R
import com.chetv.testtaskapp.databinding.PdFragmentBinding
import com.chetv.testtaskapp.ui.base.viewBinding
import com.chetv.testtaskapp.ui.mycard.MyCardFragment
import com.chetv.testtaskapp.viewmodel.productdetails.ProductDetailsComponent
import com.chetv.testtaskapp.viewmodel.productdetails.ProductDetailsViewModel

class ProductDetailsFragment: Fragment(R.layout.pd_fragment) {
  private val component by lazy { ProductDetailsComponent.create() }
  private val binding by viewBinding { PdFragmentBinding.bind(it) }
  private val viewModel by viewModels<ProductDetailsViewModel> { component.viewModelFactory() }
  private val adapter = ProductDetailsAdapter()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    with(binding){
      pdRecyclerView.adapter = adapter
      viewModel.data.observe(viewLifecycleOwner) {
        adapter.items = it
        binding.ibPdBasketButton.setOnClickListener {
          (context as FragmentActivity).supportFragmentManager.beginTransaction()
            .replace(R.id.container, MyCardFragment())
            .addToBackStack("ProductDt")
            .commit()
        }
        binding.ibPdBackButton.setOnClickListener {
          (context as FragmentActivity).supportFragmentManager.popBackStack(
            "MainSc",
            FragmentManager.POP_BACK_STACK_INCLUSIVE
          )
        }
      }
    }
  }
}