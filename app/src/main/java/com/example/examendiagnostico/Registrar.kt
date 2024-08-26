package com.example.examendiagnostico

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class Registrar : AppCompatActivity() {

    private lateinit var edtHerramienta: EditText
    private lateinit var edtTipo: EditText
    private lateinit var edtTamano: EditText
    private lateinit var edtCodigo: EditText
    private lateinit var edtPrecio: EditText
    private lateinit var btnRegistrar: Button
    private lateinit var btnMenu: Button
    private lateinit var txtArreglo: TextView

    private var registroExitoso = false
    private val herramientas: ArrayList<Herramientas> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)

        edtHerramienta = findViewById(R.id.txt_herramienta)
        edtTipo = findViewById(R.id.txt_tipo)
        edtTamano = findViewById(R.id.txt_tamano)
        edtCodigo = findViewById(R.id.txt_codigo)
        edtPrecio = findViewById(R.id.txt_precio)
        btnRegistrar = findViewById(R.id.btn_registrar)
        btnMenu = findViewById(R.id.btn_menu)
        txtArreglo = findViewById(R.id.txt_arreglo)

        btnRegistrar.setOnClickListener {
            registrar()
        }

        btnMenu.setOnClickListener {
            regresarAlMenu()
        }
    }

    private fun registrar() {
        val nombreHerramienta = edtHerramienta.text.toString()
        val tipo = edtTipo.text.toString()
        val tamano = edtTamano.text.toString().toIntOrNull()
        val codigo = edtCodigo.text.toString().toIntOrNull()
        val precio = edtPrecio.text.toString().toFloatOrNull()

        if (nombreHerramienta.isNotEmpty() && tipo.isNotEmpty() && tamano != null && codigo != null && precio != null) {
            val herramienta = Herramientas(nombreHerramienta, tipo, tamano, codigo, precio)
            herramientas.add(herramienta)
            registroExitoso = true

            mostrarContenidoArreglo()

            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()
        } else {
            registroExitoso = false
            Toast.makeText(this, "Por favor complete todos los campos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun mostrarContenidoArreglo() {
        val contenido = herramientas.joinToString(separator = "\n") {
            "Herramienta: ${it.herramienta}, Tipo: ${it.tipo}, Tamaño: ${it.tamano}, Código: ${it.codigo}, Precio: ${it.precio}"
        }
        txtArreglo.text = contenido
    }

    private fun regresarAlMenu() {
        if (registroExitoso) {
            val intent = Intent(this, Menu::class.java)
            intent.putParcelableArrayListExtra("herramientas", herramientas)
            Log.d("RegistrarActivity", "Herramientas antes de regresar: $herramientas")
            startActivity(intent)  // Cambiado de setResult a startActivity
        } else {
            Toast.makeText(this, "No hay información para regresar", Toast.LENGTH_SHORT).show()
        }
    }
}
