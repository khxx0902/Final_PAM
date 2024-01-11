package com.example.final_pam.InformasiPasienScreen

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch

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
        awaitClose {
            subscription.remove()
        }
    }
    fun saveData(
        dataPasien: DataPasien,
        context: Context
    )    = CoroutineScope(Dispatchers.IO).launch {
        val fireStoreRef = Firebase.firestore
            .collection("pasien")
            .document(dataPasien.idPasien)

        try{
            fireStoreRef.set(dataPasien)
                .addOnSuccessListener {
                    Toast.makeText(context, "Succsesfully saved data", Toast.LENGTH_LONG).show()
                }
        } catch (e: Exception){
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }
    }
}