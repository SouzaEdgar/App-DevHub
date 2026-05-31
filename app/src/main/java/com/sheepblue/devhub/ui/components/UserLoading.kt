package com.sheepblue.devhub.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sheepblue.devhub.R

@Composable
fun UserLoading() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
                .background(
                    Color.DarkGray,
                    shape = RoundedCornerShape(
                        bottomStart = 22.dp,
                        bottomEnd = 22.dp
                    )
                )
        ) {
            Image(
                painter = painterResource(
                    R.drawable.ic_sharp_account_circle_24
                ),
                contentDescription = "User Avatar",
                modifier = Modifier
                    .size(160.dp)
                    .align(Alignment.BottomCenter)
                    .offset(y = 120.dp / 2)
                    .clip(CircleShape)
            )
        }
        Spacer(modifier = Modifier.height(160.dp / 2))
        Text(
            text = "---",
            fontSize = 30.sp
        )
        Text(
            text = "--",
            fontWeight = FontWeight.Bold
        )
        Text(text = "-")
        Spacer(modifier = Modifier.height(40.dp / 2))
        Card(
            modifier = Modifier.padding(8.dp),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Column {
                Text(
                    text = "----",
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF2d333b))
                        .padding(8.dp),
                    fontSize = 24.sp,
                    color = Color.White
                )
                Text(
                    text = "----",
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                )
            }
        }
        Card(
            modifier = Modifier.padding(8.dp),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Column {
                Text(
                    text = "----",
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF2d333b))
                        .padding(8.dp),
                    fontSize = 24.sp,
                    color = Color.White
                )
                Text(
                    text = "----",
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                )
            }
        }
        Card(
            modifier = Modifier.padding(8.dp),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Column {
                Text(
                    text = "----",
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF2d333b))
                        .padding(8.dp),
                    fontSize = 24.sp,
                    color = Color.White
                )
                Text(
                    text = "----",
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserLoadingPreview() {
    UserLoading()
}
