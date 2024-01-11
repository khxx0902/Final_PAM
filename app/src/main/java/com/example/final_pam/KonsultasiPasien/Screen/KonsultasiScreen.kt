package com.example.final_pam.KonsultasiPasien.Screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.final_pam.KonsultasiPasien.KonsultasiViewModel
import com.example.final_pam.Navigasi.Screens

@Composable
fun KonsultasiScreen(
    navController: NavController,
    konsultasiViewModel: KonsultasiViewModel = viewModel()
) {
    val allDataState by konsultasiViewModel.getAllData().collectAsState(initial = emptyList())

    LazyColumn(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        item {
            Text(
                text = "Data Konsultasi",
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
        items(allDataState) { konsultasiData ->
            KonsultasiListItem(sewaData = konsultasiData)
        }

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                IconButton(
                    onClick = { navController.navigateUp() }
                ) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
                }

                OutlinedButton(
                    onClick = {navController.navigate(route = Screens.AddDataKonsultasiScreen.route) },
                ) {
                    Text(text = "Add Data Konsultasi")
                }

                OutlinedButton(
                    onClick = {navController.navigate(route = Screens.GetDataKonsultasiScreen.route)},
                ) {
                    Text(text = "Get Data Konsultasi")
                }
    }
}

@Composable
fun KonsultasiListItem(sewaData: Int) {

}
