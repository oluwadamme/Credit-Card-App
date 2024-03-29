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
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
                    DisplayNav()
                }
            }
        }
    }
}

@Composable
fun DisplayCards(navController: NavController) {
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
        items(listOfCard) { it ->
            CreditCardUI(
                cardInfo = it,
                onClick = { navController.navigate(Destinations.CardScreen.toString() + "/${it.cardHolder}/${it.cardNumber}/${it.backgroundImage}/${it.providerImage}") })
        }
    }
}

@Composable
fun DisplayNav() {
    // Nav Controller: to keep track of the back stack of composable and the state of each one
    val navController = rememberNavController()

    // Nav Host: responsible for hosting the content of the destination
    NavHost(navController = navController, startDestination = Destinations.FirstScreen.toString()) {
        // Nav Graph Builder is used to add destination to the nav builder
        composable(Destinations.FirstScreen.toString()) {
            DisplayCards(navController)
        }
        composable(
            Destinations.CardScreen.toString() + "/{cardName}/{cardNumber}/{bgImg}/{proImg}"
        ) {
            val cardName = it.arguments?.getString("cardName").toString()
            val cardNumber = it.arguments?.getString("cardNumber").toString()
            val bgImg = it.arguments?.getString("bgImg")?.toInt()!!
            val proImg = it.arguments?.getString("proImg")?.toInt()!!
            CreditCardDetail(
                cardInfo = CardInfo(
                    cardNumber,
                    cardName,
                    proImg,
                    bgImg
                ),
                navController = navController,
            )
        }
    }

}

@Composable
fun CreditCardDetail(cardInfo: CardInfo, navController: NavController) {
    CreditCardUI(
        cardInfo,
        onClick = {
            navController.popBackStack(
                Destinations.FirstScreen.toString(),
                inclusive = false
            )
        })
}