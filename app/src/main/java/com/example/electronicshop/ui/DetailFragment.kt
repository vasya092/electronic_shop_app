package com.example.electronicshop.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.electronicshop.BaseApplication
import com.example.electronicshop.databinding.FragmentDetailBinding
import com.example.electronicshop.ui.viewmodel.DetailProductViewModel
import javax.inject.Inject

class DetailFragment: Fragment() {


    private var binding: FragmentDetailBinding? = null
    @Inject
    lateinit var viewModel: DetailProductViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (activity?.application as BaseApplication).appComponent.inject(this)
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.testTextView?.text = viewModel.status.value.toString()
    }
}