package com.example.electronicshop.ui.adapter

import coil.load
import com.example.electronicshop.databinding.CartListItemBinding
import com.example.electronicshop.model.BasketItem
import com.livermor.delegateadapter.delegate.ViewBindingDelegateAdapter

class CartListDelegateAdapter: ViewBindingDelegateAdapter<BasketItem, CartListItemBinding>(CartListItemBinding::inflate) {
    override fun isForViewType(item: Any) = item is BasketItem

    override fun BasketItem.getItemId(): Any = id

    override fun CartListItemBinding.onBind(item: BasketItem) {
        cartItemTitle.text = item.title
        cartItemPrice.text = item.price.toString()
        cartItemImage.load(item.images)
    }
}