package com.example.videomessages.presenter.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.videomessages.data.model.request.LoginRequest
import com.example.videomessages.domain.repository.MainRepository
import com.example.videomessages.utils.UiState
import com.example.videomessages.utils.isConnected
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel(private val mainRepository: MainRepository) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<String>>(UiState.Empty)
    val uiState: StateFlow<UiState<String>> = _uiState

    fun userLogin(request: LoginRequest) {
        if (!isConnected()) {
            _uiState.value = UiState.NetworkError("Интернет не подключен!")
            return
        }
        _uiState.value = UiState.Loading
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = mainRepository.userLogin(request)
                _uiState.value = UiState.Success(result)
            } catch (error: Exception) {
                _uiState.value = UiState.Error(error.localizedMessage!!)
            }
        }
    }
}