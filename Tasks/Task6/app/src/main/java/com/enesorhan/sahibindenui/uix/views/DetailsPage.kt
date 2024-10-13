package com.enesorhan.sahibindenui.uix.views

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.enesorhan.sahibindenui.R
import com.enesorhan.sahibindenui.data.entity.Cars
import com.enesorhan.sahibindenui.ui.theme.blueSahibinden
import com.google.gson.Gson

@SuppressLint("UnrememberedMutableInteractionSource")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsPage(navController: NavController,car:Cars){

    val items = listOf("Ilan Bilgileri","Aciklama","Konumu")
    val selectedItem = remember { mutableStateOf(0) }
    val color = remember { mutableStateOf(Color.White) }

        Scaffold(
        topBar = { TopAppBar(
            title = {
                    Text(text = "Ilan Detayi", color = Color.White, fontWeight = FontWeight.Bold)
            },
            actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(painter = painterResource(id = R.drawable.baseline_share_24),
                        contentDescription = "",
                        tint = Color.White
                    )
                }
                IconButton(onClick = {
                    color.value = Color.Yellow
                }) {
                    Icon(painter = painterResource(id = R.drawable.baseline_star_outline_24),
                        contentDescription = "",
                        tint = color.value,
                        )
                }
            },

            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = blueSahibinden
            )
        )
        }
    ) { paddingValues ->
        Column(
            Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            OutlinedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .size(50.dp),
                colors = CardDefaults.outlinedCardColors(
                    containerColor = Color.LightGray,
                    contentColor = Color.Black
                ),
                shape = RectangleShape,
                border = BorderStroke(1.dp,Color.DarkGray),
                elevation = CardDefaults.outlinedCardElevation()
            ) {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = car.aciklama, color = Color.Black, fontWeight = FontWeight.SemiBold)
                }
            }
            val activity  = LocalContext.current as Activity
            Image(
                bitmap = ImageBitmap.imageResource(
                    id = activity.resources.getIdentifier(car.img,"drawable",activity.packageName)),
                contentDescription = "",
                Modifier
                    .size(300.dp, 200.dp)
                    .fillMaxWidth())
            Text(text = "${car.marka} > ${car.seri} > ${car.model} ", color = Color.Blue, fontWeight = FontWeight.W300)
            Text(text = car.adres, fontWeight = FontWeight.W500, fontSize = 15.sp, color = Color.Gray)
            Column(
                Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                NavigationBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(41.dp),
                    containerColor = colorResource(id = R.color.ic_launcher_background),
                    contentColor = Color.Black
                ) {
                    items.forEachIndexed { index, item ->
                        NavigationBarItem(
                            selected = selectedItem.value==index ,
                            onClick = {
                                selectedItem.value=index
                            },
                            label = { Text(text = item, fontSize = 15.sp)},
                            colors = NavigationBarItemDefaults.colors(
                                indicatorColor = Color.Red,
                                unselectedTextColor = Color.Black,
                                unselectedIconColor = Color.Black,
                                disabledTextColor = Color.Black,
                                disabledIconColor = Color.Black,
                                selectedIconColor = Color.Black,
                                selectedTextColor = Color.Red,
                            ),
                            icon = {},

                        )
                        }
                    }
                }
            Box(modifier = Modifier
                .wrapContentSize()
                .weight(1f)){
                Column(
                    Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    when(selectedItem.value){
                        0 -> {
                            RowDesign(text1 = "Fiyat", text2 = "${car.fiyat} TL",
                                color1 = Color.Gray, color2 = Color.Blue)
                            RowDesign(text1 = "Ilan Tarihi", text2 = car.ilan_tarihi)
                            RowDesign(text1 = "Marka", text2 = car.marka)
                            RowDesign(text1 = "Seri", text2 = car.seri)
                            RowDesign(text1 = "Model", text2 = car.model)
                            RowDesign(text1 = "Yil", text2 = car.yil)
                            RowDesign(text1 = "Yakit", text2 = car.yakit)
                            RowDesign(text1 = "Vites", text2 = car.vites)
                            RowDesign(text1 = "Arac Durumu", text2 = car.arac_durumu)
                            RowDesign(text1 = "KM", text2 = "${car.km}")
                            RowDesign(text1 = "Kasa Tipi", text2 = car.kasaTipi)
                            RowDesign(text1 = "Motor Gucu", text2 ="${car.motor_gucu} hp")
                            RowDesign(text1 = "Motor Hacmi", text2 = "${car.motor_hacmi} cc")
                            RowDesign(text1 = "Cekis", text2 = car.cekis)
                            RowDesign(text1 = "Renk", text2 = car.renk)
                        }
                        1 -> {
                            Text(text = car.aciklama, modifier = Modifier.padding(10.dp), fontWeight = FontWeight.Bold)
                        }
                        2 -> {
                            Image(painter = painterResource(id = R.drawable.map),
                                contentDescription = "",Modifier.size(380.dp,500.dp))
                        }
                    }
                }

                }
            }
            }
        }


