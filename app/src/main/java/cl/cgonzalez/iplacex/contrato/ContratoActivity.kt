package cl.cgonzalez.iplacex.contrato


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class ContratoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contrato)

        val btnVolver = findViewById<Button>(R.id.btnVolver)
        btnVolver.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val editSueldo = findViewById<EditText>(R.id.editSueldo)
        val textViewResultado = findViewById<TextView>(R.id.textResultado)

        btnCalcular.setOnClickListener {
            val sueldoStr = editSueldo.text.toString()

            val sueldo = (sueldoStr.toDoubleOrNull() ?: 0.0) / 1.2


            val resultado = String.format("%.0f", sueldo)

            textViewResultado.text = "El total a pagar es $$resultado"
        }
    }
}