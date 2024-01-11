package com.example.final_pam.Navigasi

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.final_pam.InformasiPasienScreen.PasienViewModel
import com.example.final_pam.InformasiPasienScreen.Screen.GetDataPasienScreen
import com.example.final_pam.KonsultasiPasien.KonsultasiViewModel
import com.example.final_pam.KonsultasiPasien.Screen.GetDataKonsultasiScreen
import com.example.final_pam.KonsultasiPasien.Screen.KonsultasiScreen
import com.example.final_pam.tampilan.AuthViewModel
import com.example.final_pam.tampilan.AuthenticationScreen
import androidx.navigation.compose.composable
import com.example.final_pam.InformasiPasienScreen.Screen.AddDataPasien
import com.example.final_pam.InformasiPasienScreen.Screen.PasienScreen
import com.example.final_pam.KonsultasiPasien.Screen.AddDataKonsultasiScreen

@Composable
fun NavigasiHalaman(
    navController: NavHostController,
    authViewModel: AuthViewModel,
    pasienViewModel: PasienViewModel,
    konsultasiViewModel: KonsultasiViewModel

) {
    NavHost(
        navController = navController,
        startDestination = Screens.AuthenticationScreen.route
    ) {
        composable(
            route = Screens.AuthenticationScreen.route
        ) {
            AuthenticationScreen(
                navController = navController,
                authViewModel = authViewModel
            )
        }
        composable(
            route = Screens.PasienScreen.route
        ) {
            PasienScreen(
                navController = navController,
                pasienViewModel = pasienViewModel
            )
        }
        composable(
            route = Screens.AddDataPasienScreen.route
        ) {
            AddDataPasien(
                navController = navController, pasienViewModel = pasienViewModel
            )
        }
        composable(
            route = Screens.GetDataPasienScreen.route
        ) {
            GetDataPasienScreen(
                navController = navController, pasienViewModel = pasienViewModel
            )
        }

        composable(
            route = Screens.KonsultasiScreen.route
        ) {
            KonsultasiScreen(
                navController = navController, konsultasiViewModel = konsultasiViewModel
            )
        }
        composable(
            route = Screens.AddDataKonsultasiScreen.route
        ) {
            AddDataKonsultasiScreen(
                navController = navController, konsultasiViewModel = konsultasiViewModel
            )
        }
        composable(
            route = Screens.AddDataPasienScreen.route
        ) {
            GetDataKonsultasiScreen(
                navController = navController, konsultasiViewModel = konsultasiViewModel
            )
        }
    }
}