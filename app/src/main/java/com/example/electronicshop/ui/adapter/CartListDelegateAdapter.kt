package com.example.electronicshop.ui.adapter

import coil.load
import com.example.electronicshop.databinding.CartListItemBinding
import com.example.electronicshop.model.BasketItem
import com.livermor.delegateadapter.delegate.ViewBindingDelegateAdapter
import java.text.NumberFormat
import java.util.*

class CartListDelegateAdapter: ViewBindingDelegateAdapter<BasketItem, CartListItemBinding>(CartListItemBinding::inflate) {
    override fun isForViewType(item: Any) = item is BasketItem

    override fun BasketItem.getItemId(): Any = id

    override fun CartListItemBinding.onBind(item: BasketItem) {
        val numberFormat = NumberFormat.getCurrencyInstance()
        numberFormat.maximumFractionDigits = 0
        numberFormat.currency = Currency.getInstance("USD")

        cartItemTitle.text = item.title
        cartItemPrice.text = numberFormat.format(item.price)
        cartItemImage.load(item.images)
    }
}