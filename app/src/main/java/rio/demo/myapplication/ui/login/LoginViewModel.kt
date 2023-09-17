package rio.demo.myapplication.ui.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(LoginUIState())
    val uiState: StateFlow<LoginUIState> = _uiState.asStateFlow()
    private val _showT = MutableSharedFlow<Boolean>()
    val showT: SharedFlow<Boolean> = _showT.asSharedFlow()
    var email by mutableStateOf("")
        private set
    var password by mutableStateOf("")
        private set

    fun login() {
        _uiState.value.isLoginSuccess = email == "rio@gmail.com" && password == "123123"
        viewModelScope.launch {
            _showT.emit(_uiState.value.isLoginSuccess)
        }
    }

    fun updateEmail(newEmail: String) {
        email = newEmail
    }

    fun updatePassword(newPassword: String) {
        password = newPassword
    }
}