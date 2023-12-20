package com.coinsimulation.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.coinsimulation.R
import com.coinsimulation.api.model.KakaoLoginModel
import com.coinsimulation.ui.theme.Typography

@Composable
fun LoginPage(
    navController: NavController,
    kakaoLoginModel: KakaoLoginModel
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            //로고
            Image(
                painter = painterResource(id = R.drawable.logo1),
                contentDescription = "사진",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(200.dp)
                    .clip(RoundedCornerShape(16.dp)),
            )
//            Spacer(Modifier.height(16.dp))

            //제목
            Text(
                text = "Coin Simulation",
                style = Typography.titleLarge
            )
//            Spacer(Modifier.height(16.dp))

            //부연 설명
            Text(
                text = "Practice Investing Coins\nUsing This App",
                style = Typography.bodyLarge,
                modifier = Modifier.padding(horizontal = 16.dp),
                textAlign = TextAlign.Center
            )

            //카카오 로그인 버튼
            Image(
                painter = painterResource(id = R.drawable.kakao_login),
                contentDescription = "카카오 로그인 이미지",
                modifier = Modifier
                    .height(100.dp)
                    .size(300.dp) // 이미지의 크기를 200.dp로 조절
                    .align(Alignment.CenterHorizontally) // 이미지를 가운데로 정렬
                    .clickable {
                        kakaoLoginModel.handleKakaoLogin()
//                        navController.navigate(route = Screen.Main.route)
                    }
            )
        }
    }
}
