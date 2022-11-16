package com.example.electronicshop.data.local

import com.example.electronicshop.R
import com.example.electronicshop.model.CategoryItem

object CategoryItemsData {
    fun getCategoryItems(): ArrayList<CategoryItem> {
        return arrayListOf(
            CategoryItem(
                id = 1,
                titleResourceId = R.string.title_category_item_phones,
                imageResourceId = R.drawable.ic_phone
            ),
            CategoryItem(
                id = 2,
                titleResourceId = R.string.title_category_item_computers,
                imageResourceId = R.drawable.ic_computer
            ),
            CategoryItem(
                id = 3,
                titleResourceId = R.string.title_category_item_health,
                imageResourceId = R.drawable.ic_health
            ),
            CategoryItem(
                id = 4,
                titleResourceId = R.string.title_category_item_books,
                imageResourceId = R.drawable.ic_book
            ),
            CategoryItem(
                id = 5,
                titleResourceId = R.string.title_category_item_other,
                imageResourceId = R.drawable.ic_computer
            ),
        )
    }
}