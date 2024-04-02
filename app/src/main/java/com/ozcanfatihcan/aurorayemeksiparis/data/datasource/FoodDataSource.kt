package com.ozcanfatihcan.aurorayemeksiparis.data.datasource

import com.ozcanfatihcan.aurorayemeksiparis.data.entity.Food
import com.ozcanfatihcan.aurorayemeksiparis.retrofit.FoodDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FoodDataSource(var fDao:FoodDao) {
    suspend fun getFood():List<Food> = withContext(Dispatchers.IO){
        return@withContext fDao.getFood().yemekler
    }
}