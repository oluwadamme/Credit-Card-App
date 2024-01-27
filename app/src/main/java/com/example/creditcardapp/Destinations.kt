package com.example.creditcardapp

sealed class Destinations(val route:String){
    object FirstScreen:Destinations("First Screen")
    object CardScreen:Destinations("Card Screen")
}
