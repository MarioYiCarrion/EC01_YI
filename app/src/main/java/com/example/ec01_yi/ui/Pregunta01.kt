package com.example.ec01_yi.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun JubilacionScreen() {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(top = 25.dp)) {

        var edad by rememberSaveable { mutableStateOf("") }
        var sexo by rememberSaveable { mutableStateOf("") }
        var resultado by rememberSaveable { mutableStateOf("") }

        Column {
            Text(
                text = "VERIFICACIÓN DE JUBILACIÓN",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 30.sp)
            )
            MySpace(16)
            OutlinedTextField(
                value = edad,
                onValueChange = { edad = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese su Edad") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            MySpace(16)
            OutlinedTextField(
                value = sexo,
                onValueChange = { sexo = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese su Sexo (hombre/mujer)") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
            MySpace(16)
            Button(onClick = {
                resultado = try {
                    val edadInt = edad.toInt()
                    determinarJubilacion(edadInt, sexo)
                } catch (e: NumberFormatException) {
                    "Por favor, ingrese una edad válida."
                }
            }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "VERIFICAR")
            }
            MySpace(16)
            Text(
                text = resultado,
                style = TextStyle(fontWeight = FontWeight.Bold, color = Color.DarkGray)
            )
        }
    }
}

@Composable
fun MySpace(espacio: Int) {
    Spacer(modifier = Modifier.size(espacio.dp))
}

fun determinarJubilacion(edad: Int, sexo: String): String {
    return if (sexo.lowercase() == "hombre") {
        if (edad >= 60) "Ya puede jubilarse." else "No puede jubilarse aún."
    } else if (sexo.lowercase() == "mujer") {
        if (edad > 54) "Ya puede jubilarse." else "No puede jubilarse aún."
    } else {
        "Sexo no válido. Por favor, ingrese 'hombre' o 'mujer'."
    }
}
