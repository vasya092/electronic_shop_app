package com.example.electronicshop.ui.adapter

import android.view.View
import coil.load
import com.example.electronicshop.databinding.HotSalesSliderItemBinding
import com.example.electronicshop.model.HomeProduct
import com.livermor.delegateadapter.delegate.ViewBindingDelegateAdapter

class HotSalesDelegateAdapter: ViewBindingDelegateAdapter<HomeProduct, HotSalesSliderItemBinding>(HotSalesSliderItemBinding::inflate) {
    override fun isForViewType(item: Any) = item is HomeProduct

    override fun HomeProduct.getItemId(): Any = id

    override fun HotSalesSliderItemBinding.onBind(item: HomeProduct) {
        hotSalesBackground.load(item.picture)
        hotSalesTitle.text = item.title
        hotSalesDescription.text = item.subtitle
        if(item.is_new) {
            hotSalesBadge.visibility = View.VISIBLE
        }
    }
}