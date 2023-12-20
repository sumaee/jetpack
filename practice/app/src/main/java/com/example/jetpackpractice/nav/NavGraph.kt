package com.example.jetpackpractice.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpackpractice.page.BookmarkPage
import com.example.jetpackpractice.page.DetailPage
import com.example.jetpackpractice.page.MainPage
import com.example.jetpackpractice.page.MyPage

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Screen.Main.route) {
//        composable(
//            route = Screen.Login.route
//        ) {
//            LoginPage(
//                navController = navController
//            )
//        }
        composable(BottomNavItem.Main.screenRoute) { MainPage(navController = navController) }
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