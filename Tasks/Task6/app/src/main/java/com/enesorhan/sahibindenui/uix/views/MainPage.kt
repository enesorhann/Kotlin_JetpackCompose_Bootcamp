package com.enesorhan.sahibindenui.uix.views

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.enesorhan.sahibindenui.R
import com.enesorhan.sahibindenui.data.entity.Cars
import com.enesorhan.sahibindenui.ui.theme.blueSahibinden
import com.google.gson.Gson

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPage(navController: NavController){

    val cars = remember { mutableStateListOf<Cars>() }
    val isSearched = remember { mutableStateOf(false) }
    val tf = remember { mutableStateOf("") }

    LaunchedEffect(key1 = true) {
        val c1 = Cars("Fiat", "Egea", "1.3 Multijet Urban Plus", "Dizel",
            "Manuel", "639.500", "12.12.2024","Adana,Seyhan", "Ikinci El",
            150000, "Sedan", "Lacivert", 95, 1248, "Onden Cekis",
            "egea","2019 Model Sahibinden Düşük KM","2019")

        val c2 = Cars("Ford", "Focus", "1.6 Ti-VCT Trend X", "Benzin+LPG",
            "Manuel", "800.000", "01.12.2025","Mersin,Mezitli", "Sifir",
            80000, "Sedan", "Mavi", 125, 1596, "Onden Cekis",
            "focus","Kesinlikle aile araci degildir serseriden serseriye :)","2019")

        val c3 = Cars("Mitsubishi", "Colt", "1.3", "Benzin+LPG",
            "Manuel", "500.000", "01.01.2025","Duzce,Akcakoca", "Ikinci El",
            128000, "Hatchback 5 Kapi", "Kırmızı", 95, 1248, "Onden Cekis",
            "colt","Degisensiz Bakimli Yavru Kopekbaligi ","2012")

        val c4 = Cars("Porsche", "Cayanne", "3.0 D", "Dizel",
            "Otomatik", "4.370.000", "28.06.2025","Bursa,Inegol", "Ikinci El",
            99000, "Sedan", "Siyah", 245, 2967, "4x4",
            "cayanne","Hatasiz Yeni Kasa Degisensiz 99 Bin Km Garaj Arabasi","2014")

        val c5 = Cars("Peugeout", "Bipper", "1.3", "Dizel",
            "Manuel", "400.000", "16.02.2025","Adana,Cukurova", "Ikinci El",
            300000, "Camlı Van", "Beyaz", 75, 1248, "Onden Cekis",
            "bipper","Memurdan Full+Full temiz aile arabasi","2010")

        val c6 = Cars("Honda", "Civic", "2.0 Type-R", "Benzin",
            "Manuel", "2.245.000", "14.08.2025","Hakkari, Yüksekova", "Ikinci El",
            75000, "Hatchback", "Kırmızı", 310, 1996, "Onden Cekis",
            "civic","Uzman Cavus'dan Satilik Type-R","2015")

        val c7 = Cars("Renault", "Clio", "1.5 Blue DCI", "Dizel",
            "Manuel", "540.000", "19.04.2025","Konya,Karatay", "Ikinci El",
            300000, "Hatchback", "Beyaz", 65, 1248, "Onden Cekis",
            "clio","Sadece Ciddi Alicilar Fiyatta Pazarlik Payi Vardir","2010")

        val c8 = Cars("Toyota", "Corolla", "1.6 XL", "Benzin+LPG",
            "Manuel", "400.000", "23.11.2025","Antalya,Kas", "Ikinci El",
            300000, "Sedan", "Beyaz", 95, 1248, "Onden Cekis",
            "corollaefsane","Efsane Kasa Tertemiz Garaj Arabasi İhtiyactan Dolayi Satiliktir","1993")

        val c9 = Cars("BMW", "5 Serisi", "520d xDrive M Sport", "Dizel",
            "Manuel", "3.000.000", "06.06.2025","Kocaeli,Gebze", "Ikinci El",
            30000, "Sedan", "Siyah", 190, 1995, "4WD (Surekli)",
            "e60bmw","BMW E60  MGO'dan Senet Firsatiyla","2010")

        val c10 = Cars("Mercedes", "G Serisi", "63 Amg", "Benzin",
            "Manuel", "18.500.000", "07.09.2025","Trabzon,Of", "Ikinci El",
            26000, "SUV", "Siyah", 585, 3982, "4x4",
            "g63","Oflu'dan Mercedes G63 Luxury ","2010")

        val c11 = Cars("BMW", "M Serisi", "M5", "Benzin",
            "Manuel", "5.400.000", "12.10.2025","Samsun,Atakum", "Ikinci El",
            128000, "Sedan", "Siyah", 560, 4395, "Onden Cekis",
            "m5bmw","M SPORT+TAM OTONOM+360+KEYLESS+3 BOLGE","2019")

        val c12 = Cars("Renault", "Megane", "1.5 dCi Touch Plus", "Dizel",
            "Manuel", "950.000", "20.10.2025","Izmir,Buca", "Ikinci El",
            85000, "Sedan", "Beyaz", 95, 1248, "Onden Cekis",
            "megane4","Degisensiz Megane4 Dolu Paket","2020")

        val c13 = Cars("Ford", "Mondeo", "2.0 TDCi Titanium", "Dizel",
            "Manuel", "1.500.000", "06.09.2025","Ankara,Kecioren", "Ikinci El",
            120000, "Sedan", "Fume", 180, 1997, "Onden Cekis",
            "mondeo","Lansman Renk Ozel Uretim Makam Araci","2020")

        cars.add(c1)
        cars.add(c2)
        cars.add(c3)
        cars.add(c4)
        cars.add(c5)
        cars.add(c6)
        cars.add(c7)
        cars.add(c8)
        cars.add(c9)
        cars.add(c10)
        cars.add(c11)
        cars.add(c12)
        cars.add(c13)
    }

    Scaffold(
        topBar = { TopAppBar(
            title = {
                if (isSearched.value){
                    TextField(
                        value = tf.value,
                        onValueChange = {tf.value=it},
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = blueSahibinden,
                            focusedIndicatorColor = colorResource(id = android.R.color.darker_gray),
                            focusedLabelColor = colorResource(id = android.R.color.white),
                            unfocusedContainerColor = blueSahibinden,
                            unfocusedLabelColor = colorResource(id = android.R.color.white),
                            unfocusedIndicatorColor = colorResource(id = android.R.color.darker_gray),
                            cursorColor = Color.Blue,
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White

                            )
                    )
                }else{
                    Text(text = "Sahibinden", color = Color.White, fontWeight = FontWeight.Bold)
                }

            },
            actions = {
                if (isSearched.value){
                    IconButton(onClick = {
                        isSearched.value=false
                        tf.value=""
                    }) {
                        Icon(painter = painterResource(id = R.drawable.baseline_close_24), contentDescription = "",
                            tint = Color.White)
                    }
                }else{
                    IconButton(onClick = {
                        isSearched.value=true
                    }) {
                        Icon(painter = painterResource(id = R.drawable.baseline_search_24), contentDescription = "",
                            tint = Color.White)
                    }
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = blueSahibinden
            )
        )
        }
    ) {paddingValues ->
        LazyColumn(
            Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            items(
                count = cars.count(),
                itemContent = {
                    val car = cars[it]
                    Card(
                        modifier = Modifier.padding(1.dp),
                        onClick = {
                            val jsonImg = Gson().toJson(car)
                            navController.navigate("detailspage/$jsonImg") },
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White,
                            contentColor = Color.Black
                        )
                    ) {

                        Row(
                            Modifier.fillMaxWidth().padding(5.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            val activity  = LocalContext.current as Activity
                            Image(
                                bitmap = ImageBitmap.imageResource(
                                    id = activity.resources.getIdentifier(car.img,"drawable",activity.packageName)),
                                contentDescription = "",Modifier.size(80.dp,80.dp))
                            Spacer(modifier = Modifier.size(5.dp))
                            Column(
                                Modifier.fillMaxWidth(),
                                verticalArrangement = Arrangement.SpaceEvenly,
                                horizontalAlignment = Alignment.Start
                            ) {
                                Text(text = car.aciklama,fontWeight = FontWeight.W600, fontSize = 17.sp)
                                Spacer(modifier = Modifier.size(5.dp))
                                Row(
                                    Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.SpaceEvenly
                                    ) {
                                        Icon(painter = painterResource(id = R.drawable.baseline_location_on_24),
                                            tint = Color.Gray,
                                            contentDescription =  "",
                                            modifier = Modifier.size(20.dp))
                                        Text(text = car.adres, fontWeight = FontWeight.W400)
                                    }
                                    Text(
                                        text = "${car.fiyat} TL",
                                        color = Color.Blue,
                                        fontWeight = FontWeight.W500,
                                        fontSize = 16.sp)
                                }
                            }
                        }
                    }
                }
            )
        }
    }


}