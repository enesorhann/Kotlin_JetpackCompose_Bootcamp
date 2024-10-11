package com.enesorhan.task4_compose_bootcamp.pages

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.enesorhan.task4_compose_bootcamp.MainPage

@Composable
fun SayfaGecisleri(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "anasayfa") {

        composable("anasayfa"){
            MainPage(navController)
        }
        composable("pageA"){
            PageA(navController)
        }
        composable("pageB"){
            PageB(navController)
        }

        composable("pageX"){
            PageX(navController)
        }
        composable("pageY"){
            PageY()
        }

    }
}