package com.example.jetpackpractice.nav

sealed class Screen(val route: String) {
    object Login : Screen(route = "Login_page")
    object Main : Screen(route = "Main_page")
    object Detail : Screen(route = "Detail_page")
    object MyPage : Screen(route = "MyPage")
    object Bookmark : Screen(route = "Bookmark_page")
}