package com.example.final_pam.InformasiPasienScreen

import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.flow.callbackFlow

class PasienViewModel(): ViewModel() {

    fun getAllData(): kotlinx.coroutines.flow.Flow<List<DataPasien>> = callbackFlow {
        val fireStoreRef = Firebase.firestore.collection("pasien")

        val subscription = fireStoreRef.addSnapshotListener { value, error ->
            if (error != null) {
                close(error)
                return@addSnapshotListener
            }
            if (value != null) {
                val dataList = mutableListOf<DataPasien>()
                for (doc in value.documents) {
                    val dataPasien = doc.toObject(DataPasien::class.java)
                    if (dataPasien != null) {
                        dataList.add(dataPasien)
                    }
                }
                trySend(dataList)
            }
        }
    }
}