package com.example.final_pam.InformasiPasienScreen

import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.flow.callbackFlow

class PasienViewModel(): ViewModel() {

    fun getAllData(): kotlinx.coroutines.flow.Flow<List<DataPasien>> = callbackFlow {
        val fireStoreRef = Firebase.firestore.collection("pasien")
    }
}