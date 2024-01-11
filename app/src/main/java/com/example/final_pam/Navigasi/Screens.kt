package com.example.final_pam.Navigasi

sealed class Screens(val route: String) {
    object PasienScreen: Screens(route = "pasien_screen")
    object GetDataPasienScreen: Screens(route = "get_data_Pasien_screen")
    object AddDataPasienScreen: Screens(route = "add_data_pasien_screen")
    object AuthenticationScreen : Screens(route = "auth_screen") // Tambahkan opsi untuk AuthScreen
    object KonsultasiScreen: Screens(route = "konsultasi_screen")
    object GetDataKonsultasiScreen: Screens(route = "get_data_Konsultasi_screen")
    object AddDataKonsultasiScreen: Screens(route = "add_data_Konsultasi_screen")
    object HomeScreen: Screens(route = "home_screen")

}