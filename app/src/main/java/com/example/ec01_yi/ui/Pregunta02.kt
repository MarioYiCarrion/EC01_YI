package com.example.ec01_yi.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun CalcularMenorScreen() {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(top = 25.dp)) {

        var num1 by rememberSaveable { mutableStateOf("") }
        var num2 by rememberSaveable { mutableStateOf("") }
        var num3 by rememberSaveable { mutableStateOf("") }
        var num4 by rememberSaveable { mutableStateOf("") }
        var resultado by rememberSaveable { mutableStateOf("") }

        Column {
            Text(
                text = "CALCULAR MENOR NÚMERO",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 30.sp)
            )
            MySpace1(16)
            OutlinedTextField(
                value = num1,
                onValueChange = { num1 = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese el número 1") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            MySpace1(16)
            OutlinedTextField(
                value = num2,
                onValueChange = { num2 = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese el número 2") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            MySpace1(16)
            OutlinedTextField(
                value = num3,
                onValueChange = { num3 = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese el número 3") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            MySpace1(16)
            OutlinedTextField(
                value = num4,
                onValueChange = { num4 = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese el número 4") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            MySpace1(16)
            Button(onClick = {
                resultado = try {
                    val num1Int = num1.toInt()
                    val num2Int = num2.toInt()
                    val num3Int = num3.toInt()
                    val num4Int = num4.toInt()
                    calcularMenor(num1Int, num2Int, num3Int, num4Int)
                } catch (e: NumberFormatException) {
                    "Por favor, ingrese valores numéricos válidos."
                }
            }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "CALCULAR")
            }
            MySpace1(16)
            Text(
                text = resultado,
                style = TextStyle(fontWeight = FontWeight.Bold, color = Color.DarkGray)
            )
        }
    }
}

@Composable
fun MySpace1(espacio: Int) {
    Spacer(modifier = Modifier.size(espacio.dp))
}

fun calcularMenor(num1: Int, num2: Int, num3: Int, num4: Int): String {
    val menor = minOf(num1, num2, num3, num4)
    return "El menor número es $menor"
}


