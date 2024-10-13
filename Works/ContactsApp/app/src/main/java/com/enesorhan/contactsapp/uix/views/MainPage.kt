package com.enesorhan.contactsapp.uix.views

import android.util.Log
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.enesorhan.contactsapp.R
import com.enesorhan.contactsapp.data.entity.Persons
import com.google.gson.Gson
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPage(navController: NavController){

    val tf  = remember { mutableStateOf("") }
    val isSearched  = remember { mutableStateOf(false) }
    val persons = remember { mutableStateListOf<Persons>() }
    val snackbarHostState = remember {SnackbarHostState()}
    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = true) {
        val p1 = Persons(1,"Zehra","4444")
        val p2 = Persons(2,"Ayca","5555")
        val p3 = Persons(3,"Mert","6666")
        persons.add(p1)
        persons.add(p2)
        persons.add(p3)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    if(isSearched.value){
                        TextField(
                            value = tf.value,
                            onValueChange = {
                                tf.value=it
                                search(it)
                            },
                            label = { Text(text = "Search")},
                            colors = TextFieldDefaults.colors(
                                unfocusedContainerColor = Color.Transparent,
                                focusedContainerColor = Color.Transparent,
                                disabledContainerColor = Color.Transparent,
                                disabledIndicatorColor = Color.Transparent,
                                disabledLabelColor = Color.Black,
                                disabledTextColor = Color.Blue
                            )
                        )
                    }else{
                        Text(text = "Persons")
                    }
            },
                actions = {
                    if(isSearched.value){
                        IconButton(
                            onClick = {
                                isSearched.value=false
                                tf.value=""
                        }) {
                            Icon(painter = painterResource(id = R.drawable.baseline_close_24), contentDescription = "")
                        }
                    }else{
                        IconButton(
                            onClick = {
                                isSearched.value=true
                            }) {
                            Icon(painter = painterResource(id = R.drawable.baseline_search_24), contentDescription = "")
                        }
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("savepage")
                },
                content = {
                    Icon(painter = painterResource(id = R.drawable.baseline_add_24), contentDescription = "")
                }
            )
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) {paddingValues ->

            LazyColumn(
                Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
            ) {
                items(
                    count = persons.count(),
                    itemContent = {
                        val person = persons[it]

                        Card(
                            onClick = {
                                val jsonPerson = Gson().toJson(person)
                                navController.navigate("detailspage/$jsonPerson")
                            },//Sayfa Gecisi
                            modifier = Modifier.padding(5.dp)
                        ) {
                            Row(
                                Modifier
                                    .padding(10.dp)
                                    .fillMaxWidth(),
                                Arrangement.SpaceBetween,
                                Alignment.CenterVertically
                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.SpaceEvenly
                                ) {
                                    Text(text = person.person_name, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                                    Spacer(modifier = Modifier.size(5.dp))
                                    Text(text = person.person_phone, fontSize = 18.sp, fontWeight = FontWeight.Medium)
                                }
                                IconButton(
                                    onClick = {

                                        scope.launch {
                                            val sb = snackbarHostState.showSnackbar("Do you want to delete this person", actionLabel = "Yes",withDismissAction = true)

                                            if (sb == SnackbarResult.ActionPerformed){
                                                deletePerson(person.person_id)
                                                snackbarHostState.showSnackbar("Deleted")
                                            }else if(sb == SnackbarResult.Dismissed){
                                                snackbarHostState.showSnackbar("Canceled")
                                            }
                                        }
                                    }) {
                                    Icon(painter = painterResource(id = R.drawable.baseline_close_24), contentDescription = "")
                                }
                            }
                        }
                    }
                )
            }
    }
}

fun deletePerson(person_id:Int) {
    Log.e("Delete","Deleted:$person_id")
}

fun search(searchedWord: String) {
    Log.e("Search","Searched:$searchedWord")
}
