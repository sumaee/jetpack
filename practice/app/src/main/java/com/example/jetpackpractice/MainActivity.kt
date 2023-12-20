package com.example.jetpackpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackpractice.nav.NavGraph


class MainActivity : ComponentActivity() {
    private lateinit var navHostController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Surface(color = Color(0xFF161616)) {
                navHostController = rememberNavController()
                NavGraph(navController = navHostController)
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
//@Preview(
//    name = "메인 페이지",
//    showBackground = true
//)
//@Composable
//fun PreviewMain() {
//    JetpackPracticeTheme {
//        MainPage()
//    }
//}