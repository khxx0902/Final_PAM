package com.example.final_pam.KonsultasiPasien

import androidx.lifecycle.ViewModel
import com.example.final_pam.InformasiPasienScreen.DataPasien
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.flow.callbackFlow

class KonsultasiViewModel() : ViewModel() {

    fun getAllData(): kotlinx.coroutines.flow.Flow<List<DataPasien>> = callbackFlow {
        val fireStoreRef = Firebase.firestore.collection("konsultasi")
    }
}