package com.example.final_pam.InformasiPasienScreen

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GetDataPasienScreen(
    navController: NavController,
    pasienViewModel: PasienViewModel,
) {
    var idPasien: String by remember { mutableStateOf("") }
    var nmPasien: String by remember { mutableStateOf("") }
    var umrPasien: String by remember { mutableStateOf("") }
    var keluhan: String by remember { mutableStateOf("") }
    var tglkonsultasi: String by remember { mutableStateOf("") }

    val context = LocalContext.current
}