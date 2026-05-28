package com.sheepblue.devhub.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.sheepblue.devhub.R
import com.sheepblue.devhub.ui.state.UserProfileUiState

@Composable
fun UserProfile(userInfos: UserProfileUiState) {
    Row {
        Column(
            modifier = Modifier.fillMaxWidth().verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
                .background(
                    Color.DarkGray,
                    shape = RoundedCornerShape(bottomStart = 22.dp, bottomEnd = 22.dp)
                )
            ) {
                AsyncImage(
                    model = userInfos.image,
                    placeholder = painterResource(R.drawable.ic_sharp_account_circle_24),
                    contentDescription = "User Avatar",
                    modifier = Modifier
                        .size(140.dp)
                        .align(Alignment.BottomCenter)
                        .offset(y = 120.dp/2)
                        .clip(CircleShape)
                )
            }
            Spacer(modifier = Modifier.height(120.dp/2))
            Text(
                userInfos.name,
                fontSize = 30.sp
            )
            Text(
                userInfos.login,
                fontWeight = FontWeight.Bold
            )
            Text(userInfos.bio)
            
        }
    }
}
