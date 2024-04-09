package com.ozcanfatihcan.aurorayemeksiparis.data.datasource

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.ozcanfatihcan.aurorayemeksiparis.data.entity.Profile

class ProfileDataSource(var collectionReference:FirebaseFirestore,var authReference:FirebaseAuth) {
    private fun provideCollection(collectionName:String):CollectionReference = collectionReference.collection(collectionName)

    fun registerWithEmail(
        email: String,
        customerName: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (Exception) -> Unit
    ) {
        authReference.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener { authResult ->
                // Kayıt başarılı olduğunda kullanıcıyı Firestore'a da kaydet
                val user = authResult.user
                user?.let { createUserDocument(it, customerName, email) }
                onSuccess.invoke()
            }
            .addOnFailureListener { e ->
                onFailure.invoke(e)
            }
    }

    // Email ve şifre ile giriş yapma
    fun signInWithEmail(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (Exception) -> Unit
    ) {
        authReference.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                onSuccess.invoke()
            }
            .addOnFailureListener { e ->
                onFailure.invoke(e)
            }
    }

    // Firestore'da yeni kullanıcı dokümanı oluşturma
    private fun createUserDocument(user: FirebaseUser,customerName:String, email: String) {
        val customerCollectionRef=provideCollection("Musteriler")
        val profile = Profile(user.uid, customerName, email)

        customerCollectionRef.document(user.uid)
            .set(profile, SetOptions.merge())
            .addOnSuccessListener {
                Log.d("ProfileDataSource", "Müşteri Firestore'a kaydedildi.")
            }
            .addOnFailureListener { e ->
                Log.e("ProfileDataSource", "Firestore'a müşteri kaydı başarısız oldu: $e")
            }
    }
}