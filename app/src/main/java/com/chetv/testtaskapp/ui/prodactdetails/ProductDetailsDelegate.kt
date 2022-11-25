package com.chetv.testtaskapp.ui.prodactdetails

import android.graphics.drawable.Drawable
import android.widget.CheckBox
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.chetv.testtaskapp.R
import com.chetv.testtaskapp.data.productdetailsjson.*
import com.chetv.testtaskapp.databinding.PdColorCapacityItemBinding
import com.chetv.testtaskapp.databinding.PdDetailsItemBinding
import com.chetv.testtaskapp.databinding.PdDetailsVerticalBinding
import com.chetv.testtaskapp.databinding.PdImageItemBinding
import com.chetv.testtaskapp.databinding.PdImageListHorizontalBinding
import com.chetv.testtaskapp.databinding.PdTabBarItemBinding
import com.chetv.testtaskapp.databinding.PdTitleItemBinding
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
    ) {}

  private fun productDetailsImageAdapter() =
    adapterDelegateViewBinding<ImagesItem, ProductDetailsListItem, PdImageItemBinding>(
      { inflater, container ->
        PdImageItemBinding.inflate(inflater, container, false)
      }
    ) {
      bind {
        Glide.with(binding.root)
          .load(item)
          .optionalCenterCrop()
          .transition(DrawableTransitionOptions.withCrossFade())
          .into(binding.ivPdImage)
      }
    }

  fun productDetailsDelegate() =
    adapterDelegateViewBinding<ItemJsonMocky, ProductDetailsListItem, PdDetailsVerticalBinding>(
      { inflater, container ->
        PdDetailsVerticalBinding.inflate(inflater, container, false).apply {
          recyclerView.adapter = ListDelegationAdapter(
            productDetailsTitleItem(),
            productDetailsTabBarItem(),
            productDetailsParams(),
            productDelegatesColorCapacityAdapter()
          )
        }
      }
    ) {

    }

  private fun productDetailsTitleItem() =
    adapterDelegateViewBinding<DetailsTitleItem, ProductDetailsListItem, PdTitleItemBinding>(
      { inflater, container -> PdTitleItemBinding.inflate(inflater, container, false) }
    ) {
      bind {
        binding.tvNameItemPd.text = item.title
        binding.rbRating.rating = item.rating
        if (item.isFavorites) {
          binding.ivIsFavorites.setImageResource(R.drawable.ic_like_best_seller_enabled)
        } else {
          binding.ivIsFavorites.setImageResource(R.drawable.ic_like_best_seller_disabled)
        }
      }
    }

  private fun productDetailsTabBarItem() =
    adapterDelegateViewBinding<TabBarItem, ProductDetailsListItem, PdTabBarItemBinding>(
      { inflater, container -> PdTabBarItemBinding.inflate(inflater, container, false) }
    ) {}

  private fun productDetailsParams() =
    adapterDelegateViewBinding<DetailsParamsItem, ProductDetailsListItem, PdDetailsItemBinding>(
      {inflater,container-> PdDetailsItemBinding.inflate(inflater,container,false)}
    ){
      bind {
        binding.tvTitleCam.text = item.camera
        binding.tvTitleCpu.text = item.cpu
        binding.tvTitleMemory.text = item.sd
        binding.tvTitleRam.text = item.ssd
      }
    }

  private fun productDelegatesColorCapacityAdapter() =
    adapterDelegateViewBinding<CapacityColorPriceItem, ProductDetailsListItem, PdColorCapacityItemBinding>(
      {inflater, container-> PdColorCapacityItemBinding.inflate(inflater,container,false)}
    ){
      bind{
        for (i in item.color){
          val checkBox = CheckBox(context)
          checkBox.setBackgroundColor(i)
          checkBox.setButtonDrawable(R.drawable.pd_selector_color)
          binding.rgSelectColor.addView(checkBox)
        }
        for (j in item.capacity){
          val textBt = TextView(context)
          textBt.text = j
          binding.rgSelectColor.addView(textBt)
        }
      }
    }
}