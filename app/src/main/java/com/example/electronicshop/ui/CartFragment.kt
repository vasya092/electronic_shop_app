package com.example.electronicshop.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.electronicshop.BaseApplication
import com.example.electronicshop.databinding.FragmentCartBinding
import com.example.electronicshop.ui.adapter.CartListDelegateAdapter
import com.example.electronicshop.ui.viewmodel.CartViewModel
import com.livermor.delegateadapter.delegate.CompositeDelegateAdapter
import javax.inject.Inject

class CartFragment: Fragment() {

    private var binding: FragmentCartBinding? = null
    @Inject
    lateinit var viewModel: CartViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity?.application as BaseApplication).appComponent.inject(this)
        binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cartItemsAdapter = CompositeDelegateAdapter(
            CartListDelegateAdapter()
        )

        viewModel.cartData.observe(viewLifecycleOwner) {

            cartItemsAdapter.swapData(it.basket)
            binding?.apply {
                deliveryValue.text = it.delivery
                totalValue.text = it.total.toString()
                 listItemRecycler.adapter = cartItemsAdapter
            }
        }
    }
}