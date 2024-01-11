package com.example.final_pam.Navigasi

sealed class Screens(val route: String) {
    object PasienScreen: Screens(route = "pasien_screen")
    object GetDataPasienScreen: Screens(route = "get_data_Pasien_screen")
    object AddDataPasienScreen: Screens(route = "add_data_pasien_screen")
    object AuthenticationScreen : Screens(route = "auth_screen") // Tambahkan opsi untuk AuthScreen
    object HomeScreen: Screens(route = "home_screen")
    object informrealscreen: Screens(route = "inform_real")

}