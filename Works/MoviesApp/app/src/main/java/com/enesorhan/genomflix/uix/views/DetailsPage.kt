package com.enesorhan.genomflix.uix.views

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enesorhan.genomflix.data.entity.Movies
import com.google.gson.Gson
import com.skydoves.landscapist.glide.GlideImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsPage(inputMovie: Movies){
    val movieList = remember { mutableStateListOf<Movies>() }



    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = inputMovie.movie_name)
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
            val activity = LocalContext.current as Activity
            Image(bitmap = ImageBitmap.imageResource(id = activity.resources.getIdentifier(
                inputMovie.movie_img_name,"drawable",activity.packageName
            )), contentDescription = "",Modifier.size(200.dp,300.dp))

            Text(text = "${inputMovie.movie_price} ₺", fontSize = 34.sp)
        }
    }
}