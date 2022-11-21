package com.example.electronicshop.ui.adapter

import android.view.View
import coil.load
import com.example.electronicshop.databinding.BestSellersSliderItemBinding
import com.example.electronicshop.model.BestSellerProduct
import com.livermor.delegateadapter.delegate.ViewBindingDelegateAdapter

class BestSellersDelegateAdapter(
    private val clickListener: (BestSellerProduct) -> Unit):
    ViewBindingDelegateAdapter<BestSellerProduct, BestSellersSliderItemBinding>(BestSellersSliderItemBinding::inflate) {
    override fun isForViewType(item: Any) = item is BestSellerProduct

    override fun BestSellerProduct.getItemId(): Any = id

    override fun BestSellersSliderItemBinding.onBind(item: BestSellerProduct) {
        bestSellerItemTitle.text = item.title
        bestSellerItemPrice.text = item.price_without_discount.toString()
        discountPrice.text = item.discount_price.toString()
        bestSellerItemImage.load(item.picture)
        root.setOnClickListener {
            clickListener(item)
        }
    }
}