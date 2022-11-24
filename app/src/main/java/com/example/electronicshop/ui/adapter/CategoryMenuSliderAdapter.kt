package com.example.electronicshop.ui.adapter

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.electronicshop.R
import com.example.electronicshop.databinding.CategoryMenuItemBinding
import com.example.electronicshop.model.CategoryItem

class CategoryMenuSliderAdapter(
    private val dataset: ArrayList<CategoryItem>
): RecyclerView.Adapter<CategoryMenuSliderAdapter.CategoryMenuSliderViewHolder>() {

    class CategoryMenuSliderViewHolder(
        private var binding: CategoryMenuItemBinding,
    ): RecyclerView.ViewHolder(binding.root) {


        fun bind(categoryItem: CategoryItem, currentMenu: Int) {
            val context = binding.root.context
            binding.categoryMenuItemTitle.text = context.getText(categoryItem.titleResourceId)
            binding.categoryMenuItemIcon.setImageResource(categoryItem.imageResourceId)

            if(currentMenu == categoryItem.id){
                binding.categoryMenuItemIcon.backgroundTintList = ColorStateList.valueOf(context.getColor(R.color.orange))
                binding.categoryMenuItemIcon.imageTintList = ColorStateList.valueOf(context.getColor(R.color.white))
                binding.categoryMenuItemTitle.setTextColor(context.getColor(R.color.orange))

            } else {
                binding.categoryMenuItemIcon.backgroundTintList = ColorStateList.valueOf(context.getColor(R.color.white))
                binding.categoryMenuItemIcon.imageTintList = ColorStateList.valueOf(context.getColor(R.color.dark_gray))
                binding.categoryMenuItemTitle.setTextColor(context.getColor(R.color.dark_blue))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryMenuSliderViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CategoryMenuSliderViewHolder(
            CategoryMenuItemBinding.inflate(layoutInflater, parent, false)
        )
    }
    private var selectedPos = RecyclerView.NO_POSITION;

    override fun onBindViewHolder(holder: CategoryMenuSliderViewHolder, position: Int) {
        val categoryItem = dataset[position]
        val lastCategoryId = dataset.lastIndex
        holder.itemView.isSelected = position == selectedPos
        holder.itemView.setOnClickListener{
            notifyItemChanged(selectedPos)
            selectedPos = holder.layoutPosition
            notifyItemChanged(selectedPos)
        }
        holder.bind(categoryItem, selectedPos)

    }

    override fun getItemCount() = dataset.size
}