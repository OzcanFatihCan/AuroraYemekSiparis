package com.ozcanfatihcan.aurorayemeksiparis.di

import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import com.ozcanfatihcan.aurorayemeksiparis.data.datasource.FoodDataSource
import com.ozcanfatihcan.aurorayemeksiparis.data.datasource.ProfileDataSource
import com.ozcanfatihcan.aurorayemeksiparis.data.datasource.ShopCartDataSource
import com.ozcanfatihcan.aurorayemeksiparis.data.repo.FoodRepository
import com.ozcanfatihcan.aurorayemeksiparis.data.repo.ProfileRepository
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

    @Provides
    @Singleton
    fun provideProfileDataSource(firestoreReference:FirebaseFirestore,authReference:FirebaseAuth):ProfileDataSource{
        return ProfileDataSource(firestoreReference,authReference)
    }

    @Provides
    @Singleton
    fun providefirestoreReference():FirebaseFirestore=FirebaseFirestore.getInstance()

    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun provideProfileRepository(pds:ProfileDataSource):ProfileRepository{
        return ProfileRepository(pds)
    }
}