package com.example.final_pam.InformasiPasienScreen.Screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.final_pam.InformasiPasienScreen.DataPasien
import com.example.final_pam.InformasiPasienScreen.PasienViewModel
import com.example.final_pam.ui.theme.Final_PAMTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddDataPasien(
    navController: NavController,
    pasienViewModel: PasienViewModel,
) {
    var idPasien: String by remember { mutableStateOf("") }
    var nmPasien: String by remember { mutableStateOf("") }
    var umrPasien: String by remember { mutableStateOf("") }
    var keluhan: String by remember { mutableStateOf("") }
    var tglkonsultasi: String by remember { mutableStateOf("") }

    val context = LocalContext.current

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                IconButton(
                    onClick = { navController.popBackStack() }
                ) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "back_button")
                }
            }
        }

        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 25.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = idPasien,
                    onValueChange = {
                        idPasien = it
                    },
                    label = {
                        Text(text = "ID Pasien")
                    }
                )
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

        item {
            Button(
                modifier = Modifier
                    .padding(top = 30.dp)
                    .fillMaxWidth(),
                onClick = {
                    val dataPasien = DataPasien(
                        idPasien = idPasien,
                        nmPasien = nmPasien,
                        umrPasien = umrPasien,
                        keluhan = keluhan,
                        tglkonsultasi = tglkonsultasi
                    )

                    pasienViewModel.saveData(dataPasien = dataPasien, context = context)
                }
            ) {
                Text(text = "Save")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAddDataPasien() {
    Final_PAMTheme {
        AddDataPasien(navController = rememberNavController(), pasienViewModel = PasienViewModel())
    }
}