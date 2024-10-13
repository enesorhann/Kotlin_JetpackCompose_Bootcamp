package com.enesorhan.sahibindenui.uix.views

import DescriptionPage
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.enesorhan.sahibindenui.data.entity.Cars
import com.google.gson.Gson


@Composable
fun PageIntent(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "mainpage") {
        composable("mainpage"){
            MainPage(navController)
        }
        composable("savepage"){
            SavePage()
        }
        composable("locatepage"){
            LocationPage()
        }
        composable("descpage/{car}",
            arguments = listOf(navArgument("car"){type= NavType.StringType}
            )
        ){
            val json = it.arguments?.getString("car")
            val obj = Gson().fromJson(json,Cars::class.java)
            DescriptionPage(car = obj)
        }
        composable("detailspage/{car}",
            arguments = listOf(navArgument("car"){type= NavType.StringType}
            )
        ){
            val json = it.arguments?.getString("car")
            val obj = Gson().fromJson(json,Cars::class.java)
            DetailsPage(navController,obj)
        }
    }
}