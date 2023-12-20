package com.coinsimulation.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.coinsimulation.api.model.KakaoLoginModel
import com.coinsimulation.page.BookmarkPage
import com.coinsimulation.page.DetailPage
import com.coinsimulation.page.LoginPage
import com.coinsimulation.page.MainPage
import com.coinsimulation.page.MyPage

@Composable
fun NavGraph(
    navController: NavHostController,
    kakaoLoginModel: KakaoLoginModel
) {
    NavHost(navController = navController, startDestination = Screen.Login.route) {
        composable(
            route = Screen.Login.route
        ) {
            LoginPage(
                navController = navController,
                kakaoLoginModel = kakaoLoginModel
            )
        }
        composable(BottomNavItem.Main.screenRoute) { MainPage() }
        composable(BottomNavItem.ProductDetail.screenRoute) { DetailPage() }
        composable(BottomNavItem.Bookmark.screenRoute) { BookmarkPage() }
        composable(BottomNavItem.Mypage.screenRoute) { MyPage() }
//        navigation(startDestination = Screen.Main.route, route = "Main") {
//            composable("Main/${BottomNavItem.Main.screenRoute}") {
//                Scaffold(bottomBar = { BottomNavigation(navController = navController) }) {
//                    Box(modifier = Modifier.padding(it)) {
//                        MainPage(navController = navController)
//                    }
//                }
//            }
//            composable("Main/${BottomNavItem.ProductDetail.screenRoute}") { DetailPage() }
//            composable("Main/${BottomNavItem.Bookmark.screenRoute}") { BookmarkPage() }
//            composable("Main/${BottomNavItem.Mypage.screenRoute}") { MyPage() }
//        }
    }
}