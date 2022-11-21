package com.example.electronicshop.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.electronicshop.data.ProductsRepository
import com.example.electronicshop.data.ShopApiStatus
import com.example.electronicshop.model.BestSellerProduct
import com.example.electronicshop.model.HomeProduct
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeFragmentViewModel @Inject constructor(private val productsRepository: ProductsRepository): ViewModel() {

    private val _status = MutableLiveData<ShopApiStatus>()
    val status: LiveData<ShopApiStatus> = _status

    private val _homeProducts = MutableLiveData<List<HomeProduct>>()
    val homeProducts: LiveData<List<HomeProduct>> = _homeProducts

    private val _bestSellerProducts = MutableLiveData<List<BestSellerProduct>>()
    val bestSellerProducts: LiveData<List<BestSellerProduct>> = _bestSellerProducts

    init {
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.launch {
            _status.value = ShopApiStatus.LOADING
            try {
                val allProducts = productsRepository.getAllProducts()
                _homeProducts.value = allProducts.home_store
                _bestSellerProducts.value = allProducts.best_seller
                _status.value = ShopApiStatus.DONE
            } catch (e: Exception) {
                _status.value = ShopApiStatus.ERROR
            }
        }
    }
}