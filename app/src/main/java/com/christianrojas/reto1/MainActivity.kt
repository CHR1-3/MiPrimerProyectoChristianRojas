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
        val cbAndroid = findViewById<android.widget.CheckBox>(R.id.cbAndroid)
        cbAndroid.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                tvResultado.text = "Has marcado Android"
            } else {
                tvResultado.text = "Has desmarcado Android"
            }
        }
        val swNotificaciones = findViewById<android.widget.Switch>(R.id.swNotificaciones)
        swNotificaciones.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                android.widget.Toast.makeText(this, "Notificaciones activadas", android.widget.Toast.LENGTH_SHORT).show()
            } else {
                android.widget.Toast.makeText(this, "Notificaciones desactivadas", android.widget.Toast.LENGTH_SHORT).show()
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}