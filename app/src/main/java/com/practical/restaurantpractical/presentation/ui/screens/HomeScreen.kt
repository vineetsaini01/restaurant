package com.practical.restaurantpractical.presentation.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.practical.restaurantpractical.presentation.ui.components.RestaurantItem
import com.practical.restaurantpractical.presentation.ui.theme.Orange
import com.practical.restaurantpractical.presentation.view_model.HomeViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    Scaffold {
        if (viewModel.homeResponseData != null) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Restaurant",
                        color = Orange,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    TextButton(
                        modifier = Modifier
                            .align(Alignment.CenterEnd),
                        onClick = { viewModel.isMenuExpanded = !viewModel.isMenuExpanded }) {
                        Text(
                            text = "No. of Record",
                            color = Orange
                        )
                    }

                    DropdownMenu(
                        expanded = viewModel.isMenuExpanded,
                        onDismissRequest = {

                            viewModel.isMenuExpanded = false
                        },
                        offset = DpOffset(270.dp, 0.dp)
                    ) {
                        DropdownMenuItem(
                            onClick = {
                                viewModel.onChanged(3)
                            },
                            text = { Text(text = "3") }
                        )
                        DropdownMenuItem(
                            onClick = {
                                viewModel.onChanged(7)
                            },
                            text = { Text(text = "7") }
                        )
                        DropdownMenuItem(
                            onClick = {
                                viewModel.onChanged(10)
                            },
                            text = { Text(text = "10") }
                        )
                        DropdownMenuItem(
                            onClick = {
                                viewModel.onChanged(15)
                            },
                            text = { Text(text = "15") }
                        )
                        DropdownMenuItem(
                            onClick = {
                                viewModel.onChanged(20)
                            },
                            text = { Text(text = "20") }
                        )
                    }
                }

                TextField(
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search, contentDescription = "Search"
                        )
                    },

                    trailingIcon = {
                        if (viewModel.searchText.isNotBlank()) {
                            IconButton(onClick = {
                                viewModel.onChangedSearchText("")
                            }) {
                                Icon(
                                    imageVector = Icons.Default.Close,
                                    contentDescription = "Add User"
                                )
                            }
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    value = viewModel.searchText,
                    onValueChange = viewModel::onChangedSearchText,
                )

                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    item {
                        Box(Modifier.padding(horizontal = 16.dp))
                    }
                    val size = viewModel.homeResponseData!!.Result!!.size
                    items(size) {
                        val data = viewModel.homeResponseData!!.Result!![it]
                        Column {
                            RestaurantItem(data)
                            if (it < size - 1) {
                                Divider(modifier = Modifier.padding(top = 16.dp))
                            }
                        }
                    }
                    item {
                        Box(Modifier.padding(horizontal = 16.dp))
                    }
                }
            }
        } else {
            Box(
                Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Loading...")
            }
        }
    }
}




