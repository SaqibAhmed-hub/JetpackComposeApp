package com.example.composeactivity.nav

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.composeactivity.R
import com.example.composeactivity.viewModel.MainViewModel
import kotlinx.coroutines.launch

@Composable
fun Greeting(navController: NavController) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val result = remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val snakebarHostState = remember { SnackbarHostState() }
    var viewModel: MainViewModel = viewModel()

    result.value = email == "User" && password == "123"


    Box(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Logo",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Email*",
                modifier = Modifier.padding(start = 8.dp, bottom = 4.dp),
                style = MaterialTheme.typography.subtitle1,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray, CircleShape),
                shape = CircleShape,
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Characters,
                    autoCorrect = false,
                    keyboardType = KeyboardType.Password
                ),
                placeholder = { Text(text = "Email") }
            )
            Text(
                text = "Password*",
                modifier = Modifier.padding(start = 8.dp, bottom = 4.dp, top = 8.dp),
                style = MaterialTheme.typography.subtitle1,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray, CircleShape),
                visualTransformation = PasswordVisualTransformation(),
                shape = CircleShape,
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Characters,
                    autoCorrect = false,
                    keyboardType = KeyboardType.Password
                ),
                placeholder = { Text(text = "Password") }
            )
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                OutlinedButton(
                    onClick = {
                        if (result.value) {
                            navController.navigate("details")
                        } else {
                            scope.launch {
                                snakebarHostState.showSnackbar(
                                    "Unable to Login"
                                )
                            }
                        }

                    },
                    modifier = Modifier
                        .width(200.dp)
                        .wrapContentHeight()
                        .padding(16.dp),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = "LOGIN")
                }
                SnackbarHost(hostState = snakebarHostState)
            }

        }
    }
}


