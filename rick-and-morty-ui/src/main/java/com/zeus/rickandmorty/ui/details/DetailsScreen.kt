package com.zeus.rickandmorty.ui.details

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.zeus.presentation.viewmodel.DetailsViewModel
import com.zeus.rickandmorty.R
import com.zeus.rickandmorty.ui.components.DetailsAppBar
import com.zeus.rickandmorty.ui.components.DetailsContent
import com.zeus.rickandmorty.ui.components.FullScreenLoading

@Composable
fun DetailsScreen(
    characterId: String,
    onBackClicked: () -> Unit,
    viewModel: DetailsViewModel = hiltViewModel()
) {
    val state by viewModel.state.observeAsState()

    LaunchedEffect(key1 = true) {
        viewModel.getCharacter(characterId)
    }

    Scaffold(
        topBar = {
            DetailsAppBar(
                title = stringResource(id = R.string.information),
                onBackClicked
            )
        },
        content = {
            if (state?.isLoading == true) {
                FullScreenLoading()
            } else {
                if (state?.character != null) {
                    DetailsContent(modifier = Modifier.padding(it), character = state?.character!!)
                }
            }
        }
    )
}
