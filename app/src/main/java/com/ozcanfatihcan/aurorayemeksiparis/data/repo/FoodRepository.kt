package com.ozcanfatihcan.aurorayemeksiparis.data.repo

import com.ozcanfatihcan.aurorayemeksiparis.data.datasource.FoodDataSource
import com.ozcanfatihcan.aurorayemeksiparis.data.entity.Food

class FoodRepository(var foodDataSource: FoodDataSource) {

    suspend fun getFood():List<Food> = foodDataSource.getFood()

    suspend fun searchFood(searchWord:String):List<Food> =foodDataSource.searchFood(searchWord)

}