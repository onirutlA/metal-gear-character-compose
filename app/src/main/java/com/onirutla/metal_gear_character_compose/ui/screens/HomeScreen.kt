package com.onirutla.metal_gear_character_compose.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.onirutla.metal_gear_character_compose.HomeViewModel
import com.onirutla.metal_gear_character_compose.ui.SharedViewModel
import com.onirutla.metal_gear_character_compose.ui.components.CharacterCard

@Composable
fun HomeScreen(
    navHostController: NavHostController,
    viewModel: HomeViewModel = viewModel(),
    sharedViewModel: SharedViewModel
) {
    val characters by viewModel.characters.observeAsState()
    LazyColumn(contentPadding = PaddingValues(vertical = 10.dp)) {
        items(characters ?: emptyList()) { character ->
            CharacterCard(
                image = character.image,
                name = character.name,
                description = character.detail,
                onCardClick = {
                    sharedViewModel.character = character
                    navHostController.navigate(Screen.DetailScreen.route)
                }
            )
        }
    }
}