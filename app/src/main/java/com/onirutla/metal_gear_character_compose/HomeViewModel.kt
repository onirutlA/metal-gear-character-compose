package com.onirutla.metal_gear_character_compose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.onirutla.metal_gear_character_compose.data.metalGearCharacters

class HomeViewModel : ViewModel() {
    val characters = liveData {
        emit(metalGearCharacters)
    }
}