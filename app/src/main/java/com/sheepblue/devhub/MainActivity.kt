package com.sheepblue.devhub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sheepblue.devhub.ui.theme.DevHubTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DevHubTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        Row {
                            Column(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Box {
                                    Box(modifier = Modifier
                                        .fillMaxWidth()
                                        .height(120.dp)
                                        .background(Color.Blue)
                                    ) { }
                                    Image(
                                        modifier = Modifier
                                            .clip(CircleShape)
                                            .size(120.dp),
                                        painter = painterResource(id = R.drawable.ic_user_default),
                                        contentDescription = null
                                    )
                                }
                                Text(
                                    "Apelido do usuario",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 30.sp
                                )
                                Text(
                                    "Nome do usuario",
                                    fontWeight = FontWeight.Bold
                                )
                                Text("Descrição do usuario (BIO)")
                            }
                        }
                    }
                }
            }
        }
    }
}
