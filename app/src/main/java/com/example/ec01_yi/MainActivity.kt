package com.example.ec01_yi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ec01_yi.ui.CalcularCuadradoMitadScreen
import com.example.ec01_yi.ui.CalcularMenorScreen
import com.example.ec01_yi.ui.JubilacionScreen
import com.example.ec01_yi.ui.MatriculaScreen
import com.example.ec01_yi.ui.theme.EC01_YITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EC01_YITheme {
                PantallaPrincipal()
            }

        }
    }
}

@Composable
fun PantallaPrincipal(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home"){HomeScreen(navController)}
        composable("Jubilacion"){ JubilacionScreen()}
        composable("Calcular Numero Menor"){ CalcularMenorScreen()}
        composable("Calcular Matricula"){ MatriculaScreen()}
        composable("Calcular Cuadrado y Mitad"){ CalcularCuadradoMitadScreen()}
    }
}

@Composable
fun HomeScreen(navController: NavController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)){

        Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center) {
            Text(
                text = "Seleccione una opción",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 24.sp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { navController.navigate("Jubilacion") }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Verificar Jubilación")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { navController.navigate("Calcular Numero Menor") }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Calcular Menor Número")
            }
            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = { navController.navigate("Calcular Matricula") }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Calcular Matricula")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { navController.navigate("Calcular Cuadrado y Mitad") }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Calcular Cuadrado y Mitad")
            }
        }
    }
}

