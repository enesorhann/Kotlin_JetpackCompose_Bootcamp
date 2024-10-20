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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.enesorhan.finalproject.data.entities.Food_Cart
import com.enesorhan.finalproject.data.entities.Meals
import com.enesorhan.finalproject.ui.theme.Purple40
import com.enesorhan.finalproject.ui.theme.Purple80
import com.enesorhan.finalproject.uix.viewModels.DetailPageViewModel
import com.google.gson.Gson
import com.skydoves.landscapist.glide.GlideImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsPage(navController: NavController,meal: Meals,detailPageViewModel: DetailPageViewModel){

    val adet = remember { mutableStateOf(1) }
    val kullanici_adi:String = "enes"
    val containerColor = remember { mutableStateOf(Color.Red) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Urun Detay",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 30.sp)

                },
                actions = {
                    val isClicked = remember { mutableStateOf(false) }

                    IconButton(
                        onClick = {
                            if (isClicked.value){
                                isClicked.value = false

                            }else isClicked.value = true

                    },
                        colors = IconButtonDefaults.iconButtonColors(
                            containerColor = Color.Transparent,
                            contentColor = Color.White
                            //contentColor = Color.White tiklandiginda durumu degistir
                        )
                    ) {
                        if (isClicked.value){
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_favorite_24),
                                contentDescription = "",
                                tint = containerColor.value
                            )

                        }else {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_favorite_24),
                                contentDescription = "",
                                tint = Color.Gray
                            )
                        }


                        Icon(painter = painterResource(id = R.drawable.baseline_favorite_24), contentDescription = "")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Purple40
                )
            )
        }
    ) {paddingValues ->
        Column(
            Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            val url = "http://kasimadalan.pe.hu/yemekler/resimler/${meal.yemek_resim_adi}"
            GlideImage(imageModel = url, modifier = Modifier.size(200.dp,250.dp))
            Column(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(text = meal.yemek_adi, fontSize = 25.sp, fontWeight = FontWeight.ExtraBold)
                    Spacer(modifier = Modifier.size(10.dp))
                    Text(text = " ₺${meal.yemek_fiyat},00", fontSize = 25.sp)
                }

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
                        Text(text = "Toplam Adet",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Gray
                        )
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
                                    onClick = { adet.value-- },
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
                                    Text(text = "${adet.value}",
                                        fontSize = 25.sp,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.align(Alignment.Center)
                                    )
                                }

                                IconButton(
                                    onClick = { adet.value++ },
                                    colors = IconButtonDefaults.iconButtonColors(
                                        containerColor = Color.White
                                    )
                                ) {
                                    Icon(painter = painterResource(id = R.drawable.baseline_add_24), contentDescription = "")
                                }
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
                                        detailPageViewModel.sepeteEkle(
                                            meal.yemek_adi,meal.yemek_resim_adi,meal.yemek_fiyat,
                                            adet.value,kullanici_adi
                                            )

                                        navController.navigate("cartpage")
                                    },
                                    colors = ButtonDefaults.elevatedButtonColors(
                                        containerColor = Purple40,
                                        contentColor = Color.White
                                    ),
                                    shape = RectangleShape,
                                    modifier = Modifier.size(250.dp,50.dp)
                                ) {
                                    Text(text = "Sepete Ekle")

                                }
                                Text(text = "${adet.value*meal.yemek_fiyat}",
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