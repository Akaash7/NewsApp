package com.akash.newsappmm.ui.presentation.Components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Scale
import com.akash.newsappmm.domain.model.NewsResult

@Composable
fun GridNewsItem(
    titleText : String,
    description : String,
    onClick : ()->Unit
) {
        Box(modifier = Modifier
            .aspectRatio(1f)
            .padding(1.dp)
        ){
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                elevation = 10.dp,
                shape = RoundedCornerShape(10.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(4.dp)
                        .clickable {
                            onClick()
                        }
                )  {
                    Text(
                        modifier = Modifier
                            .padding(4.dp),
                        text = titleText,
                        style = TextStyle(
                            fontSize = 14.sp,
                            color = Color.Black
                        )
                    )
                    Spacer(modifier =Modifier.height(8.dp))
                    Text(
                        modifier = Modifier
                            .padding(4.dp),
                        text = description,
                        style = TextStyle(
                            fontSize = 14.sp,
                            color = Color.Gray
                        ),
                        maxLines = 4,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }

}