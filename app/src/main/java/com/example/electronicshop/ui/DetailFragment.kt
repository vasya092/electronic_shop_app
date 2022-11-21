package com.example.electronicshop.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.electronicshop.BaseApplication
import com.example.electronicshop.databinding.FragmentDetailBinding
import com.example.electronicshop.ui.adapter.CarouselAdapter
import com.example.electronicshop.ui.viewmodel.DetailProductViewModel
import javax.inject.Inject


class DetailFragment: Fragment() {

    private var binding: FragmentDetailBinding? = null
    @Inject
    lateinit var viewModel: DetailProductViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        (activity?.application as BaseApplication).appComponent.inject(this)
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.productDetail.observe(viewLifecycleOwner) {
            binding?.productDetailTitle?.text = it.title
            binding?.titleAdvantagesCpu?.text = it.CPU
            binding?.titleAdvantagesCamera?.text = it.camera
            binding?.titleAdvantagesSsd?.text = it.ssd
            binding?.titleAdvantagesHdd?.text = it.sd
            binding?.selectColorButtonFirst?.isActivated = true
            val adapter = CarouselAdapter(viewModel.productDetail.value?.images)
            binding?.carousel?.setAdapter(adapter)
            binding?.carousel?.refresh()
        }
    }
}