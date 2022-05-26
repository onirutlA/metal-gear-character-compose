package com.onirutla.metal_gear_character_compose.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.onirutla.metal_gear_character_compose.data.MetalGearCharacter

@Composable
fun DetailScreen(
    character: MetalGearCharacter,
    onIconButtonClick: () -> Unit,

    ) {
    val scrollState = rememberScrollState()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = character.name) },
                navigationIcon = {
                    IconButton(
                        onClick = onIconButtonClick,
                        modifier = Modifier.padding(start = 8.dp),
                    ) {
                        Icon(Icons.Filled.ArrowBack, null)
                    }
                },
            )
        },
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .verticalScroll(scrollState)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                painter = painterResource(id = character.image),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )
            Text(
                modifier = Modifier.padding(start = 16.dp, top = 16.dp),
                text = character.name,
                style = MaterialTheme.typography.h4,
                color = MaterialTheme.colors.onSurface,
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface,
                fontWeight = FontWeight.Normal,
                text = character.detail,
                textAlign = TextAlign.Justify
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 16.dp,
                        start = 16.dp,
                    ),
                text = "Biography",
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.onSurface,
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.onSurface,
                fontWeight = FontWeight.Light,
                text = character.biography,
                textAlign = TextAlign.Justify
            )
        }
    }
}