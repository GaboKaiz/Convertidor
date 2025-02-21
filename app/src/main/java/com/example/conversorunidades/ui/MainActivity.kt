package com.example.conversorunidades.ui

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.conversorunidades.R
import com.example.conversorunidades.ui.ChatPrincipal
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Se debe llamar primero a la superclase
        setContentView(R.layout.activity_main) // Se carga el layout antes de acceder a las vistas

        // Obtener referencias después de setContentView
        val logo = findViewById<ImageView>(R.id.imgLogo)
        val titulo = findViewById<TextView>(R.id.txtTitulo)

        // Cargar animación
        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        logo.startAnimation(fadeIn)
        titulo.startAnimation(fadeIn)

        // Redirigir después de 3 segundos
        lifecycleScope.launch {
            delay(3000)
            startActivity(Intent(this@MainActivity, ChatPrincipal::class.java))
            finish()
        }
    }
}
