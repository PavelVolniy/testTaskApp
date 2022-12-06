package com.chetv.testtaskapp.ui.mycard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import com.chetv.testtaskapp.R
import com.chetv.testtaskapp.databinding.McFragmentBinding
import com.chetv.testtaskapp.ui.base.viewBinding
import com.chetv.testtaskapp.viewmodel.mycard.MyCardComponent
import com.chetv.testtaskapp.viewmodel.mycard.MyCardViewModel


class MyCardFragment : Fragment(R.layout.mc_fragment) {
  private val component by lazy { MyCardComponent.create() }
  private val binding by viewBinding { McFragmentBinding.bind(it) }
  private val viewModel by viewModels<MyCardViewModel> { component.viewModelFactory() }
  private val adapter = MyCardAdapter()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    with(binding) {
      recyclerView.adapter = adapter
      viewModel.data.observe(viewLifecycleOwner) {
        adapter.items = it
      }
      binding.ibMcBackButton.setOnClickListener {
        (context as FragmentActivity).supportFragmentManager.popBackStack(
          "MainSc",
          FragmentManager.POP_BACK_STACK_INCLUSIVE
        )
      }
    }
  }

}