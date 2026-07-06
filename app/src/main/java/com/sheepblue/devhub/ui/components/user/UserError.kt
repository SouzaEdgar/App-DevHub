package com.sheepblue.devhub.ui.components.user

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.sheepblue.devhub.ui.components.common.BackButton

@Composable
fun UserError(
    onClick: () -> Unit,
    errorMessage: String
) {
    val avatarSize = 160.dp
    val avatarOffset = avatarSize / 2.5f

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(
                    color = MaterialTheme.colorScheme.error,
                    shape = RoundedCornerShape(
                        bottomStart = 22.dp,
                        bottomEnd = 22.dp
                    )
                )
        ) {
            // Background do avatar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .background(
                        color = MaterialTheme.colorScheme.surface,
                        shape = RoundedCornerShape(
                            bottomStart = 22.dp,
                            bottomEnd = 22.dp
                        )
                    )
            )
            // Contorno do avatar
            Box(
                modifier = Modifier
                    .size(size = avatarSize - 20.dp)
                    .offset(y = avatarOffset - 5.dp)
                    .align(Alignment.BottomCenter)
                    .clip(CircleShape)
                    .background(color = MaterialTheme.colorScheme.error)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .offset(y = 60.dp)
                    .align(Alignment.BottomCenter)
                    .background(color = MaterialTheme.colorScheme.background)
            )
            // auxilio para deixar fundo do avatar como background (cor)
            Box(
                modifier = Modifier
                    .size(size = 80.dp)
                    .offset(y = avatarOffset - 50.dp)
                    .align(Alignment.BottomCenter)
                    .clip(CircleShape)
                    .background(color = MaterialTheme.colorScheme.background)
            )
            Image(
                painter = painterResource(
                    R.drawable.ic_sharp_account_circle_24
                ),
                contentDescription = "User Avatar",
                colorFilter = ColorFilter.tint(Color.DarkGray),
                modifier = Modifier
                    .size(size = avatarSize)
                    .align(Alignment.BottomCenter)
                    .offset(y = avatarOffset)
                    .clip(CircleShape)
            )
            BackButton{ onClick() }
        }
        Spacer(modifier = Modifier.height(180.dp / 2))
        Text(
            text = errorMessage,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun UserErrorPreview() {
    UserError(
        onClick = {},
        errorMessage = "Mensagem de erro"
    )
}
