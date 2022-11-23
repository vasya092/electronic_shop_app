package com.example.electronicshop.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.electronicshop.R
import com.example.electronicshop.databinding.BottomSheetFilterBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class FilterBottomSheet: BottomSheetDialogFragment() {

    private var binding: BottomSheetFilterBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BottomSheetFilterBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        context?.let {
            //Brand adapter
            ArrayAdapter.createFromResource(
                it,
                R.array.brands_array,
                android.R.layout.simple_spinner_item
            ).also { arrayAdapter ->
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
                binding?.brandSelector?.adapter = arrayAdapter
            }

            //Price adapter
            ArrayAdapter.createFromResource(
                it,
                R.array.prices_array,
                android.R.layout.simple_spinner_item
            ).also { arrayAdapter ->
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
                binding?.priceSelector?.adapter = arrayAdapter
            }
            //Size adapter
            ArrayAdapter.createFromResource(
                it,
                R.array.sizes_array,
                android.R.layout.simple_spinner_item
            ).also { arrayAdapter ->
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
                binding?.sizeSelector?.adapter = arrayAdapter
            }
        }
    }

    companion object {
        const val TAG = "ModalBottomSheet"
    }
}