package com.enesorhan.finalproject.uix.views

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import com.enesorhan.finalproject.R
import com.enesorhan.finalproject.data.entities.Food_Cart
import com.enesorhan.finalproject.data.entities.Meals
import com.enesorhan.finalproject.ui.theme.Purple40
import com.enesorhan.finalproject.uix.viewModels.CartPageViewModel
import com.enesorhan.finalproject.uix.viewModels.DetailPageViewModel
import com.google.gson.Gson
import com.skydoves.landscapist.glide.GlideImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartPage(navController: NavController, cartPageViewModel:CartPageViewModel){



    val cartList = cartPageViewModel.cartList.observeAsState(listOf())
    val tfIndirim = remember { mutableStateOf("") }
    val total = cartList.value!!.sumOf { it.yemek_siparis_adet*it.yemek_fiyat }

    LaunchedEffect(key1 = true) {
        cartPageViewModel.tumSepetiGetir("enes")
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {


                        Text(
                            text = "Sepetim (${cartList.value!!.size})",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 30.sp
                        )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Purple40
                )
            )
        },

    ) {paddingValues ->

            if (cartList.value.isNullOrEmpty()){
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(text = "Sepete Urun Ekleyin", fontSize = 40.sp)
                }
            }else{
                LazyColumn(
                    Modifier
                        .padding(paddingValues)
                        .fillMaxSize(),
                ) {

                    items(

                        count = cartList.value!!.count(),
                        itemContent = {
                            val food = cartList.value!![it]

                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(5.dp),
                                elevation = CardDefaults.cardElevation(5.dp),
                                shape = RoundedCornerShape(20.dp),
                                border = BorderStroke(1.dp, Color.LightGray),
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
                                                    fontWeight = FontWeight.SemiBold,
                                                    fontSize = 20.sp
                                                )
                                                Column(
                                                    modifier = Modifier.align(Alignment.Top)
                                                ) {
                                                    IconButton(
                                                        onClick = {
                                                            cartPageViewModel.sepettenSil(food.sepet_yemek_id,food.kullanici_adi)
                                                        },
                                                        Modifier.align(Alignment.Start),
                                                        colors = IconButtonDefaults.iconButtonColors(
                                                            containerColor = Color.Transparent,
                                                            //contentColor = Color.White tiklandiginda durumu degistir
                                                            //Detay sayfaya durumu aktar
                                                        )
                                                    ) {
                                                        Icon(
                                                            painter = painterResource(id = R.drawable.baseline_delete_24),
                                                            contentDescription = "",
                                                            modifier = Modifier
                                                                .size(35.dp)
                                                                .align(Alignment.Start),
                                                            tint = Color.DarkGray
                                                        )
                                                    }
                                                }
                                            }
                                            Row(
                                                Modifier
                                                    .fillMaxWidth()
                                                    .padding(10.dp),
                                                horizontalArrangement = Arrangement.SpaceBetween,
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Spacer(modifier = Modifier.size(5.dp))
                                                ElevatedCard(

                                                    colors = CardDefaults.cardColors(
                                                        containerColor = Color.White
                                                    ),
                                                    elevation = CardDefaults.elevatedCardElevation(5.dp)
                                                ) {
                                                    Row(
                                                        verticalAlignment = Alignment.CenterVertically,
                                                    ) {
                                                        IconButton(
                                                            onClick = {
                                                                if (food.yemek_siparis_adet>1){
                                                                    cartPageViewModel.sepetiGuncelle(food,food.yemek_siparis_adet-1)
                                                                }

                                                            },
                                                            colors = IconButtonDefaults.iconButtonColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Icon(painter = painterResource(id = R.drawable.baseline_remove_24), contentDescription = "")
                                                        }
                                                        Box(
                                                            modifier = Modifier
                                                                .background(color = Purple40)
                                                                .size(45.dp, 45.dp)
                                                        ){
                                                            Text(text = "${food.yemek_siparis_adet}",
                                                                fontSize = 25.sp,
                                                                fontWeight = FontWeight.Bold,
                                                                modifier = Modifier.align(Alignment.Center)
                                                            )
                                                        }

                                                        IconButton(
                                                            onClick = {
                                                                cartPageViewModel.sepetiGuncelle(food,food.yemek_siparis_adet+1)
                                                            },
                                                            colors = IconButtonDefaults.iconButtonColors(
                                                                containerColor = Color.White
                                                            )
                                                        ) {
                                                            Icon(painter = painterResource(id = R.drawable.baseline_add_24), contentDescription = "")
                                                        }
                                                    }

                                                }
                                            }

                                        }
                                    }

                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(10.dp),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            text = "Fiyat: ₺${food.yemek_fiyat}",
                                            fontWeight = FontWeight.Normal,
                                            fontSize = 20.sp
                                        )
                                        val adet = food.yemek_siparis_adet
                                        val fiyat = food.yemek_fiyat
                                        val toplam = adet*fiyat

                                        Spacer(modifier = Modifier.size(20.dp))
                                        Text(
                                            text = "Toplam: ₺$toplam",
                                            fontWeight = FontWeight.SemiBold,
                                            color = Color.DarkGray,
                                            fontSize = 20.sp)
                                    }


                                }
                            }
                        }
                    )


                }


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Spacer(modifier = Modifier.size(670.dp))
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = colorResource(id = android.R.color.system_accent1_10)
                )
            ) {
                Column(
                    Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TextField(
                            value = tfIndirim.value,
                            onValueChange = {tfIndirim.value=it},
                            modifier = Modifier
                                .size(250.dp, 50.dp)
                                .border(
                                    BorderStroke(1.dp, Color.Gray),
                                    shape = RoundedCornerShape(5.dp)
                                ),
                            label = {
                                Text(text = "Indirim kodunuz varsa lutfen giriniz", fontSize = 13.sp)
                                    },
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.Transparent,
                                unfocusedContainerColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                focusedLabelColor = Color.Gray,
                                unfocusedLabelColor = Color.Gray,

                            )
                        )
                        ElevatedButton(
                            modifier = Modifier.size(100.dp,40.dp),
                            onClick = {  },
                            colors = ButtonDefaults.elevatedButtonColors(
                                containerColor = colorResource(id = android.R.color.holo_orange_dark),
                                contentColor = Color.White
                            )
                        ) {
                            Text(text = "Uygula")
                        }
                    }
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        ElevatedCard(

                            colors = CardDefaults.cardColors(
                                containerColor = Color.White
                            ),
                            elevation = CardDefaults.elevatedCardElevation(5.dp)
                        ) {
                            Row(
                                Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                ElevatedButton(
                                    onClick = {

                                    },
                                    colors = ButtonDefaults.elevatedButtonColors(
                                        containerColor = Purple40,
                                        contentColor = Color.White
                                    ),
                                    shape = RectangleShape,
                                    modifier = Modifier.size(250.dp,50.dp)
                                ) {
                                    Text(text = "Sepeti Onayla")

                                }
                                Text(text = "₺${total},00",
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,)
                                Spacer(modifier = Modifier.size(5.dp))
                            }

                        }


                    }

                }



            }
        }
            }
    }
}