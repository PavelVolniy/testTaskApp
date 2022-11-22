package com.chetv.testtaskapp.ui.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.chetv.testtaskapp.R
import com.chetv.testtaskapp.databinding.FragmentMainBinding
import com.chetv.testtaskapp.model.base.ListItem
import com.chetv.testtaskapp.ui.base.viewBinding
import com.chetv.testtaskapp.viewmodel.main.MainScreenComponent
import com.chetv.testtaskapp.viewmodel.main.MainScreenViewModel
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class MainFragment : Fragment(R.layout.fragment_main) {
  private lateinit var component: MainScreenComponent
//  private val component by  lazy {  }
  private val binding by viewBinding { FragmentMainBinding.bind(it) }
  private val viewModel by viewModels<MainScreenViewModel> {component.viewModelFactory()}

  private val adapter = MainScreenVerticalAdapter()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    with(binding) {
      recyclerView.adapter = adapter
      viewModel.data.observe(viewLifecycleOwner, Observer {
        adapter.items = it
        binding.ibFilter.setOnClickListener {
          Toast.makeText(context, "In process developer", Toast.LENGTH_SHORT).show()
        }
      })
    }
  }

  companion object{
    fun create(component: MainScreenComponent) = MainFragment().apply {
      this.component = component
    }
  }
}