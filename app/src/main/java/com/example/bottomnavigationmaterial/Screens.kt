package com.example.bottomnavigationmaterial

sealed class Screens(val screen: String){
    data object Home: Screens("home")
    data object Short: Screens("short")
    data object Subscribe: Screens("subscribe")
    data object Library: Screens("Library")
    data object Post: Screens("post")
    data object Share: Screens("share")
    data object Setting: Screens("setting")

    data object AboutUs: Screens("About Us")

    data object Logout: Screens("Logout")
}