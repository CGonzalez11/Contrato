package cl.cgonzalez.iplacex.contrato

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class HonorariosActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Honorarios()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Honorarios() {
    val contexto = LocalContext.current
    val estadoInicial = ""
    val retencionHonorario = 1.13
    var sueldo by remember { mutableStateOf( estadoInicial) }
    var retencion by remember { mutableDoubleStateOf( retencionHonorario ) }
    var resultado by remember { mutableStateOf( estadoInicial ) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    )
    {
        Text(text = "Calcula los sueldos a Honorarios")
        TextField(
            value = sueldo,
            onValueChange = {sueldo = it},
            label = { Text(text = "Ingrese sueldo")},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )
        Button(onClick = {
            val sueldoHonorario = sueldo.toIntOrNull() ?: 0
            val retencionHonorario = retencion
            val total = calculaHonorarios(sueldoHonorario, retencionHonorario)
            resultado = "El total a pagar es $$total"
        }) {
            Text(text = "Calcular sueldo")
        }
        Text(text = resultado)
        Button(
            onClick = {
                val intent = Intent(contexto, MainActivity::class.java)
                contexto.startActivity( intent )},
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = "Volver")
        }
    }
}

fun calculaHonorarios(sueldo: Int, retencion: Double): Int {
    val resultado = sueldo / retencion
    return resultado.toInt() //
}
