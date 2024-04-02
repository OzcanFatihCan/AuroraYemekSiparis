package com.ozcanfatihcan.aurorayemeksiparis.di

import com.ozcanfatihcan.aurorayemeksiparis.data.datasource.FoodDataSource
import com.ozcanfatihcan.aurorayemeksiparis.data.datasource.ShopCartDataSource
import com.ozcanfatihcan.aurorayemeksiparis.data.repo.FoodRepository
import com.ozcanfatihcan.aurorayemeksiparis.data.repo.ShopCartRepository
import com.ozcanfatihcan.aurorayemeksiparis.retrofit.ApiUtils
import com.ozcanfatihcan.aurorayemeksiparis.retrofit.FoodDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideFoodDao():FoodDao{
        return ApiUtils.getFoodDao()
    }

    @Provides
    @Singleton
    fun provideFoodDataSource(fDao:FoodDao):FoodDataSource{
        return FoodDataSource(fDao)
    }
    @Provides
    @Singleton
    fun provideFoodRepository(foodDataSource:FoodDataSource):FoodRepository{
        return FoodRepository(foodDataSource)
    }
    @Provides
    @Singleton
    fun provideShopCartDataSource():ShopCartDataSource{
        return ShopCartDataSource()
    }
    @Provides
    @Singleton
    fun provideShopCartRepository(shopCartDataSource: ShopCartDataSource):ShopCartRepository{
        return ShopCartRepository(shopCartDataSource)
    }
}