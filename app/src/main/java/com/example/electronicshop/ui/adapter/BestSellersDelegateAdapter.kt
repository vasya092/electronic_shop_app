package com.example.electronicshop.ui.adapter

import coil.load
import com.example.electronicshop.databinding.BestSellersSliderItemBinding
import com.example.electronicshop.model.BestSellerProduct
import com.livermor.delegateadapter.delegate.ViewBindingDelegateAdapter
import okhttp3.internal.format
import java.text.NumberFormat
import java.util.*

class BestSellersDelegateAdapter(
    private val clickListener: (BestSellerProduct) -> Unit):
    ViewBindingDelegateAdapter<BestSellerProduct, BestSellersSliderItemBinding>(BestSellersSliderItemBinding::inflate) {
    override fun isForViewType(item: Any) = item is BestSellerProduct

    override fun BestSellerProduct.getItemId(): Any = id



    override fun BestSellersSliderItemBinding.onBind(item: BestSellerProduct) {
        val numberFormat = NumberFormat.getCurrencyInstance()
        numberFormat.maximumFractionDigits = 0
        numberFormat.currency = Currency.getInstance("USD")

        bestSellerItemTitle.text = item.title
        bestSellerItemPrice.text = numberFormat.format(item.price_without_discount)
        discountPrice.text = numberFormat.format(item.discount_price)

        bestSellerItemImage.load(item.picture)
        root.setOnClickListener {
            clickListener(item)
        }
    }
}