package com.onirutla.metal_gear_character_compose.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun CharacterCard(
    @DrawableRes image: Int,
    name: String,
    description: String,
    onCardClick: () -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onCardClick() }
            .padding(
                bottom = 8.dp,
                start = 8.dp,
                end = 8.dp
            )
    ) {
        Row {
            Image(
                modifier = Modifier
                    .size(width = 125.dp, height = 125.dp)
                    .padding(16.dp)
                    .clip(shape = RoundedCornerShape(50)),
                painter = painterResource(id = image),
                contentDescription = null
            )
            Column(Modifier.padding(top = 16.dp)) {
                Text(
                    text = name,
                    modifier = Modifier.padding(bottom = 8.dp),
                    style = MaterialTheme.typography.h5
                )
                Text(
                    text = description,
                    fontWeight = FontWeight.Light,
                    maxLines = 2,
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }
}