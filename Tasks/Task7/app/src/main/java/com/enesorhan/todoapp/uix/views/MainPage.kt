package com.enesorhan.todoapp.uix.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.enesorhan.todoapp.R
import com.enesorhan.todoapp.data.entity.ToDo
import com.enesorhan.todoapp.uix.viewModels.MainViewModels
import com.google.gson.Gson
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPage(navController: NavController,mainViewModels: MainViewModels){

    val isSearched = remember { mutableStateOf(false) }
    val tfSearch = remember { mutableStateOf("") }
    val toDoList = mainViewModels.toDoList.observeAsState(listOf())
    val snackbarHostState = remember {SnackbarHostState()}
    val scope = rememberCoroutineScope()


    LaunchedEffect(key1 = true) {
        mainViewModels.getAllToDo()
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
                                mainViewModels.searchToDo(it)
                            },
                            label = { Text(text = "Search In ToDo") },
                            colors = TextFieldDefaults.colors(
                                focusedIndicatorColor = Color.Blue,
                                focusedContainerColor = Color.Transparent,
                                focusedLabelColor = Color.Blue,
                                unfocusedLabelColor = Color.Blue,
                                unfocusedContainerColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Blue,
                            )
                        )
                    }else{
                        Text(text = "ToDo")
                    }
                },
                actions = {
                    if (isSearched.value){
                        IconButton(
                            onClick = {
                                tfSearch.value = ""
                                isSearched.value = false
                            }) {
                            Icon(painter = painterResource(id = R.drawable.baseline_close_24), contentDescription = "")
                        }
                    }else{
                        IconButton(
                            onClick = {
                                isSearched.value = true
                            }) {
                            Icon(painter = painterResource(id = R.drawable.baseline_search_24), contentDescription = "")
                        }
                    }
                },
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                navController.navigate("savepage"){
                    popUpTo("mainPage")
                }
            },
                containerColor = Color.Red,
            ) {
                Icon(painter = painterResource(id = R.drawable.baseline_add_24), contentDescription = "")
            }
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) {paddingValues ->
        LazyColumn(
            Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(
                count = toDoList.value.count(),
                itemContent = {
                    val toDo = toDoList.value[it]
                    val isEnabled = remember { mutableStateOf(true) }
                    val fontStyle = remember { mutableStateOf(FontStyle.Normal) }
                    val textDecoration = remember { mutableStateOf(TextDecoration.None) }
                    ElevatedCard(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(1.dp),
                        enabled = isEnabled.value,
                        elevation = CardDefaults.cardElevation(10.dp),
                        colors = CardDefaults.elevatedCardColors(
                            containerColor = colorResource(id = android.R.color.holo_orange_light),
                            disabledContainerColor = Color.LightGray,
                            contentColor = Color.Black,
                            disabledContentColor = Color.Gray
                        ),
                        onClick = {
                            val jsonObj = Gson().toJson(toDo)
                            navController.navigate("detailspage/$jsonObj"){
                                popUpTo("mainPage")
                            }
                        }
                    ) {

                        Row(
                            Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceEvenly
                                ) {

                                Spacer(modifier = Modifier.size(10.dp))
                                Text(text = "${toDo.id}.",fontWeight = FontWeight.Bold, fontSize = 17.sp)
                                Spacer(modifier = Modifier.size(10.dp))
                                Text(
                                    text = toDo.name,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 17.sp,
                                    fontStyle = fontStyle.value,
                                    textDecoration = textDecoration.value
                                )
                            }
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ){
                                IconButton(
                                    onClick = {
                                        isEnabled.value = false
                                        fontStyle.value = FontStyle.Italic
                                        textDecoration.value = TextDecoration.LineThrough
                                    }) {
                                    Icon(painter = painterResource(id = R.drawable.baseline_check_24),tint= colorResource(
                                        id = android.R.color.holo_green_dark
                                    ), contentDescription = "")
                                }
                                IconButton(
                                    onClick = {
                                        scope.launch {
                                            val sb = snackbarHostState.showSnackbar(
                                                "Do you want to delete this ToDo element",
                                                actionLabel = "Yes", withDismissAction = true)

                                            if (sb==SnackbarResult.ActionPerformed){
                                                mainViewModels.deleteToDo(toDo.id)
                                                snackbarHostState.showSnackbar("Deleted", duration = SnackbarDuration.Short)
                                            }else{
                                                snackbarHostState.showSnackbar("Canceled", duration = SnackbarDuration.Short)
                                            }
                                        }

                                    }) {
                                    Icon(painter = painterResource(id = R.drawable.baseline_close_24), tint = colorResource(
                                        id = android.R.color.holo_red_dark
                                    ) ,contentDescription = "")
                                }
                            }
                        }
                    }

                }
            )
        }
    }
}