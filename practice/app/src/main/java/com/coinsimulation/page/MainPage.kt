package com.coinsimulation.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.coinsimulation.ui.theme.Typography


@Composable
fun MainPage(
) {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row {
            Text(text = "검색창", style = Typography.bodyLarge)
            Text(text = "알림버튼", style = Typography.bodyLarge)
        }
        Column {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {

                    Text(text = "Coins", style = Typography.bodyLarge)

                    CoinTable(coins = CoinList)

                    Spacer(Modifier.height(20.dp))

                    Text(text = "Ranking", style = Typography.bodyLarge)

                    RankingTable(ranks = RankingList)
                }
            }
        }
    }
}


data class Ranks(
    val img: String,
    val name: String,
    val coinValue: String,
)

val RankingList = listOf(
    Ranks("이미지", "Daniella", "$150.00"),
    Ranks("이미지", "John", "$120.00"),
    Ranks("이미지", "Martin", "$80.00"),
    Ranks("이미지", "Janice", "$50.00"),
    Ranks("이미지", "Daniella", "$30.00"),
    Ranks("이미지", "Dkrdj", "$20.00"),
    Ranks("이미지", "Tnakdl", "$10.00"),
    Ranks("이미지", "Dudwls", "$5.00"),
    Ranks("이미지", "Wjdals", "-$10.00"),
    Ranks("이미지", "Hey", "-$20.00"),
)

@Composable
fun RankingTable(ranks: List<Ranks>) {
    Box(
        modifier = Modifier
            .height(300.dp) // 스크롤 영역의 높이를 설정
            .fillMaxWidth()
    ) {
        LazyColumn {
            itemsIndexed(ranks) { idx, rank ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Text(
                        text = "${idx + 1}",
                        style = Typography.bodySmall,
                        modifier = Modifier.width(50.dp)
                    )
                    Text(
                        text = rank.img,
                        style = Typography.bodySmall,
                        modifier = Modifier.width(100.dp)
                    )
                    Text(
                        text = rank.name,
                        style = Typography.bodySmall,
                        modifier = Modifier.width(100.dp)
                    )
                    Text(
                        text = rank.coinValue,
                        style = Typography.bodySmall,
                        modifier = Modifier.width(100.dp)
                    )
                }
            }
        }
    }
}

data class Coins(
    val img: String,
    val coinName: String,
    val coinValue: String,
    val percentage: String
)

val CoinList = listOf(
    Coins("이미지", "BTC", "43,796.072", "+4.78%"),
    Coins("이미지", "ETH", "2,282.00", "+2.35%"),
    Coins("이미지", "BNB", "231.70", "-0.64%"),
    Coins("이미지", "BTC", "43,796.072", "+4.78%"),
    Coins("이미지", "ETH", "2,282.00", "+2.35%"),
    Coins("이미지", "BNB", "231.70", "-0.64%"),
    Coins("이미지", "BTC", "43,796.072", "+4.78%"),
    Coins("이미지", "ETH", "2,282.00", "+2.35%"),
    Coins("이미지", "BNB", "231.70", "-0.64%"),
    Coins("이미지", "BTC", "43,796.072", "+4.78%"),
    Coins("이미지", "ETH", "2,282.00", "+2.35%"),
    Coins("이미지", "BNB", "231.70", "-0.64%"),
)

@Composable
fun CoinTable(coins: List<Coins>) {
    Box(
        modifier = Modifier
            .height(200.dp) // 스크롤 영역의 높이를 설정
            .fillMaxWidth()
    ) {
        LazyColumn {
            items(coins) { coin ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                ) {
                    Text(
                        text = coin.img,
                        style = Typography.bodySmall,
                        modifier = Modifier.width(100.dp)
                    )
                    Text(
                        text = coin.coinName,
                        style = Typography.bodySmall,
                        modifier = Modifier.width(100.dp)
                    )
                    Text(
                        text = coin.coinValue,
                        style = Typography.bodySmall,
                        modifier = Modifier.width(100.dp)
                    )
                    Text(
                        text = coin.percentage,
                        style = Typography.bodySmall,
                        modifier = Modifier.width(100.dp)
                    )
                }
            }
        }
    }
}


