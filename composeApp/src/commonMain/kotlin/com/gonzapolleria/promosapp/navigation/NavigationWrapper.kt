package com.gonzapolleria.promosapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gonzapolleria.promosapp.login.LoginScreen
import com.gonzapolleria.promosapp.onboarding.OnboardingScreen
import com.gonzapolleria.promosapp.onboarding.OnboardingUtils


@Composable
fun NavigationWrapper() {
    val mainNavController = rememberNavController()
    val initialRoute = if (OnboardingUtils.isOnboardingCompleted()) Routes.Home.route else Routes.Onboarding.route

    NavHost(navController = mainNavController, startDestination = initialRoute) {

        composable(route = Routes.Home.route) {
            LoginScreen()
        }

        composable(route = Routes.Onboarding.route) {
            OnboardingScreen {
                OnboardingUtils.setOnboardingCompleted()
                mainNavController.navigate(Routes.Home.route) {
                    popUpTo(Routes.Onboarding.route) {
                        inclusive = true
                    }
                }
            }
        }

       /* composable(route = Routes.Onboarding.route) {
            OnboardingScreen {
                OnboardingUtils.setOnboardingCompleted()
                mainNavController.navigate(Routes.Push.route){
                    popUpTo(Routes.Onboarding.route) {
                        inclusive = true
                    }
                }
            }
        }*/

        /*composable(route = Routes.Home.route) {
            MovieScreen(
                viewModel = koinViewModel(),
                mainNavController
            )
        }

        composable(route = Routes.Login.route) {
            LoginScreen()
        }

        composable(route = Routes.Push.route) {
            PushScreen()
        }

        composable(route = Routes.Ruleta.route) {
            RuletaScreen()
        }*/

        /*composable<MovieDetail> { navBackStackEntry ->
            val characterDetailEncoding: MovieDetail =
                navBackStackEntry.toRoute<MovieDetail>()

            val movieDom: MovieDom =
                Json.decodeFromString<MovieDom>(characterDetailEncoding.movieDetail)

            ScreenPrueba(
                movieDom = movieDom,
                onBackPressed = { mainNavController.popBackStack() })
        }*/


    }

}