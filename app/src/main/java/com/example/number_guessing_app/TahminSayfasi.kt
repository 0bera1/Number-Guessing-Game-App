package com.example.number_guessing_app

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlin.random.Random

@Composable
fun TahminSayfasi (navController : NavController) {
    val tfDegeri = remember {
        mutableStateOf("")
    }
    val rastgeleSayi = remember {
        mutableStateOf(0)
    }
    val chances = remember {
        mutableStateOf(3)
    }
    val yonlendirme = remember {
        mutableStateOf("")
    }
    Column (modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly) {
        
        LaunchedEffect(key1 = true) {
            rastgeleSayi.value = Random.nextInt(11)//0-10 arasında
        }
        
        Text(text = "Chances : ${chances.value}",
            fontSize =25.sp,
            color = Color.Red )
        Text(text = "Help : ${yonlendirme.value}",
            fontSize = 17.5.sp)
        TextField(value = tfDegeri.value,
            onValueChange = { tfDegeri.value = it},
            label = { Text(text = "Guess")})

        Button(onClick = {
            chances.value = chances.value - 1
            val tahmin =tfDegeri.value.toInt()

            if (tahmin == rastgeleSayi.value){
                navController.navigate("sonucSayfasi/true"){
                    popUpTo("tahminSayfasi"){inclusive=true}
                }
                return@Button
            }
            if (tahmin > rastgeleSayi.value){
                yonlendirme.value = "Please decrease the number"
            }
            if (tahmin < rastgeleSayi.value){
                yonlendirme.value = "Please increase the number"
            }
            if (chances.value == 0){
                navController.navigate("sonucSayfasi/false"){
                    popUpTo("tahminSayfasi"){inclusive=true}
                }
            }
            tfDegeri.value = ""
        }, modifier = Modifier.size(250.dp,50.dp)) {
                Text(text = "Check !")
        }
    }
}
