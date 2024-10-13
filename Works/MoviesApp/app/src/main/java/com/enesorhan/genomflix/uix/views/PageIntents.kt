package com.enesorhan.genomflix.uix.views

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.enesorhan.genomflix.data.entity.Movies
import com.google.gson.Gson

@Composable
fun PageIntents(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "mainpage") {
        composable("mainpage"){
            MainPage(navController = navController)
        }
        composable("detailspage/{inputMovie}",
            arguments = listOf(navArgument("inputMovie"){type = NavType.StringType}
            )
        ){
            val json = it.arguments?.getString("inputMovie")
            val obj = Gson().fromJson(json,Movies::class.java)
            DetailsPage(obj)
        }
    }
}