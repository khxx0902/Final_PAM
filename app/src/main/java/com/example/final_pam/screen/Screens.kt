package com.example.final_pam.screen

sealed class Screens(val route: String) {
    object PasienScreen: Screens(route = "motor_screen")
    object GetDataPasienScreen: Screens(route = "get_data_Motor_screen")
    object AddDataPasienScreen: Screens(route = "add_data_motor_screen")

}