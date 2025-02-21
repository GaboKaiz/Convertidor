package com.example.conversorunidades.ui

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.conversorunidades.R

class ChatPrincipal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chat_principal)

        val iconoTemperatura = findViewById<ImageView>(R.id.iconoTemperatura)
        val iconoMoneda = findViewById<ImageView>(R.id.iconoMoneda)
        val iconoLongitud = findViewById<ImageView>(R.id.iconoLongitud)

        iconoTemperatura.setOnClickListener {
            startActivity(Intent(this, Temperatura::class.java))
        }

        iconoMoneda.setOnClickListener {
            startActivity(Intent(this, Moneda::class.java))
        }

        iconoLongitud.setOnClickListener {
            startActivity(Intent(this, Longitud::class.java))
        }
    }
}
