package com.example.ec01_yi.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalcularCuadradoMitadScreen() {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(top = 25.dp)) {

        var mostrarResultados by rememberSaveable { mutableStateOf(false) }
        var resultados by rememberSaveable { mutableStateOf(emptyList<String>()) }

        Column {
            Text(
                text = "CUADRADO Y MITAD DE NÚMEROS ENTRE 15 Y 70",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 24.sp)
            )
            MySpace(16)
            Button(
                onClick = {
                    mostrarResultados = true
                    resultados = calcularCuadradoMitad()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "CALCULAR")
            }
            MySpace3(16)
            if (mostrarResultados) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize().padding(16.dp)
                ) {
                    items(resultados) { resultado ->
                        Text(text = resultado, style = TextStyle(fontSize = 16.sp))
                        MySpace(8)
                    }
                }
            }
        }
    }
}

@Composable
fun MySpace3(espacio: Int) {
    Spacer(modifier = Modifier.size(espacio.dp))
}

fun calcularCuadradoMitad(): List<String> {
    val numeros = (15..70).toList()
    return numeros.map { numero ->
        val cuadrado = numero * numero
        val mitad = numero / 2.0
        "Número: $numero, Cuadrado: $cuadrado, Mitad: $mitad"
    }
}

