package com.example.electronicshop.ui.adapter

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.electronicshop.databinding.CategoryMenuItemBinding
import com.example.electronicshop.model.CategoryItem

class CategoryMenuSliderAdapter(
    private val dataset: ArrayList<CategoryItem>
): RecyclerView.Adapter<CategoryMenuSliderAdapter.CategoryMenuSliderViewHolder>() {

    class CategoryMenuSliderViewHolder(
        private var binding: CategoryMenuItemBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(categoryItem: CategoryItem) {
            binding.categoryMenuItemTitle.text = binding.root.context.getText(categoryItem.titleResourceId)
            binding.categoryMenuItemIcon.setImageResource(categoryItem.imageResourceId)
            //Обработка нажатия
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
        holder.bind(categoryItem)
    }

    override fun getItemCount() = dataset.size
}