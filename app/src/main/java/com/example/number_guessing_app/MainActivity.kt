package com.example.number_guessing_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.number_guessing_app.ui.theme.Number_Guessing_AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Number_Guessing_AppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    Gecis()
                }
            }
        }
    }
}
@Composable
fun Gecis (){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Anasayfa") {
        composable("anasayfa"){
            Anasayfa(navController = navController)
        }
        composable("tahminSayfasi"){
            TahminSayfasi(navController = navController)
        }
        composable("sonucSayfasi/{Sonuc}", arguments = listOf(
            navArgument("Sonuc"){type = NavType.BoolType}
        )){
            val Sonuc = it.arguments?.getBoolean("Sonuc")!!
            SonucSayfasi(Sonuc = Sonuc , navController = navController)
        }
    }
}

@Composable
fun Anasayfa(navController: NavController) {
    Column (modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Number Guessing Game",
            fontSize = 25.sp)
        Image(painter = painterResource(id = R.drawable.zar_resim),
            contentDescription = "")
        Button(onClick = {
            navController.navigate("tahminSayfasi")
        }, modifier = Modifier.size(250.dp,50.dp)){
            Text(text = "START !")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Number_Guessing_AppTheme {
    }
}