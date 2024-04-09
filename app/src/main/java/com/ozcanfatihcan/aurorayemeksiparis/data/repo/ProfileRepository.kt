package com.ozcanfatihcan.aurorayemeksiparis.data.repo

import com.ozcanfatihcan.aurorayemeksiparis.data.datasource.ProfileDataSource

class ProfileRepository(var profileDataSource: ProfileDataSource) {

    fun registerWithEmail(email: String,
                          customerName: String,
                          password: String,
                          onSuccess: () -> Unit,
                          onFailure: (Exception) -> Unit)=profileDataSource.registerWithEmail(email,customerName,password,onSuccess,onFailure)
    fun signInWithEmail(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (Exception) -> Unit
    )=profileDataSource.signInWithEmail(email,password,onSuccess,onFailure)
}