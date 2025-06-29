package com.asociate.pj.noriabarrotes.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.asociate.pj.noriabarrotes.R
import com.asociate.pj.noriabarrotes.ui.theme.NoriAbarrotesTheme
import com.asociate.pj.noriabarrotes.ui.theme.tertiaryDark
import com.asociate.pj.noriabarrotes.ui.theme.tertiaryLight

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LoginCompose() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordHidden by remember { mutableStateOf(true) }

    NoriAbarrotesTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(tertiaryDark),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp, bottom = 20.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(tertiaryDark),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.dairy_products),
                    contentDescription = "Login Logo"
                )
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, top = 16.dp),
                    value = email,
                    onValueChange = { email = it },
                    singleLine = true,
                    label = { Text("Ingresa tu mail") }
                )
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, top = 5.dp),
                    value = password,
                    onValueChange = { password = it },
                    singleLine = true,
                    label = { Text("Ingresa tu contraseña") },
                    visualTransformation =
                        if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    trailingIcon = {
                        IconButton(onClick = { passwordHidden = !passwordHidden }) {
                            val visibilityIcon =
                                if (passwordHidden) painterResource(R.drawable.baseline_visibility_24)
                                else painterResource(R.drawable.baseline_visibility_off_24)
                            val description = if (passwordHidden) "Show password" else "Hide password"
                            Icon(painter = visibilityIcon, contentDescription = description)
                        }
                    }
                )
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp),
                    onClick = { },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(tertiaryLight)
                ) {
                    Text(
                        text = "Ingresar",
                        color = Color.White,
                        style = Typography().bodyLarge
                    )
                }
                Row {
                    Text(
                        text = "¿No tienes cuenta?",
                        style = Typography().bodyMedium,
                        textAlign = TextAlign.Center,
                        color = tertiaryLight
                    )
                    Text(
                        text = " Registrate",
                        style = Typography().bodyMedium,
                        textAlign = TextAlign.Center,
                        color = tertiaryLight
                    )
                }
            }
        }
    }
}