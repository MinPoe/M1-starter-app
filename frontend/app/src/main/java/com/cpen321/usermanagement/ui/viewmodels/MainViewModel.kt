package com.cpen321.usermanagement.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cpen321.usermanagement.data.remote.api.RetrofitClient
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class MainUiState(
    val successMessage: String? = null,
    val currentJoke: String? = null,
    val errorMessage: String? = null
)

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()
    private val jokeInterface = RetrofitClient.jokeInterface


    fun setSuccessMessage(message: String) {
        _uiState.value = _uiState.value.copy(successMessage = message)
    }

    fun clearSuccessMessage() {
        _uiState.value = _uiState.value.copy()
    }

    fun loadRandomJoke() {
        viewModelScope.launch {
            try {
                val response = jokeInterface.getRandomJoke()
                if (response.isSuccessful && response.body() != null) {
                    _uiState.value = _uiState.value.copy(
                        successMessage = "Here's a dad joke for you!",
                        currentJoke = response.body()!!.joke
                    )
                } else {
                    _uiState.value = _uiState.value.copy(
                        errorMessage = "Failed to fetch joke"
                    )
                }
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    errorMessage = "Network error: ${e.message}"
                )
            }
        }
    }
}
