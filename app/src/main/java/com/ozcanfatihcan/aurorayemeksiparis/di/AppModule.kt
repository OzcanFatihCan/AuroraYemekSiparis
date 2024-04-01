package com.ozcanfatihcan.aurorayemeksiparis.di

import com.ozcanfatihcan.aurorayemeksiparis.data.datasource.FoodDataSource
import com.ozcanfatihcan.aurorayemeksiparis.data.datasource.ShopCartDataSource
import com.ozcanfatihcan.aurorayemeksiparis.data.repo.FoodRepository
import com.ozcanfatihcan.aurorayemeksiparis.data.repo.ShopCartRepository
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
    fun provideFoodDataSource():FoodDataSource{
        return FoodDataSource()
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