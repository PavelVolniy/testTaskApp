package com.chetv.testtaskapp.ui.prodactdetails

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.*
import com.chetv.testtaskapp.R
import com.chetv.testtaskapp.databinding.PdFragmentBinding
import com.chetv.testtaskapp.ui.base.viewBinding
import com.chetv.testtaskapp.viewmodel.main.MainScreenComponent
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
          Toast.makeText(context, "will be go to the basket", Toast.LENGTH_SHORT).show()
        }
        binding.ibPdBackButton.setOnClickListener {
          Toast.makeText(context, "will be go to the back", Toast.LENGTH_SHORT).show()
        }
      }
    }
  }
}