package com.enesorhan.finalproject.uix.views

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.enesorhan.finalproject.data.entities.Food_Cart
import com.enesorhan.finalproject.data.entities.Meals
import com.enesorhan.finalproject.uix.viewModels.DetailPageViewModel
import com.enesorhan.finalproject.uix.viewModels.MainPageViewModel
import com.enesorhan.finalproject.uix.viewModels.CartPageViewModel
import com.google.gson.Gson

@Composable
fun PageIntents(mainPageViewModel:MainPageViewModel,cartPageViewModel:CartPageViewModel,detailPageViewModel:DetailPageViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "mainpage") {
        composable("mainpage"){
            MainPage(navController = navController, mainPageViewModel = mainPageViewModel)
        }
        composable("detailspage/{food}", arguments =
        listOf(navArgument("food"){type= NavType.StringType} )
        ){
            val json = it.arguments?.getString("food")
            val obj = Gson().fromJson(json,Meals::class.java)
            DetailsPage(navController = navController, meal = obj, detailPageViewModel = detailPageViewModel)
        }
        composable("cartpage",){
            CartPage(navController = navController, cartPageViewModel = cartPageViewModel)
        }
    }
}