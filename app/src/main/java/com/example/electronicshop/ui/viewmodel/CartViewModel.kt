package com.example.electronicshop.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.electronicshop.data.ProductsRepository
import com.example.electronicshop.data.ShopApiStatus
import com.example.electronicshop.model.CartData
import kotlinx.coroutines.launch
import javax.inject.Inject

class CartViewModel @Inject constructor(private val repository: ProductsRepository): ViewModel() {
    private val _cartData = MutableLiveData<CartData>()
    val cartData: LiveData<CartData> = _cartData

    private val _status = MutableLiveData<ShopApiStatus>()
    val status: LiveData<ShopApiStatus> = _status

    init {
        getCartData()
    }

    private fun getCartData() {
        _status.value = ShopApiStatus.LOADING
        viewModelScope.launch {
            try {
                _cartData.value = repository.getCart()
                _status.value = ShopApiStatus.DONE
            } catch (exception: Exception) {
                _status.value = ShopApiStatus.ERROR
            }
        }
    }
}