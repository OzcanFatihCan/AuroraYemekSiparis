package com.ozcanfatihcan.aurorayemeksiparis.retrofit

import com.ozcanfatihcan.aurorayemeksiparis.data.entity.FoodResponse
import retrofit2.http.GET

interface FoodDao {
    //http://kasimadalan.pe.hu/yemekler/tumYemekleriGetir.php
    @GET("yemekler/tumYemekleriGetir.php")
    suspend fun getFood():FoodResponse
}