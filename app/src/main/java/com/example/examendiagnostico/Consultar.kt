package com.example.examendiagnostico

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Consultar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consultar)

        val herramientas: ArrayList<Herramientas>? = intent.getParcelableArrayListExtra("herramientas")

        if (herramientas == null || herramientas.isEmpty()) {
            Log.e("ConsultarActivity", "No se encontraron herramientas")
            Toast.makeText(this, "No hay herramientas disponibles", Toast.LENGTH_SHORT).show()
        } else {
            val textView: TextView = findViewById(R.id.edt_consulta)
            textView.text = herramientas.joinToString(separator = "\n\n") { herramienta ->
                "Herramienta: ${herramienta.herramienta}\n" +
                        "Tipo: ${herramienta.tipo}\n" +
                        "Tamaño: ${herramienta.tamano}\n" +
                        "Código: ${herramienta.codigo}\n" +
                        "Precio: ${herramienta.precio}"
            }
        }
    }
}
