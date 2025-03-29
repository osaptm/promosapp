package com.gonzapolleria.promosapp.navigation


import kotlinx.serialization.Serializable


sealed class Routes(val route:String){
    data object Onboarding: Routes(route = "onboarding")
    data object Home: Routes(route = "home")
    data object Login: Routes(route = "login")
    data object Push: Routes(route = "pushnotification")
    data object Ruleta: Routes(route = "ruleta")
}

@Serializable
data class MovieDetail(val movieDetail: String)