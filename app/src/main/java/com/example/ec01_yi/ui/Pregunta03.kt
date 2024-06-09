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
fun MatriculaScreen() {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(top = 25.dp)) {

        var numMaterias by rememberSaveable { mutableStateOf("") }
        var resultado by rememberSaveable { mutableStateOf("") }

        Column {
            Text(
                text = "CÁLCULO DE MATRÍCULA",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 30.sp)
            )
            MySpace2(16)
            OutlinedTextField(
                value = numMaterias,
                onValueChange = { numMaterias = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese el número de materias") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            MySpace2(16)
            Button(onClick = {
                resultado = try {
                    val numMateriasInt = numMaterias.toInt()
                    calcularMatricula(numMateriasInt)
                } catch (e: NumberFormatException) {
                    "Por favor, ingrese un número válido de materias."
                }
            }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "CALCULAR")
            }
            MySpace2(16)
            Text(
                text = resultado,
                style = TextStyle(fontWeight = FontWeight.Bold, color = Color.DarkGray)
            )
        }
    }
}

@Composable
fun MySpace2(espacio: Int) {
    Spacer(modifier = Modifier.size(espacio.dp))
}

fun calcularMatricula(numMaterias: Int): String {
    val costoTodasMateria = 520
    val costoFinal = if (numMaterias > 5) {
        costoTodasMateria * 0.9
    } else {
        costoTodasMateria
    }
    return "El costo de la matrícula es S/ $costoFinal"
}
