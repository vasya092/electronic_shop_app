package com.example.electronicshop.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.electronicshop.R
import com.example.electronicshop.databinding.BestSellersSliderItemBinding
import com.example.electronicshop.model.BestSellerProduct

class BestSellersSliderAdapter(): ListAdapter<BestSellerProduct, BestSellersSliderAdapter.BestSellersSliderViewHolder>(DiffCallback) {

    class BestSellersSliderViewHolder(
        private var binding: BestSellersSliderItemBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(bestSellerProduct: BestSellerProduct) {
            binding.bestSellerItemPrice.text = bestSellerProduct.price_without_discount.toString()
            binding.bestSellerItemTitle.text = bestSellerProduct.title
            binding.bestSellerItemImage.load(bestSellerProduct.picture)
            binding.discountPrice.text = bestSellerProduct.discount_price.toString()
        }
    }

    companion object DiffCallback: DiffUtil.ItemCallback<BestSellerProduct>() {
        override fun areItemsTheSame(oldItem: BestSellerProduct, newItem: BestSellerProduct): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: BestSellerProduct, newItem: BestSellerProduct): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestSellersSliderViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return BestSellersSliderViewHolder(
            BestSellersSliderItemBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BestSellersSliderViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

}