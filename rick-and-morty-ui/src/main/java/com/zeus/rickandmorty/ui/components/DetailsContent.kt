package com.zeus.rickandmorty.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.zeus.domain.models.Character
import com.zeus.rickandmorty.R
import com.zeus.rickandmorty.utils.dateFormatter

@Composable
fun DetailsContent(
    modifier: Modifier,
    character: Character,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 15.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CharacterImageContainer(
            modifier = Modifier.size(200.dp),
        ) {
            CharacterImage(character = character)
        }
        Text(text = character.name, style = MaterialTheme.typography.h5)
        DetailRow(key = stringResource(id = R.string.creation_date), value = dateFormatter(character.created))
        DetailRow(key = stringResource(id = R.string.status), value = character.status)
        DetailRow(key = stringResource(id = R.string.specie), value = character.species)
        DetailRow(key = stringResource(id = R.string.type), value = character.type)
        DetailRow(key = stringResource(id = R.string.gender), value = character.gender)
        DetailRow(key = stringResource(id = R.string.origin), value = character.origin.name)
        DetailRow(key = stringResource(id = R.string.last_location), value = character.location.name)
    }
}
