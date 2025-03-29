package com.gonzapolleria.promosapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gonzapolleria.promosapp.features.home.HomeScreen
import com.gonzapolleria.promosapp.features.initconfigs.domain.usecases.GetConfigFlow_UseCase
import com.gonzapolleria.promosapp.features.initconfigs.domain.usecases.GetConfigSuspend_UseCase
import com.gonzapolleria.promosapp.features.initconfigs.domain.usecases.GetFirstConfig_UseCase
import com.gonzapolleria.promosapp.features.login.LoginScreen
import com.gonzapolleria.promosapp.features.onboarding.OnboardingScreen
import com.gonzapolleria.promosapp.features.onboarding.OnboardingUtils
import com.gonzapolleria.promosapp.features.pushnotifications.PushScreen
import com.gonzapolleria.promosapp.shared.room.entities.ConfigEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import org.koin.compose.koinInject


@Composable
fun NavigationWrapper() {
    val mainNavController = rememberNavController()
    val initialRoute = if (OnboardingUtils.isOnboardingCompleted()) Routes.Login.route else Routes.Onboarding.route

    /**************************************************************************************************************/
    // GetConfigFlow_UseCase Usa Flows en vez de suspend
    /*val getConfigFlow_UseCase: GetConfigFlow_UseCase = koinInject()
    val configFlow: Flow<List<ConfigEntity>> = getConfigFlow_UseCase.invoke().map{ configEntities ->
        configEntities.map { it.toEntityRoom() }
    }
    val collectConfigFlow by configFlow.collectAsStateWithLifecycle(emptyList())
    val firstConfigRoom: ConfigEntity? = collectConfigFlow.firstOrNull()*/
    /**************************************************************************************************************/

    /**************************************************************************************************************/
    // GetConfigSuspend_UseCase
    val scope = rememberCoroutineScope()
    val getConfigSuspend_UseCase: GetConfigSuspend_UseCase = koinInject()
    val firstConfigRoom = remember { mutableStateOf<ConfigEntity>(ConfigEntity()) }
    scope.launch {
        val configList: List<ConfigEntity>? = getConfigSuspend_UseCase.invoke()?.map{
            it.toEntityRoom()
        }
        firstConfigRoom.value = configList?.firstOrNull() ?: ConfigEntity()
    }

    /**************************************************************************************************************/


    NavHost(navController = mainNavController, startDestination = initialRoute) {

        composable(route = Routes.Push.route) {
            PushScreen()
        }

        composable(route = Routes.Home.route) {
            HomeScreen(){
                mainNavController.navigate(Routes.Login.route){
                    popUpTo(Routes.Home.route) {
                        inclusive = true
                    }
                }
            }
        }

        composable(route = Routes.Login.route) {
            LoginScreen(firstConfigRoom.value){
                mainNavController.navigate(Routes.Home.route){
                    popUpTo(Routes.Login.route) {
                        inclusive = true
                    }
                }
            }
        }

        composable(route = Routes.Onboarding.route) {
            OnboardingScreen {
                OnboardingUtils.setOnboardingCompleted()
                mainNavController.navigate(Routes.Login.route) {
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