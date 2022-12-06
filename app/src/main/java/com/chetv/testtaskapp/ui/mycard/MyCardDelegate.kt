package com.chetv.testtaskapp.ui.mycard

import android.app.Activity
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.chetv.testtaskapp.data.mycardjson.Basket
import com.chetv.testtaskapp.data.mycardjson.MyCardJson
import com.chetv.testtaskapp.databinding.McItemBinding
import com.chetv.testtaskapp.databinding.McRecyclerVerticalBinding
import com.chetv.testtaskapp.model.base.MyCardListItem
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

object MyCardDelegate {

  fun myCardDelegate() =
    adapterDelegateViewBinding<MyCardJson, MyCardListItem, McRecyclerVerticalBinding>(
      { inflater, container ->
        McRecyclerVerticalBinding.inflate(inflater, container, false).apply {
          recyclerViewItems.adapter = ListDelegationAdapter(myCardItemAdapter())
        }
      }
    ) {
      bind {
        (binding.recyclerViewItems.adapter as ListDelegationAdapter<*>).apply {
          items = item.basket
        }
        binding.tvTotal.text = "$${item.total} us"
        binding.tvDelivery.text = item.delivery
        binding.tvCheckout.setOnClickListener {
          Toast.makeText(
            context,
            "Clicked the ${binding.tvCheckout.text}",
            Toast.LENGTH_SHORT
          ).show()
        }
      }
    }

  private fun myCardItemAdapter() =
    adapterDelegateViewBinding<Basket, MyCardListItem, McItemBinding>(
      { inflater, container -> McItemBinding.inflate(inflater, container, false) }
    ) {
      bind {
        Glide.with(binding.root)
          .load(item.images)
          .transform(RoundedCorners(20))
          .transition(withCrossFade())
          .into(binding.ivMcImageItem)
        binding.tvMcPrice.text = "$${item.price}"
        binding.tvMcTitleItem.text = item.title
      }
      onViewRecycled {
        if ((binding.root.context as? Activity)?.isDestroyed?.not() == true) {
          Glide.with(binding.root).clear(binding.ivMcImageItem)
        }
      }

    }

}