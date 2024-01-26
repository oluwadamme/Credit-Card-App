package com.example.creditcardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.creditcardapp.ui.theme.CreditCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CreditCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DisplayCards()
                }
            }
        }
    }
}

@Composable
fun DisplayCards() {
    val listOfCard = listOf(
        CardInfo(
            "Damilola Adeniyi",
            "0000 0000 0000 0000",
            R.drawable.verve,
            R.drawable.img
        ),
        CardInfo(
            "Femsasd dabdja",
            "0000 1111 0000 0000",
            R.drawable.visa,
            R.drawable.img_1
        ),
        CardInfo(
            "hsdhks dabdja",
            "0000 1111 2222 0000",
            R.drawable.mastercard,
            R.drawable.img_2
        ),
        CardInfo(
            "podp zbdj",
            "0000 1111 0000 3333",
            R.drawable.visa,
            R.drawable.img_3
        ),
    )
    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(listOfCard) {
            CreditCardUI(cardInfo = it)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CreditCardAppTheme {
        CreditCardUI(
            cardInfo = CardInfo(
                "Damilola Adeniyi",
                "0000 0000 0000 0000",
                R.drawable.verve,
                R.drawable.img
            )
        )
    }
}