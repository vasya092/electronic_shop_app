package com.example.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.ui.R
import com.example.ui.databinding.ViewSectionHeaderBinding

class SectionHeaderView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    ConstraintLayout(context, attrs, defStyleAttr) {


    private val binding: ViewSectionHeaderBinding = ViewSectionHeaderBinding.inflate(
        LayoutInflater.from(context),
        this,
        true
    )

    private val sectionTitle = binding.sectionTitle

    /**
     * Заголовок блока
     */

    private var title: String = ""
        set(value) {
            sectionTitle.text = value
            field = value
        }

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.SectionHeader,
            0,0).apply {
                try {
                    title = getString(R.styleable.SectionHeader_title).toString()
                } finally {
                    recycle()
                }
        }
    }
}