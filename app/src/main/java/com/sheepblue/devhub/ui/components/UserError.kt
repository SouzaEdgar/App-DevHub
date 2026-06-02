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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sheepblue.devhub.R

@Composable
fun UserError(onClick: () -> Unit) {
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
            Button(
                onClick = { onClick() },
                modifier = Modifier
                    .size(80.dp)
                    .padding(top = 3.dp, start = 1.dp)
                    .align(Alignment.TopStart),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = MaterialTheme.colorScheme.background
                )
            ) {
                Text(
                    text = "<",
                    fontWeight = FontWeight.Bold,
                    fontSize = 50.sp
                )
            }
            Box(
                modifier = Modifier
                    .size(160.dp)
                    .align(Alignment.BottomCenter)
                    .offset(y = 120.dp / 2)
                    .background(MaterialTheme.colorScheme.background, shape = CircleShape)
                    .clip(CircleShape)
            )
            Image(
                painter = painterResource(
                    R.drawable.ic_sharp_account_circle_24
                ),
                contentDescription = "User Avatar",
                colorFilter = ColorFilter.tint(Color.DarkGray),
                modifier = Modifier
                    .size(160.dp)
                    .align(Alignment.BottomCenter)
                    .offset(y = 120.dp / 2)
                    .clip(CircleShape)
            )
        }
        Spacer(modifier = Modifier.height(180.dp / 2))
        Text(
            text = "Não foi possível encontrar usuário",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun UserErrorPreview() {
    UserError(onClick = {})
}
