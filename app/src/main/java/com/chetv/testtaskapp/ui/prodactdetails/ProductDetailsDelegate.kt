package com.chetv.testtaskapp.ui.prodactdetails

import android.app.Activity
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.chetv.testtaskapp.data.productdetailsjson.*
import com.chetv.testtaskapp.databinding.*
import com.chetv.testtaskapp.model.base.ProductDetailsListItem
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

object ProductDetailsDelegate {

  fun productDetailsDelegateHorizontal() =
    adapterDelegateViewBinding<ListImages, ProductDetailsListItem, PdImageListHorizontalBinding>(
      { inflater, container ->
        PdImageListHorizontalBinding.inflate(inflater, container, false).apply {
          recyclerView.adapter = ListDelegationAdapter(productDetailsImageAdapter())
        }
      }
    ) {
      binding.recyclerView.apply {
        set3DItem(false)
        setAlpha(true)
        setInfinite(true)
        setIntervalRatio(0.81f)
      }
      bind {
        (binding.recyclerView.adapter as ListDelegationAdapter<*>).apply {
          items = item.list
        }

      }
    }

  private fun productDetailsImageAdapter() =
    adapterDelegateViewBinding<ImagesItem, ProductDetailsListItem, PdImageItemBinding>(
      { inflater, container ->
        PdImageItemBinding.inflate(inflater, container, false)
      }
    ) {
      bind {
        Glide.with(binding.root)
          .load(item.image)
          .transition(withCrossFade())
          .into(binding.ivPdImage)
      }
      onViewRecycled {
        if ((binding.root.context as? Activity)?.isDestroyed?.not() == true) {
          Glide.with(binding.root).clear(binding.ivPdImage)
        }
      }
    }

  fun productDetailsDelegate() =
    adapterDelegateViewBinding<ListItemDetails, ProductDetailsListItem, PdDetailsVerticalBinding>(
      { inflater, container ->
        PdDetailsVerticalBinding.inflate(inflater, container, false).apply {
          recyclerView.adapter = ListDelegationAdapter(
            productDetailsTitleItem(),
            productDetailsParams(),
            productDelegatesColorCapacityAdapter()
          )
        }
      }
    ) {
      bind {
        (binding.recyclerView.adapter as ListDelegationAdapter<*>).apply {
          items = item.list
        }
      }
    }

  private fun productDetailsTitleItem() =
    adapterDelegateViewBinding<DetailsTitleItem, ProductDetailsListItem, PdTitleItemBinding>(
      { inflater, container -> PdTitleItemBinding.inflate(inflater, container, false) }
    ) {
      bind {
        binding.tvNameItemPd.text = item.title
        binding.rbRating.rating = item.rating
        binding.ivIsFavorites.isChecked = item.isFavorites
      }
    }

  private fun productDetailsParams() =
    adapterDelegateViewBinding<DetailsParamsItem, ProductDetailsListItem, PdDetailsItemBinding>(
      { inflater, container -> PdDetailsItemBinding.inflate(inflater, container, false) }
    ) {
      bind {
        binding.tvTitleCam.text = item.camera
        binding.tvTitleCpu.text = item.cpu
        binding.tvTitleMemory.text = item.sd
        binding.tvTitleRam.text = item.ssd
      }
    }

  private fun productDelegatesColorCapacityAdapter() =
    adapterDelegateViewBinding<CapacityColorPriceItem, ProductDetailsListItem, PdColorCapacityItemBinding>(
      { inflater, container -> PdColorCapacityItemBinding.inflate(inflater, container, false) }
    ) {
      bind {
//        for (i in item.color) {
//          val checkBox = CheckBox(context)
//          checkBox.setButtonDrawable(R.drawable.pd_selector_color)
//          binding.rgSelectColor.addView(checkBox)
//        }
        for (j in item.capacity) {
          val textBt = TextView(context)
          textBt.text = j
          binding.rgSelectColor.addView(textBt)
        }
        binding.tvPriceOnButton.text = item.price

      }
    }
}