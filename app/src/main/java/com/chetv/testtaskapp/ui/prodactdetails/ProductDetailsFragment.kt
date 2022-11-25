package com.chetv.testtaskapp.ui.prodactdetails

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.chetv.testtaskapp.R
import com.chetv.testtaskapp.databinding.PdFragmentBinding
import com.chetv.testtaskapp.ui.base.viewBinding
import com.chetv.testtaskapp.viewmodel.main.MainScreenComponent

class ProductDetailsFragment: Fragment(R.layout.pd_fragment) {
  private val component by lazy { MainScreenComponent.create() }
  private val binding by viewBinding { PdFragmentBinding.bind(it) }
  private val adapter = ProductDetailsAdapter()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    with(binding){
      pdRecyclerView.adapter = adapter

    }
  }
}