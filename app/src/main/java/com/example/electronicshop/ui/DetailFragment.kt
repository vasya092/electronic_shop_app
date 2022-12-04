package com.example.electronicshop.ui

import android.content.res.ColorStateList
import android.graphics.BlendMode
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.DrawableCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.electronicshop.BaseApplication
import com.example.electronicshop.MainActivity
import com.example.electronicshop.R
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
            binding?.apply {
                productDetailTitle.text = it.title
                titleAdvantagesCpu.text = it.CPU
                titleAdvantagesCamera.text = it.camera
                titleAdvantagesSsd.text = it.ssd
                titleAdvantagesHdd.text = it.sd

                if(it.isFavorites) {
                    productDetailLike.setImageResource(R.drawable.ic_like_solid)
                }

                selectColorFirst.backgroundTintList = ColorStateList.valueOf(Color.parseColor(it.color[0]))
                selectColorSecond.backgroundTintList = ColorStateList.valueOf(Color.parseColor(it.color[1]))

                selectMemoryFirst.text = resources.getString(R.string.select_memory_text_constructor, it.capacity[0])
                selectMemorySecond.text = resources.getString(R.string.select_memory_text_constructor, it.capacity[1])

                productDetailRating.rating = it.rating.toFloat()

                val adapter = CarouselAdapter(viewModel.productDetail.value?.images)
                carousel.setAdapter(adapter)
                carousel.refresh()

                addToCartButton.setOnClickListener{
                    findNavController().navigate(R.id.action_detailFragment_to_cartFragment)
                }
            }
        }
    }
}