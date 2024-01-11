package com.example.final_pam.InformasiPasienScreen.Screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.final_pam.InformasiPasienScreen.DataPasien
import com.example.final_pam.InformasiPasienScreen.PasienViewModel
import com.example.final_pam.Navigasi.Screens
import com.example.final_pam.R
import com.example.final_pam.ui.theme.Final_PAMTheme

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PasienScreen(
    navController: NavController,
    pasienViewModel: PasienViewModel = viewModel()
){
    val allDataState by pasienViewModel.getAllData().collectAsState(initial = emptyList())

    LazyColumn(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        item {
            Text(
                text = "Konseling UMY",
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        item {
            val image = painterResource(id = R.drawable.mentall)
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.SpaceBetween
            )
            {
                OutlinedCard(
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface,
                    ),
                    border = BorderStroke(1.dp, Color.Black), modifier = Modifier
                        .fillMaxWidth(0.95f)
                        .padding(vertical = 50.dp)
                        .align(Alignment.CenterHorizontally)
                )
                {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                    ) {
                        Image(
                            painter = image,
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                        Text(
                            text = "Layanan Konseling",
                            color = Color.DarkGray,
                            fontFamily = FontFamily.Cursive,
                            fontSize = 35.sp,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                        )
                        Text(
                            text = "UMY",
                            color = Color.DarkGray,
                            fontFamily = FontFamily.Cursive,
                            fontStyle = FontStyle.Italic,
                            fontSize = 60.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
        item {
            Text(
                text = "Pasien Data",
                style = androidx.compose.ui.text.TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
        items(allDataState) { pasienData ->
            PasienListItem(pasienData = DataPasien())
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
                    onClick = {  navController.navigate(route = Screens.AddDataPasienScreen.route) },
                ) {
                    Text(text = "Add Data Pasien")
                }
                OutlinedButton(
                    onClick = { navController.navigate(route = Screens.GetDataPasienScreen.route) },
                ) {
                    Text(text = "Get Data Pasien")
                }
            }
        }
    }
}

@Composable
fun PasienListItem(pasienData: DataPasien) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color.Gray)
            .padding(8.dp)
    ) {
        Column {
            Text(text = "ID Pasien: ${pasienData.idPasien}", fontSize = 16.sp)
            Text(text = "Nama Pasien: ${pasienData.nmPasien}")
            Text(text = "Umur Pasien: ${pasienData.umrPasien}")
            Text(text = "Keluhan: ${pasienData.keluhan}")
            Text(text = "Tanggal Konsultasi: ${pasienData.tglkonsultasi}")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewPasienScreen() {
    Final_PAMTheme {
        PasienScreen(navController = rememberNavController(), pasienViewModel = PasienViewModel())
    }
}
