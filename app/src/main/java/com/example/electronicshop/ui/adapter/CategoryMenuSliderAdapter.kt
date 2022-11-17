package com.example.electronicshop.ui.adapter

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.marginEnd
import androidx.recyclerview.widget.RecyclerView
import com.example.electronicshop.R
import com.example.electronicshop.databinding.CategoryMenuItemBinding
import com.example.electronicshop.model.CategoryItem

class CategoryMenuSliderAdapter(
    private val dataset: ArrayList<CategoryItem>
): RecyclerView.Adapter<CategoryMenuSliderAdapter.CategoryMenuSliderViewHolder>() {

    class CategoryMenuSliderViewHolder(
        private var binding: CategoryMenuItemBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(categoryItem: CategoryItem, isLastElement: Boolean) {
            val context = binding.root.context
            binding.categoryMenuItemTitle.text = context.getText(categoryItem.titleResourceId)
            binding.categoryMenuItemIcon.setImageResource(categoryItem.imageResourceId)
            if(isLastElement) {
                val layoutParams = binding.categoryMenuItem.layoutParams
                (layoutParams as ViewGroup.MarginLayoutParams).marginEnd = context.resources.getDimensionPixelSize(R.dimen.category_menu_last_item_margin)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryMenuSliderViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CategoryMenuSliderViewHolder(
            CategoryMenuItemBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CategoryMenuSliderViewHolder, position: Int) {
        val categoryItem = dataset[position]
        val isLastElement = position == dataset.lastIndex
        holder.bind(categoryItem, isLastElement)
    }

    override fun getItemCount() = dataset.size
}