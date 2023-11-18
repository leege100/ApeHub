package com.avocado.apehub.core.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

enum class LoadStateEnum {
    NotBeginLoad,
    LoadedSuccess,
    LoadedError,
}

data class LoadableState<T>(
    val loadState: LoadStateEnum = LoadStateEnum.NotBeginLoad,
    val isLoading: Boolean = false,
    val data: T,
)

fun <T> LoadableState<T>.value(): T {
    return this.data
}

fun <T> LoadableState<T>.loading(): LoadableState<T> {
    return this.copy(isLoading = true)
}

fun <T> LoadableState<T>.loadedSuccess(): LoadableState<T> {
    return this.copy(loadState = LoadStateEnum.LoadedSuccess)
}

fun <T>LoadableState<T>.loadedError(): LoadableState<T> {
    return this.copy(loadState = LoadStateEnum.LoadedError)
}

fun <T> LoadableState<T>.dismissLoading(): LoadableState<T> {
    return this.copy(isLoading = false)
}

@Composable
fun <T> RefreshablePage(
    loadableState: LoadableState<T>,
    retry: (() -> Unit)? = null,
    errorPage: @Composable (() -> Unit)? = null,
    pageContent: @Composable (T) -> Unit,
) {
    Box(modifier = Modifier.fillMaxSize()) {
        when (loadableState.loadState) {
            LoadStateEnum.NotBeginLoad -> null
            LoadStateEnum.LoadedSuccess -> pageContent(loadableState.data)
            LoadStateEnum.LoadedError -> errorPage ?: ErrorPage(retry)
        }

        if (loadableState.isLoading) {
            LoadingUI(
                modifier = Modifier.fillMaxSize()
                    .align(Alignment.Center),
            )
        }
    }
}

@Composable
fun <T> LoadablePage(
    loadableState: LoadableState<T>,
    pageContent: @Composable (T) -> Unit,
) {
    val state = LoadableState(
        loadState = LoadStateEnum.LoadedSuccess,
        isLoading = loadableState.isLoading,
        data = loadableState.data,
    )
    RefreshablePage(state, null, null, pageContent)
}

@Composable
fun ErrorPage(retry: (() -> Unit)? = null) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("page load error")
        retry?.let {
            Button(
                onClick = { it() },
                content = {
                    Text("retry")
                },
            )
        }
    }
}
