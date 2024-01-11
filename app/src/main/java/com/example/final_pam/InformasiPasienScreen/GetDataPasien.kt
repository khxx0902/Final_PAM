package com.example.final_pam.InformasiPasienScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
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
import androidx.compose.ui.text.input.KeyboardType
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
                Button(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .width(100.dp),
                    onClick = {
                        pasienViewModel.retrieveData(
                            idPasien = idPasien,
                            context = context
                        ) { data ->
                            nmPasien = data.nmPasien
                            umrPasien = data.umrPasien
                            keluhan = data.keluhan
                            tglkonsultasi = data.tglkonsultasi
                        }
                    }
                ) {
                    Text(text = "Get Data")
                }
            }
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = nmPasien,
                onValueChange = {
                    nmPasien = it
                },
                label = {
                    Text(text = "Nama Pasien")
                }
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = umrPasien,
                onValueChange = {
                    umrPasien = it
                    if (umrPasien.isNotEmpty()) {
                        umrPasien = umrPasien.toInt().toString()
                    }
                },
                label = {
                    Text(text = "Umur Pasien")
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = keluhan,
                onValueChange = {
                    keluhan = it
                },
                label = {
                    Text(text = "Keluhan Yang DiAlami")
                }
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = tglkonsultasi,
                onValueChange = {
                    tglkonsultasi = it
                    // You can perform additional date validation or formatting here if needed
                },
                label = { Text(text = "Tanggal (DD/MM/YYYY)")
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }
            }
        }
    }
