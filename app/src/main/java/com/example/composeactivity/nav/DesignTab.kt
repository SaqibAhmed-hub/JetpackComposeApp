package com.example.composeactivity.nav

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.composeactivity.R

@Composable
fun DesignTab() {
    Column {

        Box {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(horizontal = 16.dp, vertical = 16.dp),
                color = Color.Gray.copy(alpha = 0.6f),
                shape = CircleShape
            ) {

            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.CenterHorizontally)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.gallery),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(200.dp)
                            .clip(CircleShape),

                        )
                    Text(
                        text = "Sample Food",
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            }
        }

        Column(modifier = Modifier.fillMaxWidth()) {
            val counter = remember { mutableStateOf(1) }

            Row {
                Button(onClick = { counter.value++ }) {
                    Text(text = "+")
                }
                Text(
                    text = "${counter.value}",
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp)
                )
                Button(onClick = { counter.value-- }) {
                    Text(text = "-")
                }
            }
        }
    }


}