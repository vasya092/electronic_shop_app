package com.example.electronicshop.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.electronicshop.data.ProductsRepository
import com.example.electronicshop.data.ProductsRepostoryImpl
import com.example.electronicshop.data.network.ProductsListResponse
import com.example.electronicshop.data.network.ShopApi
import kotlinx.coroutines.launch
import javax.inject.Inject

enum class ShopApiStatus {LOADING, ERROR, DONE}

class HomeFragmentViewModel @Inject constructor(private val productsRepository: ProductsRepository): ViewModel() {

    private val _status = MutableLiveData<ShopApiStatus>()
    val status: LiveData<ShopApiStatus> = _status

    private val _products = MutableLiveData<ProductsListResponse>()
    val products: LiveData<ProductsListResponse> = _products

    val info_text: String = "Info"

    init {
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.launch {
            _status.value = ShopApiStatus.LOADING
            try {
                _products.value = productsRepository.getAllProducts()
                _status.value = ShopApiStatus.DONE
            } catch (e: Exception) {
                _status.value = ShopApiStatus.ERROR
            }
        }
    }
}