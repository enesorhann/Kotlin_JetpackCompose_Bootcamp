package com.enesorhan.genomflix.uix.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enesorhan.genomflix.data.entity.Movies
import com.enesorhan.genomflix.data.entity.retro_entity.Filmler_Retrofit
import com.skydoves.landscapist.glide.GlideImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsPage(inputMovie: Filmler_Retrofit){
   // val movieList = remember { mutableStateListOf<Filmler_Retrofit>() }



    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = inputMovie.ad!!)
                }
            )
        }
    ) {paddingValues ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val url = "http://kasimadalan.pe.hu/filmler_yeni/resimler/${inputMovie.resim}"
            GlideImage(imageModel = url, modifier = Modifier.size(200.dp,300.dp))

            Text(text = "${inputMovie.fiyat} ₺", fontSize = 34.sp)
        }
    }
}