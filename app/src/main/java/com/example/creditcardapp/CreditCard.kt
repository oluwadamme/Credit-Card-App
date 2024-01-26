package com.example.creditcardapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CreditCardUI(cardInfo: CardInfo) {
    Card(
        modifier = Modifier
            .height(200.dp),
        elevation = CardDefaults.elevatedCardElevation(10.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Box() {
            Image(
                painter = painterResource(id = cardInfo.backgroundImage),
                contentDescription = "Card Background",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize()
            )
            Box(modifier = Modifier.padding(16.dp) .fillMaxSize()) {
                Image(
                    painter = painterResource(id = cardInfo.providerImage),
                    contentDescription = "Provider Image",
                    modifier = Modifier
                        .width(86.dp)
                        .align(Alignment.TopStart)


                )
                Column(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                ) {


                    Text(text = cardInfo.cardNumber, fontSize = 16.sp, letterSpacing = 1.2.sp)
                    Text(text = cardInfo.cardHolder, fontSize = 16.sp, letterSpacing = 1.2.sp)
                }
            }

        }

    }
}