package com.example.final_pam.Navigasi

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.final_pam.InformasiPasienScreen.PasienViewModel
import com.example.final_pam.InformasiPasienScreen.Screen.GetDataPasienScreen
import com.example.final_pam.tampilan.AuthViewModel
import androidx.navigation.compose.composable
import com.example.final_pam.HomePage.HomeScreen
import com.example.final_pam.HomePage.HomeViewModel
import com.example.final_pam.InformasiPasienScreen.Screen.AddDataPasien
import com.example.final_pam.InformasiPasienScreen.Screen.PasienScreen
import com.example.final_pam.KonsultasiPasien.InformViewModel
import com.example.final_pam.KonsultasiPasien.screen.informrealscreen
import com.example.final_pam.tampilan.AuthenticationScreen

@Composable
fun NavigasiHalaman(
    navController: NavHostController,
    authViewModel: AuthViewModel,
    pasienViewModel: PasienViewModel,
    homeViewModel: HomeViewModel,
    informViewModel: InformViewModel

) {
    NavHost(
        navController = navController,
        startDestination = Screens.AuthenticationScreen.route
    ) {
        composable(
            route = Screens.HomeScreen.route
        ) {
            HomeScreen(
                navController = navController,
                homeViewModel = homeViewModel
            )
        }
        composable(
            route = Screens.AuthenticationScreen.route
        ) {
            AuthenticationScreen(
                navController = navController,
                authViewModel = authViewModel
            )
        }
        composable(
            route = Screens.informrealscreen.route
        ) {
            informrealscreen (
                navController = navController,
                informViewModel = informViewModel
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
    }
}