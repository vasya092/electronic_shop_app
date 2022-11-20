package com.example.electronicshop.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.electronicshop.BaseApplication
import com.example.electronicshop.R
import com.example.electronicshop.data.local.CategoryItemsData
import com.example.electronicshop.databinding.FragmentHomeBinding
import com.example.electronicshop.ui.adapter.BestSellersSliderAdapter
import com.example.electronicshop.ui.adapter.CategoryMenuSliderAdapter
import com.example.electronicshop.ui.adapter.HotSalesSliderAdapter
import com.example.electronicshop.ui.viewmodel.HomeFragmentViewModel
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    private var binding: FragmentHomeBinding? = null
    @Inject
    lateinit var viewModel: HomeFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        (activity?.application as BaseApplication).appComponent.inject(this)
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = CategoryMenuSliderAdapter(CategoryItemsData.getCategoryItems())
        binding?.categoryMenuSlider?.adapter = adapter

        val hotSalesSliderAdapter = HotSalesSliderAdapter {
        }
        viewModel.homeProducts.observe(viewLifecycleOwner) {
            hotSalesSliderAdapter.submitList(it)
        }
        binding?.hotSalesProductsSlider?.adapter = hotSalesSliderAdapter
        //Слайдинг по типу карусели
        PagerSnapHelper().attachToRecyclerView(binding?.hotSalesProductsSlider)
        var dividerItemDecoration = DividerItemDecoration(binding?.hotSalesProductsSlider?.context, 0)
        binding?.hotSalesProductsSlider?.addItemDecoration(dividerItemDecoration)

        val bestSellersSliderAdapter = BestSellersSliderAdapter()
        viewModel.bestSellerProducts.observe(viewLifecycleOwner) {
            bestSellersSliderAdapter.submitList(it)
        }
        binding?.bestSalesSlider?.layoutManager = GridLayoutManager(context, 2)
        binding?.bestSalesSlider?.adapter = bestSellersSliderAdapter
    }

}