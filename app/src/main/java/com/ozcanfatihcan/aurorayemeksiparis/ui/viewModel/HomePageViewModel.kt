package com.ozcanfatihcan.aurorayemeksiparis.ui.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ozcanfatihcan.aurorayemeksiparis.data.entity.Food
import com.ozcanfatihcan.aurorayemeksiparis.data.repo.FoodRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomePageViewModel @Inject constructor (var foodRepository: FoodRepository): ViewModel() {
    val foodList=MutableLiveData<List<Food>>()

    init {
        getFood()
    }
    fun getFood(){
        CoroutineScope(Dispatchers.Main).launch {
            try {
                foodList.value=foodRepository.getFood()
            }catch (e:Exception){
                Log.e("getFoodError",e.toString())
            }
        }
    }

}