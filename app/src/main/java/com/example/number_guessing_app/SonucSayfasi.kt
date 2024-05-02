package com.example.number_guessing_app

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController

@Composable
fun SonucSayfasi (Sonuc : Boolean, navController: NavController) {
    Column (modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly) {

        if (Sonuc){
            Text(text = "Kazandınız !")
            Image(painter = painterResource(id = R.drawable.gulenn_yuz) ,
                contentDescription = "")
        }else{
            Text(text = "Kaybettiniz !")
            Image(painter = painterResource(id = R.drawable.sad_yuz) ,
                contentDescription = "")
        }



    }
}