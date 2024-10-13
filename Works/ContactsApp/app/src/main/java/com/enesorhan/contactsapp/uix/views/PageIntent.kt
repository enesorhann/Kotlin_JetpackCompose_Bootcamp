package com.enesorhan.contactsapp.uix.views

import androidx.compose.runtime.Composable
import androidx.navigation.NavArgs
import androidx.navigation.NavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.enesorhan.contactsapp.data.entity.Persons
import com.google.gson.Gson

@Composable
fun PageIntent(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "mainpage") {
        composable("mainpage"){
            MainPage(navController)
        }
        composable("savepage"){
            SavePage(navController)
        }
        composable("detailspage/{inputPerson}",
            arguments = listOf(
                navArgument("inputPerson"){type= NavType.StringType}
            )
        ){
            val json = it.arguments?.getString("inputPerson")
            val obj = Gson().fromJson(json,Persons::class.java)
            DetailsPage(navController,inputPerson = obj)
        }
    }
}