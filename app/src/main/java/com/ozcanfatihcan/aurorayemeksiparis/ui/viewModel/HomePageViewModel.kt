package com.ozcanfatihcan.aurorayemeksiparis.ui.viewModel

import androidx.lifecycle.ViewModel
import com.ozcanfatihcan.aurorayemeksiparis.data.repo.FoodRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomePageViewModel @Inject constructor (var foodRepository: FoodRepository): ViewModel() {
}