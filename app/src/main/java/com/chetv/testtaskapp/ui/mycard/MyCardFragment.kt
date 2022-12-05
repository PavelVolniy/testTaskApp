package com.chetv.testtaskapp.ui.mycard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.chetv.testtaskapp.R
import com.chetv.testtaskapp.databinding.FragmentMyCardBinding
import com.chetv.testtaskapp.ui.base.viewBinding
import com.chetv.testtaskapp.viewmodel.mycard.MyCardComponent
import com.chetv.testtaskapp.viewmodel.mycard.MyCardViewModel


class MyCardFragment : Fragment(R.layout.fragment_my_card) {
  private val component by lazy { MyCardComponent.create() }
  private val binding by viewBinding { FragmentMyCardBinding.bind(it) }
  private val viewModel by viewModels<MyCardViewModel> { component.viewModelFactory() }
  private val adapter = MyCardAdapter()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    with(binding){
      recyclerView.adapter = adapter
      viewModel.data.observe(viewLifecycleOwner){
        adapter.items = it
      }
    }
  }

}