package com.example.electronicshop.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.electronicshop.data.ProductsRepository
import com.example.electronicshop.data.ShopApiStatus
import com.example.electronicshop.model.DetailProduct
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailProductViewModel @Inject constructor(private val repository: ProductsRepository) : ViewModel() {

    private val _productDetail = MutableLiveData<DetailProduct>()
    val productDetail:LiveData<DetailProduct> = _productDetail

    private val _status = MutableLiveData<ShopApiStatus>()
    val status: LiveData<ShopApiStatus> = _status

    init {
        getProductDetail()
    }

    private fun getProductDetail() {
        _status.value = ShopApiStatus.LOADING
        viewModelScope.launch {
            try {
                _productDetail.value = repository.getProductDetail()
                _status.value = ShopApiStatus.DONE
            } catch (exception: Exception) {
                val exception = exception.message
                _status.value = ShopApiStatus.ERROR
            }
        }
    }
}