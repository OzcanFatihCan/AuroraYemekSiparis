package com.ozcanfatihcan.aurorayemeksiparis.ui.viewModel

import androidx.lifecycle.ViewModel
import com.ozcanfatihcan.aurorayemeksiparis.data.repo.FoodRepository
import com.ozcanfatihcan.aurorayemeksiparis.data.repo.ShopCartRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailPageViewModel @Inject constructor (var foodRepository: FoodRepository,var shopCartRepository: ShopCartRepository): ViewModel() {
}