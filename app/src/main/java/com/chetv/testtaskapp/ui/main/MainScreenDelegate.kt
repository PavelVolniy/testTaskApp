package com.chetv.testtaskapp.ui.main

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.FrameLayout
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.chetv.testtaskapp.data.mainscreenjson.BestSeller
import com.chetv.testtaskapp.data.mainscreenjson.HomeStore
import com.chetv.testtaskapp.databinding.*
import com.chetv.testtaskapp.model.base.MainScreenListItem
import com.chetv.testtaskapp.model.test.BestSellerList
import com.chetv.testtaskapp.model.test.SelectCategoryItem
import com.chetv.testtaskapp.model.test.SelectCategoryList
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

object MainScreenDelegate {

  fun bestSellerDelegate() =
    adapterDelegateViewBinding<BestSellerList, MainScreenListItem, BestSellerHorizontalListBinding>(
      { inflater, container ->
        BestSellerHorizontalListBinding.inflate(inflater, container, false).apply {
          recyclerView.adapter = ListDelegationAdapter(bestSellerItemAdapter())
        }
      }
    ) {
      bind {
        binding.title = item.title
        binding.recyclerView.layoutManager = GridLayoutManager(context, 2)
        (binding.recyclerView.adapter as ListDelegationAdapter<*>).items = item.json
      }
    }

  private fun bestSellerItemAdapter() =
    adapterDelegateViewBinding<BestSeller, MainScreenListItem, BestSellerItemBinding>(
      { inflater, container ->
        BestSellerItemBinding.inflate(inflater, container, false)
      }
    ) {
      bind {
        Glide.with(binding.root)
          .load(item.picture)
          .transition(withCrossFade())
          .into(binding.ivBestSellerImItem)
        binding.tvNameBestSellerItem.text = item.title
        binding.tvPriceWithoutSale.text = "$${item.price_without_discount}"
        binding.tvPriceWithSale.text = "$${item.discount_price}"
        binding.executePendingBindings()
      }
      onViewRecycled {
        if ((binding.root.context as? Activity)?.isDestroyed?.not() == true) {
          Glide.with(binding.root).clear(binding.ivBestSellerImItem)
        }
      }
    }


  fun hotSalesHorizontalDelegate() =
    adapterDelegateViewBinding<com.chetv.testtaskapp.model.test.HotSalesList, MainScreenListItem, HotSalesHorizontalListBinding>(
      { inflater, container ->
        HotSalesHorizontalListBinding.inflate(inflater, container, false).apply {
          //on create ViewHolder
          recyclerView.adapter = ListDelegationAdapter(hotSalesItemAdapterDelegate())
        }
      }
    ) {
      //on bind ViewHolder
      bind {
        binding.title = item.title
        (binding.recyclerView.adapter as ListDelegationAdapter<*>).apply {
          binding.tvSeeMore.setOnClickListener {
            Toast.makeText(context, "see more is clicked ", Toast.LENGTH_SHORT).show()
          }
          items = item.json
        }

      }
    }


  private fun hotSalesItemAdapterDelegate() =
    adapterDelegateViewBinding<HomeStore, MainScreenListItem, HotSalesItemBinding>(
      { inflater, container -> HotSalesItemBinding.inflate(inflater, container, false) }
    ) {
      bind {
        Glide.with(binding.root)
          .load(item.picture)
          .optionalCenterCrop()
          .transition(withCrossFade())
          .into(binding.ivHotSalesImage)
        binding.ivHotSalesImage.setBackgroundColor(Color.BLACK)
        binding.tvTitleHotSales.text = item.title
        binding.tvSubtitle.text = item.subtitle
        if (item.is_new) {
          binding.icIsNew.visibility = FrameLayout.VISIBLE
        } else {
          binding.icIsNew.visibility = FrameLayout.INVISIBLE
        }
        binding.tvButtonByNow.setOnClickListener {
          Toast.makeText(context, "click button By_now!!", Toast.LENGTH_SHORT).show()
        }
        binding.executePendingBindings()
      }

      onViewRecycled {
        if ((binding.root.context as? Activity)?.isDestroyed?.not() == true) {
          Glide.with(binding.root).clear(binding.ivHotSalesImage)
        }
      }
    }

  fun selectCategoryDelegate() =
    adapterDelegateViewBinding<SelectCategoryList, MainScreenListItem, SelectCategoryHorizontalListBinding>(
      { inflater, container ->
        SelectCategoryHorizontalListBinding.inflate(
          inflater,
          container,
          false
        ).apply {
          recyclerView.adapter = ListDelegationAdapter(selectCategoryAdapter())
        }
      }
    ) {
      bind {
        (binding.recyclerView.adapter as ListDelegationAdapter<*>).items = item.listCategory
        binding.ibSearchButton.setOnClickListener {
          Toast.makeText(context, "Search text - ${binding.etFindField.text}", Toast.LENGTH_SHORT)
            .show()
          binding.etFindField.text.clear()
          itemView.hideKeyboard()
        }
      }
    }

  private fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
  }

  private fun selectCategoryAdapter() =
    adapterDelegateViewBinding<SelectCategoryItem, MainScreenListItem, SelectCategoryItemBinding>(
      { inflater, container ->
        SelectCategoryItemBinding.inflate(inflater, container, false)
      }
    ) {
      bind {
        binding.enabled = item.enabled
        binding.ivIcSelectCategory.setImageResource(item.icon)
        binding.tvIcSelectCategory.text = item.nameCategory
        binding.executePendingBindings()
      }
    }
}
