package com.ozcanfatihcan.aurorayemeksiparis.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ozcanfatihcan.aurorayemeksiparis.data.entity.ShopCartFood
import com.ozcanfatihcan.aurorayemeksiparis.data.repo.ShopCartRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ShoppingCartPageViewModel@Inject constructor (var shopCartRepository: ShopCartRepository): ViewModel() {
    val shoppingList=MutableLiveData<List<ShopCartFood>>()
    init {

    }
}