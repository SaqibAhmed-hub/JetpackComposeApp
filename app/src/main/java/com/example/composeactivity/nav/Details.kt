package com.example.composeactivity.nav

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.composeactivity.ui.theme.ComposeActivityTheme

@Composable
fun DetailsScreen(navController: NavController) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Welcome to the MLKit",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 22.sp,
            modifier = Modifier.padding(8.dp)

        )
        Button(onClick = { navController.navigate("main")},
        modifier = Modifier.size(200.dp,50.dp)
            ) {
            Text(text = "Click Me")

        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { navController.navigate("design") },
            modifier = Modifier.size(200.dp,50.dp)
        ) {
            Text(text = "Another Screen")
        }
    }

}

//@Preview(showBackground = true, widthDp = 320, heightDp = 640)
//@Composable
//fun DefaultPreview() {
//    DetailsScreen(navController = NavController)
//}