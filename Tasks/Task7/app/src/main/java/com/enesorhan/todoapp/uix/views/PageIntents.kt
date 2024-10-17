package com.enesorhan.todoapp.uix.views

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.enesorhan.todoapp.data.entity.ToDo
import com.enesorhan.todoapp.uix.viewModels.DetailsViewModels
import com.enesorhan.todoapp.uix.viewModels.MainViewModels
import com.enesorhan.todoapp.uix.viewModels.SaveViewModels
import com.google.gson.Gson

@Composable
fun PageIntents(mainViewModels: MainViewModels,saveViewModels: SaveViewModels,detailsViewModels: DetailsViewModels){

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "mainpage") {
        composable("mainpage"){
            MainPage(navController,mainViewModels)
        }
        composable("savepage"){
            SavePage(navController,saveViewModels)
        }
        composable("detailspage/{todo}",
            arguments = listOf(
                navArgument("todo"){type= NavType.StringType}
            )
        ){
            val json = it.arguments?.getString("todo")
            val obj = Gson().fromJson(json,ToDo::class.java)
            DetailsPage(navController,obj,detailsViewModels)
        }
    }

}