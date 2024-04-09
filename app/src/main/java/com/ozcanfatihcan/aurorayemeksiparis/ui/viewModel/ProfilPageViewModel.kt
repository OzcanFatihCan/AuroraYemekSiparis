package com.ozcanfatihcan.aurorayemeksiparis.ui.viewModel

import androidx.lifecycle.ViewModel
import com.ozcanfatihcan.aurorayemeksiparis.data.repo.ProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfilPageViewModel @Inject constructor(var profileRepository: ProfileRepository): ViewModel() {

    fun registerWithEmail(
        email: String,
        customerName: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (Exception) -> Unit
    ) {
        profileRepository.registerWithEmail(email, customerName, password, onSuccess, onFailure)
    }

    
    fun signInWithEmail(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (Exception) -> Unit
    ) {
        profileRepository.signInWithEmail(email, password, onSuccess, onFailure)
    }
}