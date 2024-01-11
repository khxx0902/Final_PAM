package com.example.final_pam.InformasiPasienScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
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

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .padding(start = 15.dp, top = 15.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            IconButton(
                onClick = { navController.popBackStack() }
            ) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "back_button")
            }
        }
        Column(
            modifier = Modifier
                .padding(start = 60.dp, end = 60.dp, bottom = 50.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(0.6f),
                    value = idPasien,
                    onValueChange = {
                        idPasien = it
                    },
                    label = {
                        Text(text = "ID Pasien")
                    }
                )
            }
        }
    }
}