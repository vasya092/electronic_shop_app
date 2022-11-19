package com.example.electronicshop.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.electronicshop.R
import com.example.electronicshop.databinding.HotSalesSliderItemBinding
import com.example.electronicshop.model.HomeProduct

class HotSalesSliderAdapter(
    private val clickListener: (HomeProduct) -> Unit
): ListAdapter<HomeProduct, HotSalesSliderAdapter.HotSalesSliderViewHolder>(DiffCallback){
    class HotSalesSliderViewHolder(
        private var binding: HotSalesSliderItemBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(homeProduct: HomeProduct) {
            binding.hotSalesTitle.text = homeProduct.title
            binding.hotSalesPicture.setImageResource(R.drawable.test_apple_background)
            binding.hotSalesDescription.text = homeProduct.subtitle
            if(homeProduct.is_new) {
                binding.hotSalesBadge.visibility = View.VISIBLE
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotSalesSliderViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HotSalesSliderViewHolder(
            HotSalesSliderItemBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: HotSalesSliderViewHolder, position: Int) {
        val productItem = getItem(position)
        holder.itemView.setOnClickListener{
            clickListener(productItem)
        }
        holder.bind(productItem)
    }

    companion object DiffCallback: DiffUtil.ItemCallback<HomeProduct>() {
        override fun areItemsTheSame(oldItem: HomeProduct, newItem: HomeProduct): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: HomeProduct, newItem: HomeProduct): Boolean {
            return oldItem == newItem
        }
    }
}