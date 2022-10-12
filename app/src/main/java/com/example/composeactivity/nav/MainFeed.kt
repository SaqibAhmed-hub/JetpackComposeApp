package com.example.composeactivity.nav

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.composeactivity.data.Receipe
import com.example.composeactivity.viewModel.MainViewModel

@ExperimentalCoilApi
@Composable
fun MainFeed() {

    val viewModel: MainViewModel = viewModel(modelClass = MainViewModel::class.java)
    viewModel.getReceipeList()

    Box(modifier = Modifier.fillMaxSize()) {
        ReceipeList(viewModel.receipeResponse.value)
    }
}

@ExperimentalCoilApi
@Composable
fun ReceipeList(receipe: List<Receipe>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        itemsIndexed(items = receipe) { _, item ->
            MessageCard(receipe = item)
        }
    }
}

@ExperimentalCoilApi
@Composable
fun MessageCard(receipe: Receipe) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(4.dp),
        elevation = 10.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Surface {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Image(
                    painter = rememberImagePainter(
                        data = receipe.image_url
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .size(128.dp)
                        .align(Alignment.CenterHorizontally)
                )
                Text(
                    text = receipe.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = receipe.publisher,
                        modifier = Modifier
                            .padding(top = 8.dp, start = 8.dp),
                        fontSize = 16.sp
                    )
                    Text(
                        text = receipe.social_rank.toString(),
                        modifier = Modifier.padding(top = 8.dp),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold

                    )
                }

            }
        }

    }
}

@ExperimentalCoilApi
@Preview(showBackground = true)
@Composable
fun MessageCardView() {
    MessageCard(
        receipe = Receipe(
            title = "Best Pizza Dough Ever",
            image_url = "http://forkify-api.herokuapp.com/images/best_pizza_dough_recipe1b20.jpg",
            publisher = "101 Cookbooks",
            social_rank = 100.00,
            publisher_url = "http://www.101cookbooks.com",
            recipe_id = "46956",
            source_url = ""
        )
    )
}

