package com.chetv.testtaskapp.ui.main

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import com.chetv.testtaskapp.R
import com.chetv.testtaskapp.databinding.MainFragmentBinding
import com.chetv.testtaskapp.ui.base.viewBinding
import com.chetv.testtaskapp.ui.filter.FilterDialog
import com.chetv.testtaskapp.ui.mycard.MyCardFragment
import com.chetv.testtaskapp.viewmodel.main.MainScreenComponent
import com.chetv.testtaskapp.viewmodel.main.MainScreenViewModel

class MainFragment : Fragment(R.layout.main_fragment) {
  private val component by lazy { MainScreenComponent.create() }
  private val binding by viewBinding { MainFragmentBinding.bind(it) }
  private val viewModel by viewModels<MainScreenViewModel> { component.viewModelFactory() }
  private val adapter = MainScreenVerticalAdapter()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    with(binding) {
      recyclerView.adapter = adapter
      binding.spListCityNames.adapter =
        context?.let {
          ArrayAdapter.createFromResource(
            it,
            R.array.city_names,
            R.layout.city_spinner_item
          )
        }
      viewModel.data.observe(viewLifecycleOwner) {
        adapter.items = it
        binding.ibFilter.setOnClickListener {
          FilterDialog().show(parentFragmentManager, "CustomFragment")
        }
      }
      binding.ibMsBasket.setOnClickListener {
        (context as FragmentActivity).supportFragmentManager.beginTransaction()
          .replace(R.id.container, MyCardFragment())
          .addToBackStack("MainSc")
          .commit()
      }
    }
  }
}