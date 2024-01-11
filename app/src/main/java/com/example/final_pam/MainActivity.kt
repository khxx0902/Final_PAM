package com.example.final_pam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.final_pam.HomePage.HomeViewModel
import com.example.final_pam.InformasiPasienScreen.PasienViewModel
import com.example.final_pam.KonsultasiPasien.KonsultasiViewModel
import com.example.final_pam.Navigasi.NavigasiHalaman
import com.example.final_pam.tampilan.AuthViewModel
import com.example.final_pam.tampilan.AuthenticationScreen
import com.example.final_pam.ui.theme.Final_PAMTheme
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class MainActivity : ComponentActivity() {

    val db = Firebase.firestore
    private lateinit var navController: NavHostController
    private val pasienViewModel: PasienViewModel by viewModels()
    private val konsultasiViewModel: KonsultasiViewModel by viewModels()
    private val authViewModel: AuthViewModel by viewModels()
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Final_PAMTheme {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    navController = rememberNavController()
                    NavigasiHalaman(
                        navController = navController,
                        pasienViewModel = pasienViewModel,
                        konsultasiViewModel = konsultasiViewModel,
                        authViewModel = authViewModel,
                        homeViewModel = homeViewModel,

                        )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Final_PAMTheme {
        Greeting("Android")
    }
}