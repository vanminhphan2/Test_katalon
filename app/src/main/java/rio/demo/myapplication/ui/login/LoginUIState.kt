package rio.demo.myapplication.ui.login

data class LoginUIState (
    var email: String = "",
    var password: String = "",
    var isLoginSuccess: Boolean = false
    )