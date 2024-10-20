package com.enesorhan.finalproject.uix.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.enesorhan.finalproject.R
import com.enesorhan.finalproject.data.entities.Meals
import com.enesorhan.finalproject.ui.theme.Purple40
import com.enesorhan.finalproject.uix.viewModels.MainPageViewModel
import com.google.gson.Gson
import com.skydoves.landscapist.glide.GlideImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPage(navController: NavController,mainPageViewModel: MainPageViewModel){


    val foodList = mainPageViewModel.foodList.observeAsState(listOf())
    val isSearched = remember { mutableStateOf(false) }
    val tfSearch = remember { mutableStateOf("") }
    val containerColor = remember { mutableStateOf(Color.White) }
    val items = listOf("Anasayfa","Favorilerim","Sepetim","Siparisler","Kampanya")
    val selectedItem = remember { mutableStateOf(0) }

    LaunchedEffect(key1 = true) {
        mainPageViewModel.tumYemekleriGetir()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {

                if (isSearched.value){
                    TextField(
                        value = tfSearch.value,
                        onValueChange = {
                            tfSearch.value=it
                        },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            focusedIndicatorColor = colorResource(id = android.R.color.holo_orange_dark),
                            focusedLabelColor = colorResource(id = android.R.color.holo_orange_dark),
                            unfocusedContainerColor = Color.Transparent,
                            unfocusedIndicatorColor = colorResource(id = android.R.color.holo_orange_dark),
                            unfocusedLabelColor = colorResource(id = android.R.color.holo_orange_dark),
                        ),


                    )
                }else{
                    Text(
                        text = "Siparis Ver",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 30.sp
                    ) }
                },
                actions = {
                    if (isSearched.value){
                        IconButton(onClick = {
                            tfSearch.value = ""
                            isSearched.value=false
                        }) {
                            Icon(painter = painterResource(id = R.drawable.baseline_close_24), contentDescription = "")
                        }
                    }else{
                        IconButton(onClick = {
                            isSearched.value=true
                        }) {
                            Icon(painter = painterResource(id = R.drawable.baseline_search_24), contentDescription = "")

                        } }

                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Purple40
                )
            )
        },
        bottomBar = {
            BottomAppBar {
                items.forEachIndexed { index, itemText ->

                    NavigationBarItem(
                        label = { Text(text = itemText)},
                        selected = selectedItem.value==index,
                        onClick = {
                            selectedItem.value=index
                            when(index){
                                0 -> {
                                    navController.navigate("mainpage")
                                }
                                2 -> {
                                    navController.navigate("cartpage")
                                }

                            }
                                  },
                        icon = {
                            when(index){
                                0 -> {
                                    Icon(painter = painterResource(id = R.drawable.baseline_home_24), contentDescription = "")
                                }
                                1 -> {
                                    Icon(painter = painterResource(id = R.drawable.baseline_favorite_24), contentDescription = "")

                                }
                                2 -> {
                                    Icon(painter = painterResource(id = R.drawable.baseline_shopping_bag_24), contentDescription = "")

                                }
                                3 -> {
                                    Icon(painter = painterResource(id = R.drawable.baseline_food_bank_24), contentDescription = "")

                                }
                                4 -> {
                                    Icon(painter = painterResource(id = R.drawable.baseline_card_giftcard_24), contentDescription = "")

                                }
                            }
                        }
                    )
                }

            }
        }
    ) {paddingValues ->
        LazyColumn(
            Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            ) {

            items(
                count = foodList.value.count(),
                itemContent = {
                    val food = foodList.value[it]
                    Card(
                        onClick = {
                            val jsonObj = Gson().toJson(food)
                            navController.navigate("detailspage/$jsonObj")
                        },
                        modifier = Modifier.fillMaxWidth(),
                        elevation = CardDefaults.cardElevation(5.dp),
                        shape = RectangleShape,
                        border = BorderStroke(1.dp,Color.LightGray),
                        colors = CardDefaults.elevatedCardColors(
                            containerColor = colorResource(id = android.R.color.system_accent1_10)
                        )
                    ) {
                        Column(
                            Modifier.fillMaxWidth(),
                            verticalArrangement = Arrangement.SpaceEvenly,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {


                            Row(
                                Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceEvenly,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                val url = "http://kasimadalan.pe.hu/yemekler/resimler/${food.yemek_resim_adi}"
                               GlideImage(imageModel = url, modifier = Modifier.size(150.dp,150.dp))
                                Column(
                                    Modifier.fillMaxWidth(),
                                    verticalArrangement = Arrangement.SpaceEvenly,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Row(
                                        Modifier
                                            .fillMaxWidth()
                                            .padding(10.dp),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            text = food.yemek_adi,
                                            fontWeight = FontWeight.ExtraBold,
                                            fontSize = 20.sp
                                        )
                                        Column(
                                            modifier = Modifier.align(Alignment.Top)
                                        ) {
                                            val isClicked = remember { mutableStateOf(false) }
                                            FilledTonalIconButton(
                                                onClick = {
                                                    if (isClicked.value){
                                                        isClicked.value = false
                                                    }else isClicked.value = true

                                                    containerColor.value = Color.Magenta
                                                },
                                                Modifier.align(Alignment.Start),
                                                colors = IconButtonDefaults.filledTonalIconButtonColors(

                                                    containerColor = Color.White,
                                                    //contentColor = Color.White tiklandiginda durumu degistir
                                                    //Detay sayfaya durumu aktar
                                                )
                                            ) {
                                                if (isClicked.value){
                                                    Icon(
                                                        painter = painterResource(id = R.drawable.baseline_favorite_24),
                                                        contentDescription = "",
                                                        modifier = Modifier
                                                            .size(35.dp)
                                                            .align(Alignment.Start),
                                                        tint = containerColor.value
                                                    )
                                                }else{
                                                    Icon(
                                                        painter = painterResource(id = R.drawable.baseline_favorite_24),
                                                        contentDescription = "",
                                                        modifier = Modifier
                                                            .size(35.dp)
                                                            .align(Alignment.Start),
                                                        tint = Color.Gray
                                                    )
                                                }

                                            }
                                        }


                                    }

                                    Row(
                                        Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceAround,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {

                                        Text(
                                            text = "₺${food.yemek_fiyat},00",
                                            color = Color.Gray,
                                            fontSize = 20.sp,
                                            fontWeight = FontWeight.Medium
                                            )
                                        Button(
                                            onClick = {
                                                val jsonObj = Gson().toJson(food)
                                                navController.navigate("detailspage/$jsonObj")
                                            },
                                            colors = ButtonDefaults.buttonColors(
                                                contentColor = Color.White,
                                                containerColor = colorResource(id = android.R.color.holo_orange_dark)
                                            )
                                        ) {
                                            Text(
                                                text = "Sepete Ekle",
                                                fontWeight = FontWeight.Bold,
                                                fontSize = 16.sp)
                                        }
                                    }
                                }
                            }


                        }
                    }
                }
            )
        }
    }
}