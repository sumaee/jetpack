package com.example.jetpackpractice.nav

import com.example.jetpackpractice.R

sealed class BottomNavItem(
    var title: Int,
    var icon: Int,
    var screenRoute: String
) {
    object Main : BottomNavItem(R.string.text_Main, R.drawable.baseline_home_24, Screen.Main.route)
    object ProductDetail :
        BottomNavItem(R.string.text_Detail, R.drawable.baseline_ssid_chart_24, Screen.Detail.route)

    object Bookmark : BottomNavItem(
        R.string.text_Bookmark,
        R.drawable.baseline_bookmark_24,
        Screen.Bookmark.route
    )

    object Mypage :
        BottomNavItem(R.string.text_Mypage, R.drawable.baseline_person_24, Screen.MyPage.route)

}