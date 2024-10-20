package com.enesorhan.contactsapp.uix.views

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.enesorhan.contactsapp.data.entity.retrofit_entity.Retro_Persons
import com.enesorhan.contactsapp.uix.viewModel.AnasayfaViewModel
import com.enesorhan.contactsapp.uix.viewModel.DetaySayfaViewModel
import com.enesorhan.contactsapp.uix.viewModel.KayitSayfaViewModel
import com.google.gson.Gson

@Composable
fun PageIntent(anasayfaViewModel: AnasayfaViewModel,detaySayfaViewModel: DetaySayfaViewModel,kayitSayfaViewModel: KayitSayfaViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "mainpage") {
        composable("mainpage"){
            MainPage(navController,anasayfaViewModel)
        }
        composable("savepage"){
            SavePage(navController,kayitSayfaViewModel)
        }
        composable("detailspage/{inputPerson}",
            arguments = listOf(
                navArgument("inputPerson"){type= NavType.StringType}
            )
        ){
            val json = it.arguments?.getString("inputPerson")
            val obj = Gson().fromJson(json, Retro_Persons::class.java)
            DetailsPage(navController, inputPerson = obj,detaySayfaViewModel)
        }
    }
}