package com.example.jetpackpractice

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackpractice.ui.theme.JetpackPracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Login(
                Modifier
                    .fillMaxSize()
            )
        }
    }
}

@Composable
fun Login(modifier: Modifier) {

    //로그인 버튼 클릭 되는지 확인하려는 용도
    var showDialog by remember { mutableStateOf(false) }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Column {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                //로고
                Image(
                    painter = painterResource(id = R.drawable.logo1),
                    contentDescription = "사진",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(200.dp)
                        .clip(RoundedCornerShape(16.dp)),
                )
                Spacer(Modifier.height(16.dp))
                Text(text = "Coin Simulation", fontSize = 50.sp, color = Color.White)
                Spacer(Modifier.height(16.dp))
                Text(
                    text = "Practice Investing Coins\nUsing This App",
                    fontSize = 26.sp,
                    color = Color.White,
                    modifier = Modifier.padding(horizontal = 16.dp),
                    textAlign = TextAlign.Center
                )
            }
            Image(painter = painterResource(id = R.drawable.kakao_login),
                contentDescription = "카카오 로그인 이미지",
                modifier = Modifier
                    .height(100.dp)
                    .size(300.dp) // 이미지의 크기를 200.dp로 조절
                    .align(Alignment.CenterHorizontally) // 이미지를 가운데로 정렬
                    .clickable { showDialog = true })

            if (showDialog) {
                AlertDialog(
                    title = { Text(text = "카카오 로그인 버튼 누름") },
                    text = { Text("카카오 로그인 눌렀자나") },
                    onDismissRequest = { showDialog = false },
                    confirmButton = {
                        Button(onClick = { showDialog = false }) {
                            Text(text = "로그인~")
                        }
                    })
            }
        }
    }
}

@Preview(
    showBackground = true
) // IDE 에서 미리보기를 위한 것
@Composable
fun GreetingPreview() {
    JetpackPracticeTheme {
        Login(
            Modifier
                .fillMaxSize()
        )
    }

}