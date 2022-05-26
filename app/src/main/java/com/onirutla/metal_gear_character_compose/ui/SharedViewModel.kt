package com.onirutla.metal_gear_character_compose.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.onirutla.metal_gear_character_compose.data.MetalGearCharacter

class SharedViewModel : ViewModel() {
    var character by mutableStateOf(MetalGearCharacter())

}