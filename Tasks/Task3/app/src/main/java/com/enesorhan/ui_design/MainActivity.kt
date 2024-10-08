package com.enesorhan.ui_design

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enesorhan.ui_design.ui.theme.Anarenk
import com.enesorhan.ui_design.ui.theme.AnarenkCont
import com.enesorhan.ui_design.ui.theme.AnarenkDark
import com.enesorhan.ui_design.ui.theme.DarkAnarenkCont
import com.enesorhan.ui_design.ui.theme.UI_DesignTheme
import com.enesorhan.ui_design.ui.theme.satisfy
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UI_DesignTheme {
                drawer()
            }
        }
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun drawer(darkTheme: Boolean = isSystemInDarkTheme(),){

    val items = listOf(
        stringResource(id = R.string.men_txt),
        stringResource(id = R.string.woman_txt),
        stringResource(id = R.string.kids_txt),
        stringResource(id = R.string.baby_txt),
    )
    val selectedItem = remember { mutableStateOf(0) }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        modifier = Modifier.padding(),
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(drawerContainerColor =
            if (darkTheme) DarkAnarenkCont else AnarenkCont
            ) {
                items.forEachIndexed { index, item ->
                    NavigationDrawerItem(
                        modifier = Modifier.padding(all = 5.dp),
                        label = { Text(text = item, color = Color.White) },
                        icon = {
                            when(item){
                                stringResource(id = R.string.men_txt)
                                ->{
                                 Image(painter = painterResource(id = R.drawable.man), contentDescription = "")
                                }
                                stringResource(id = R.string.woman_txt)
                                -> {
                                Image(painter = painterResource(id = R.drawable.businesswoman), contentDescription = "")                            }
                                stringResource(id = R.string.kids_txt)
                                -> {
                                Image(painter = painterResource(id = R.drawable.children), contentDescription = "")                            }
                                stringResource(id = R.string.baby_txt)
                                -> {
                                Image(painter = painterResource(id = R.drawable.baby), contentDescription = "")                            }
                            }
                        },
                        selected = selectedItem.value == index,
                        onClick = { selectedItem.value = index },
                        colors = NavigationDrawerItemDefaults.colors(
                            selectedContainerColor = if (darkTheme) AnarenkDark else Anarenk,
                            unselectedContainerColor = Color.DarkGray
                        )
                    )
                }
            }
        },
        content = {
            when(selectedItem.value){
                0 -> {
                    MainPage()
                    scope.launch { drawerState.close() }
                }
                1 -> {
                    MainPage()
                    scope.launch { drawerState.close() }
                }
                2 -> {
                    MainPage()
                    scope.launch { drawerState.close() }
                }
                3 -> {
                    MainPage()
                    scope.launch { drawerState.close() }
                }
                
            }
            
        }
    )

    val activity = LocalContext.current as Activity

    BackHandler(
        onBack = {
            if(drawerState.isOpen){
                scope.launch { drawerState.close() }
            }else{
                activity.finish()
            }
        }
    )

}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun MainPage(darkTheme: Boolean = isSystemInDarkTheme(),){

    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp
    val screenHeightDp = configuration.screenHeightDp

    val items = listOf(
        stringResource(id = R.string.home_txt),
        stringResource(id = R.string.category_txt),
        stringResource(id = R.string.profile_txt),
        stringResource(id = R.string.contact_txt),
    )
    val selectedItem = remember { mutableStateOf(0) }

    Scaffold(
        containerColor = if (darkTheme) DarkAnarenkCont else AnarenkCont,
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text( stringResource(id = R.string.app_head) , fontFamily = satisfy) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = if (darkTheme) DarkAnarenkCont else AnarenkCont,
                    titleContentColor = if (darkTheme) AnarenkDark else Anarenk
                )
            )
         },
        bottomBar = {
            NavigationBar(
                containerColor = if (darkTheme) DarkAnarenkCont else AnarenkCont,
                contentColor = if (darkTheme) Anarenk else AnarenkDark,
            ) {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        label = { Text(text = item)},
                        selected = selectedItem.value == index,
                        onClick = { selectedItem.value = index },
                        icon = {
                            when(item){
                                stringResource(id = R.string.home_txt)
                                ->{
                                    Icon(
                                        painter = painterResource(id = R.drawable.baseline_home_24),
                                        contentDescription = "",
                                    )
                                }
                                stringResource(id = R.string.category_txt) -> {
                                    Icon(
                                        painter = painterResource(id = R.drawable.baseline_category_24),
                                        contentDescription = "",
                                    )                           }
                                stringResource(id = R.string.profile_txt) -> {
                                    Icon(
                                        painter = painterResource(id = R.drawable.baseline_person_24),
                                        contentDescription = "",
                                    )                           }
                                stringResource(id = R.string.contact_txt) -> {
                                    Icon(
                                        painter = painterResource(id = R.drawable.baseline_contact_support_24),
                                        contentDescription = "",
                                    )                           }
                            }
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedTextColor = if (darkTheme) AnarenkCont else DarkAnarenkCont,
                            selectedIconColor = if (darkTheme) AnarenkCont else DarkAnarenkCont,
                            unselectedTextColor = if (darkTheme) AnarenkDark else Anarenk,
                            unselectedIconColor = if (darkTheme) AnarenkDark else Anarenk,
                            indicatorColor = if (darkTheme) AnarenkDark else Anarenk,
                            disabledIconColor = if (darkTheme) AnarenkCont else DarkAnarenkCont
                        )
                    )
                }
            }
        }
    ) {paddingValues ->

        val images = listOf(
            R.drawable.images,
            R.drawable.images1,
            R.drawable.best_model_of_turkey_2010_2,
            R.drawable.famous
        )
        val pagerState = rememberPagerState(pageCount = { images.size })

        Column(
            Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            Arrangement.SpaceEvenly,
            Alignment.CenterHorizontally
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp),
                Arrangement.SpaceBetween,
                Alignment.CenterVertically
            ) {

                CreateIcon(id = R.drawable.man, color = Color.Blue)

                CreateIcon(id = R.drawable.businesswoman, color = Color.Magenta)

                CreateIcon(id = R.drawable.children, color = Color.Green)

                CreateIcon(id = R.drawable.baby, color = Color.Yellow)

            }
                Box(
                    Modifier
                        .wrapContentSize()
                        .padding(top = (screenWidthDp / 20).dp, start = (screenWidthDp / 20).dp)){
                    HorizontalPager(
                        state = pagerState,
                        Modifier
                            .wrapContentSize()
                            .padding(20.dp)
                    ) {currentImg ->
                        Card(
                            Modifier.wrapContentSize(),
                            elevation = CardDefaults.cardElevation(5.dp)
                        ) {
                            Image(painter = painterResource(id = images[currentImg]), contentDescription = "",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.size(300.dp))
                        }
                    } }



            Row(
                Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                Arrangement.SpaceEvenly,
                Alignment.CenterVertically
            ) {
                Card(
                    modifier = Modifier
                        .size((screenWidthDp / 2.2).dp)
                        .padding(10.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (darkTheme) DarkAnarenkCont else AnarenkCont,
                        contentColor = if (darkTheme) AnarenkDark else Anarenk
                        )
                ){
                    Column(
                        Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_local_shipping_24),
                            contentDescription = "",Modifier.size(45.dp)
                        )
                        Text(stringResource(id = R.string.ship_txt), fontWeight = FontWeight.Bold, fontSize = (screenWidthDp/20).sp)
                    }

                }
                Card(
                    modifier = Modifier
                        .size((screenWidthDp / 2.2).dp)
                        .padding(10.dp) ,
                    colors = CardDefaults.cardColors(
                        containerColor = if (darkTheme) DarkAnarenkCont else AnarenkCont,
                        contentColor = if (darkTheme) AnarenkDark else Anarenk
                    )
                ){
                    Column(
                        Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_payment_24),
                            contentDescription = "",Modifier.size(45.dp)
                        )
                        Text(stringResource(id = R.string.pay_txt),fontWeight = FontWeight.Bold, fontSize = (screenWidthDp/20).sp)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true/*, locale = "tr"*/)
@Composable
fun GreetingPreview() {
    UI_DesignTheme {
drawer()    }
}