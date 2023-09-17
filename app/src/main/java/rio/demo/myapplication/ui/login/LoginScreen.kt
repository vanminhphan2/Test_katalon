package rio.demo.myapplication.ui.login

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import rio.demo.myapplication.R
import rio.demo.myapplication.ui.theme.bgLogin

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(viewModel: LoginViewModel = viewModel()) {
    val gameUiState by viewModel.uiState.collectAsState()
    val mediumPadding = dimensionResource(R.dimen.padding_medium)
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        viewModel
            .showT
            .collect { value ->
                if(value)
                Toast.makeText(
                    context,
                    "LOGIN SUCCESS",
                    Toast.LENGTH_SHORT,
                ).show()
                else
                    Toast.makeText(
                        context,
                        "LOGIN FAIL",
                        Toast.LENGTH_SHORT,
                    ).show()
            }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 20.dp),
        contentAlignment = Alignment.Center,
    ) {
        Card(elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)) {

            Surface(
                modifier = Modifier.fillMaxWidth(1.0f),
                color = bgLogin
            ) {
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .padding(mediumPadding),
                    verticalArrangement = Arrangement.spacedBy(mediumPadding),
                    horizontalAlignment = Alignment.CenterHorizontally

                    ) {
                    Text(
                        text = "LOGIN",
                        style = TextStyle(
                            fontSize = 30.sp, fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Italic
                        ),
                        modifier = Modifier.padding(PaddingValues(vertical = 30.dp))
                    )
                    OutlinedTextField(
                        value = viewModel.email,
                        maxLines = 1,
                        singleLine = true,
                        onValueChange = { newText ->
                            viewModel.updateEmail(newText)
                        },
                        label = { Text("Email") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Next)
                    )
                    OutlinedTextField(
                        value = viewModel.password,
                        maxLines = 1,
                        onValueChange = { newText ->
                            viewModel.updatePassword(newText)
                        },
                        label = { Text("Password") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Done)
                    )
                    Button(onClick = { viewModel.login() }) {
                        Text(text = "Login")
                    }
                }
            }
        }
    }
}