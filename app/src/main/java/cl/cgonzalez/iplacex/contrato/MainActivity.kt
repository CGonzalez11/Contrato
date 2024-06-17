package cl.cgonzalez.iplacex.contrato

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantallaInicio()
        }
    }
}

@Composable
@Preview
fun PantallaInicio() {
    val contexto = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(
            onClick = {
                val intent = Intent(contexto, HonorariosActivity::class.java)
                contexto.startActivity( intent )
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Calcular Honorarios")
        }
        Button(
            onClick = {
                val intent = Intent(contexto, ContratoActivity::class.java)
                contexto.startActivity( intent )
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Calcular Contrato")
        }
    }
}


