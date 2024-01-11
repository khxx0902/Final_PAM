package com.example.final_pam.KonsultasiPasien

import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow

class KonsultasiViewModel() : ViewModel() {

    fun getAllData(): kotlinx.coroutines.flow.Flow<List<DataKonsultasi>> = callbackFlow {
        val fireStoreRef = Firebase.firestore.collection("konsultasi")

        val subscription = fireStoreRef.addSnapshotListener { value, error ->
            if (error != null) {
                // Handle error
                close(error)
                return@addSnapshotListener
            }

            if (value != null) {
                val dataList = mutableListOf<DataKonsultasi>()
                for (doc in value.documents) {
                    val dataKonsultasi = doc.toObject(dataKonsultasi::class.java)
                    if (dataKonsultasi != null) {
                        dataList.add(dataKonsultasi)
                    }
                }
                trySend(dataList)
            }
        }

        awaitClose {
            subscription.remove()
        }
    }
    fun saveData(
        dataKonsultasi: DataKonsultasi,
        context: Context
    )= CoroutineScope(Dispatchers.IO).launch {

        val fireStoreRef = Firebase.firestore
            .collection("konsultasi")
            .document(dataKonsultasi.idPasien)

        try {
            fireStoreRef.set(dataKonsultasi)
                .addOnSuccessListener {
                    Toast.makeText(context, "Successfully saved data", Toast.LENGTH_SHORT).show()
                }
        } catch (e: Exception) {
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }
    }
}