package com.zeus.rickandmorty.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.zeus.domain.models.Character
import com.zeus.presentation.viewmodel.HomeViewModel
import com.zeus.rickandmorty.R
import com.zeus.rickandmorty.ui.components.CharacterItem
import com.zeus.rickandmorty.ui.components.ErrorMessage
import com.zeus.rickandmorty.ui.components.FullScreenLoading
import kotlinx.coroutines.delay

@Composable
fun HomeScreen(
    onItemClicked: (String) -> Unit,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val state = viewModel.state.observeAsState()
    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(true) {
        viewModel.getCharacters(false)
    }
    LaunchedEffect(key1 = state.value?.showError) {
        delay(5000)
        viewModel.showError(false)
    }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            HomeToBar()
        },
        bottomBar = {
            HomeButtonBar(
                showPrevious = state.value?.showPrevious ?: false,
                showNext = state.value?.showNext ?: false,
                onPreviousPressed = { viewModel.getCharacters(false) },
                onNextPressed = { viewModel.getCharacters(true) },
            )
        },
    ) { padding ->
        HomeContent(
            modifier = Modifier.padding(padding),
            onItemClicked = onItemClicked,
            isLoading = state.value?.isLoading ?: true,
            characters = state.value?.characters ?: emptyList(),
        )
        ErrorMessage(
            modifier = Modifier.padding(padding),
            error = state.value?.errorString ?: "",
            state.value?.showError ?: false,
        )
    }
}

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    onItemClicked: (String) -> Unit,
    isLoading: Boolean = false,
    characters: List<Character> = emptyList(),
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colors.surface,
    ) {
        LazyColumn(
            contentPadding = PaddingValues(vertical = 6.dp),
            modifier = Modifier.fillMaxWidth(),
        ) {
            items(characters.size) { index ->
                CharacterItem(
                    modifier = Modifier.fillMaxWidth(),
                    item = characters[index],
                    onItemClicked = onItemClicked,
                )
            }
        }
        if (isLoading) {
            FullScreenLoading()
        }
    }
}

@Composable
fun HomeButtonBar(
    showPrevious: Boolean,
    showNext: Boolean,
    onPreviousPressed: () -> Unit,
    onNextPressed: () -> Unit,
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 2.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            TextButton(
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp),
                enabled = showPrevious,
                onClick = onPreviousPressed,
            ) {
                Text(text = stringResource(id = R.string.previous_button))
            }
            TextButton(
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp),
                enabled = showNext,
                onClick = onNextPressed,
            ) {
                Text(text = stringResource(id = R.string.next_button))
            }
        }
    }
}

@Composable
fun HomeToBar(
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.home_title),
                textAlign = TextAlign.Center,
                modifier = modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center),
            )
        },
        backgroundColor = MaterialTheme.colors.surface,
    )
}
