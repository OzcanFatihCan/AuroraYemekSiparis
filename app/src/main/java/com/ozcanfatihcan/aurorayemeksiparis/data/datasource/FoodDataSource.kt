package com.ozcanfatihcan.aurorayemeksiparis.data.datasource

import com.ozcanfatihcan.aurorayemeksiparis.data.entity.Food
import com.ozcanfatihcan.aurorayemeksiparis.retrofit.FoodDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FoodDataSource(var fDao:FoodDao) {
    suspend fun getFood():List<Food> = withContext(Dispatchers.IO){
        return@withContext fDao.getFood().yemekler
    }
    suspend fun searchFood(searchFood:String):List<Food> = withContext(Dispatchers.IO){
        val foodList=fDao.getFood().yemekler
        val filteredList = mutableListOf<Food>()
        for (food in foodList){
            if (food.yemek_adi.contains(searchFood,ignoreCase = true)){
                filteredList.add(food)
            }else{
                filteredList.add(food)
            }
        }
        return@withContext filteredList
    }

}