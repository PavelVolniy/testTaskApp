package com.chetv.testtaskapp.ui.filter

import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ArrayAdapter
import android.widget.FrameLayout
import androidx.annotation.RequiresApi
import com.chetv.testtaskapp.R
import com.chetv.testtaskapp.databinding.FilterDialogBinding
import com.chetv.testtaskapp.ui.base.viewBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class FilterDialog : BottomSheetDialogFragment(R.layout.filter_dialog) {
  private val binding by viewBinding { FilterDialogBinding.bind(it) }

  @RequiresApi(Build.VERSION_CODES.S)
  override fun onStart() {
    super.onStart()
    dialog!!.window?.setLayout(
      FrameLayout.LayoutParams.MATCH_PARENT,
      FrameLayout.LayoutParams.WRAP_CONTENT
    )
    dialog!!.window?.setGravity(Gravity.BOTTOM)
//    dialog!!.window?.setBackgroundDrawableResource(R.drawable.bg_rectangle_30dp_radius)

  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    with(binding) {
      binding.ibCloseButton.setOnClickListener { dialog?.cancel() }
      binding.btDoneFilter.setOnClickListener { dialog?.cancel() }
      binding.spBrandField.adapter =
        context?.let {
          ArrayAdapter.createFromResource(
            it,
            R.array.brand_names,
            R.layout.field_spinner_item
          )
        }
      binding.spPriceField.adapter =
        context?.let {
          ArrayAdapter.createFromResource(
            it,
            R.array.range_prices,
            R.layout.field_spinner_item
          )
        }
      binding.spSizeField.adapter =
        context?.let {
          ArrayAdapter.createFromResource(
            it,
            R.array.range_size,
            R.layout.field_spinner_item
          )
        }

    }
  }
}