package com.example.final_pam.KonsultasiPasien

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch

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
                    val dataKonsultasi = doc.toObject(DataKonsultasi::class.java)
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
    fun retrieveData(
        idPasien: String,
        context: Context,
        data: (DataKonsultasi) -> Unit
    ) = CoroutineScope(Dispatchers.IO).launch {

        val fireStoreRef = Firebase.firestore
            .collection("konsultasi")
            .document(idPasien)

        try {
            fireStoreRef.get()
                .addOnSuccessListener {
                    // for getting single or particular document
                    if (it.exists()) {
                        val dataKonsultasi = it.toObject<DataKonsultasi>()!!
                        data(dataKonsultasi)
                    } else {
                        Toast.makeText(context, "No User Data Found", Toast.LENGTH_SHORT).show()
                    }
                }
        } catch (e: Exception) {
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }
    }
    fun deleteData(
        idPasien: String,
        context: Context,
        navController: NavController,
    ) = CoroutineScope(Dispatchers.IO).launch {

        val fireStoreRef = Firebase.firestore
            .collection("konsultasi")
            .document(idPasien)

        try {
            fireStoreRef.delete()
                .addOnSuccessListener {
                    Toast.makeText(context, "Successfully deleted data", Toast.LENGTH_SHORT)
                        .show()
                    navController.popBackStack()
                }
        } catch (e: Exception) {
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }
    }
}