package com.enesorhan.genomflix.uix.views

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
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
import com.enesorhan.genomflix.data.entity.retro_entity.Filmler_Retrofit
import com.enesorhan.genomflix.uix.viewModels.AnasayfaViewModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.gson.Gson
import com.skydoves.landscapist.glide.GlideImage
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPage(navController: NavController,anasayfaViewModel: AnasayfaViewModel){

    val movieList = anasayfaViewModel.movieList.observeAsState(listOf())
    val hostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val isConnected = connectivityManager.activeNetworkInfo?.isConnectedOrConnecting == true

    LaunchedEffect(key1 = true) {
        anasayfaViewModel.getMovies()
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

            if (!isConnected){
                scope.launch {
                    hostState.showSnackbar("Internet Baglantisi Zayif")
                }

            }

            if(movieList.value.isNullOrEmpty()){
                item {
                    CircularProgressIndicator()
                }
            }
            else{
                items(
                    count = movieList.value.count(),
                    itemContent = {
                        val movie = movieList.value[it]
                        Card(
                            onClick = {
                                val jsonMovie = Gson().toJson(movie)
                                navController.navigate("detailspage/$jsonMovie") },
                            modifier = Modifier.padding(5.dp)
                        ) {
                            Column(
                                Modifier.fillMaxWidth()
                            ) {
                                val url = "http://kasimadalan.pe.hu/filmler_yeni/resimler/${movie.resim}"
                                GlideImage(imageModel = url, modifier = Modifier.size(200.dp,300.dp))
                                Row(
                                    Modifier
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(text = "${movie.fiyat} ₺", fontSize = 24.sp)
                                    Button(
                                        onClick = {
                                            scope.launch {
                                                hostState.showSnackbar("${movie.ad} Sepete Eklendi")
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
}