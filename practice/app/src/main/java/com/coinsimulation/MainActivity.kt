package com.coinsimulation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.coinsimulation.api.model.KakaoLoginModel
import com.coinsimulation.nav.BottomNavigation
import com.coinsimulation.nav.NavGraph
import com.coinsimulation.page.MainPage
import com.coinsimulation.ui.theme.JetpackPracticeTheme


class MainActivity : ComponentActivity() {
    private lateinit var navHostController: NavHostController
    private val kakaoLoginModel: KakaoLoginModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navHostController = rememberNavController()
            Scaffold(bottomBar = { BottomNavigation(navController = navHostController) })
            {
                Box(modifier = Modifier.padding(it)) {
                    Surface(color = Color(0xFF161616)) {
                        NavGraph(
                            navController = navHostController,
                            kakaoLoginModel = kakaoLoginModel
                        )
                    }

                }
            }
        }
    }
}

//@Preview(
//    name = "로그인 페이지",
//    showBackground = true
//) // IDE 에서 미리보기를 위한 것
//@Composable
//fun PreviewLogin() {
//    JetpackPracticeTheme {
//        LoginPage()
//    }
//
//}
//
@Preview(
    name = "메인 페이지",
    showBackground = true
)
@Composable
fun PreviewMain() {
    JetpackPracticeTheme {
        MainPage()
    }
}