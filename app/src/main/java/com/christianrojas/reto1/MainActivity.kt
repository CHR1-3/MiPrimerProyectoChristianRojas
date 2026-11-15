package com.christianrojas.reto1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val etNombre = findViewById<android.widget.EditText>(R.id.etNombre)
        val btnGuardar = findViewById<android.widget.Button>(R.id.btnGuardar)
        val tvResultado = findViewById<android.widget.TextView>(R.id.tvResultado)

        btnGuardar.setOnClickListener {
            val nombre = etNombre.text.toString()
            tvResultado.text = "Hola $nombre, datos guardados."
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}