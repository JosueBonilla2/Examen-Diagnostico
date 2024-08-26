package com.example.examendiagnostico

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class Menu : AppCompatActivity() {

    private lateinit var tool: Toolbar
    private lateinit var txtArreglo: TextView
    private var herramientas: ArrayList<Herramientas>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        tool = findViewById(R.id.toolbar)
        setSupportActionBar(tool)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val herramientasExtra = intent.getParcelableArrayListExtra<Herramientas>("herramientas")

        if (herramientasExtra != null) {
            herramientas = herramientasExtra
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.registrar -> {
                val intent = Intent(this, Registrar::class.java)
                startActivity(intent)
            }
            R.id.consultar -> {
                herramientas?.let {
                    val intent = Intent(this, Consultar::class.java)
                    intent.putParcelableArrayListExtra("herramientas", it)
                    startActivity(intent)
                } ?: run {
                    Toast.makeText(this, "No hay información para consultar", Toast.LENGTH_SHORT).show()
                }
            }
            R.id.salir -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}