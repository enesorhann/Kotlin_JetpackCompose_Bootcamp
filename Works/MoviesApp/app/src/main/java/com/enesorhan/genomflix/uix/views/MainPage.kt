package com.enesorhan.genomflix.uix.views

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.enesorhan.genomflix.data.entity.Movies
import com.google.gson.Gson
import com.skydoves.landscapist.glide.GlideImage
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPage(navController: NavController){

    val movieList = remember { mutableStateListOf<Movies>() }
    val hostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = true) {

        val f1 = Movies(1,"Django","django",24)
        val f2 = Movies(2,"Interstellar","interstellar",32)
        val f3 = Movies(3,"Inception","inception",16)
        val f4 = Movies(4,"The Hateful Eight","thehatefuleight",28)
        val f5 = Movies(5,"The Pianist","thepianist",18)
        val f6 = Movies(6,"Anadoluda","anadoluda",10)
        movieList.add(f1)
        movieList.add(f2)
        movieList.add(f3)
        movieList.add(f4)
        movieList.add(f5)
        movieList.add(f6)

    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Movies")
                }
            )
        },
        snackbarHost = {
            SnackbarHost(hostState = hostState)
        }
    ) {paddingValues ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(count = 2),
            Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            items(
                count = movieList.count(),
                itemContent = {
                    val movie = movieList[it]
                    Card(
                        onClick = {
                            val jsonMovie = Gson().toJson(movie)
                            navController.navigate("detailspage/$jsonMovie") },
                        modifier = Modifier.padding(5.dp)
                    ) {
                        Column(
                          Modifier.fillMaxWidth()
                        ) {
                            val activity = LocalContext.current as Activity
                            Image(bitmap = ImageBitmap.imageResource(id = activity.resources.getIdentifier(
                                movie.movie_img_name,"drawable",activity.packageName
                            )), contentDescription = "",Modifier.size(200.dp,300.dp))
                            Row(
                                Modifier.fillMaxWidth().padding(5.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(text = "${movie.movie_price} ₺", fontSize = 24.sp)
                                Button(
                                    onClick = {
                                    scope.launch {
                                        hostState.showSnackbar("${movie.movie_name} Sepete Eklendi")
                                    }
                                },
                                ) {
                                    Text(text = "Sepete Ekle")
                                }
                            }
                        }
                    }
                }
            )


        }
    }
}