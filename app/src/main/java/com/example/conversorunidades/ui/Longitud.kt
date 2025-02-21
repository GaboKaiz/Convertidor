package com.example.conversorunidades.ui

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.conversorunidades.R

class Longitud : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.longitud)

        val inputValor = findViewById<EditText>(R.id.inputValor)
        val spinnerEntrada = findViewById<Spinner>(R.id.spinnerEntrada)
        val spinnerSalida = findViewById<Spinner>(R.id.spinnerSalida)
        val btnConvertir = findViewById<Button>(R.id.btnConvertir)
        val resultado = findViewById<TextView>(R.id.resultado)
        val btnSalir = findViewById<Button>(R.id.btnsalir)
        val btnBorrarChat = findViewById<Button>(R.id.btnBorrarChat) // Nuevo botón

        // Opciones para los Spinners
        val unidades = arrayOf("Metros", "Kilómetros", "Millas", "Pies", "Pulgadas")
        val conversiones = mapOf(
            "Metros" to 1.0,
            "Kilómetros" to 0.001,
            "Millas" to 0.000621371,
            "Pies" to 3.28084,
            "Pulgadas" to 39.3701
        )

        // Adaptadores para los Spinners
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, unidades)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerEntrada.adapter = adapter
        spinnerSalida.adapter = adapter

        btnConvertir.setOnClickListener {
            val valorTexto = inputValor.text.toString()
            if (valorTexto.isNotEmpty()) {
                val valor = valorTexto.toDouble()
                val unidadEntrada = spinnerEntrada.selectedItem.toString()
                val unidadSalida = spinnerSalida.selectedItem.toString()

                // Conversión a metros
                val valorEnMetros = valor / conversiones[unidadEntrada]!!
                // Conversión a la unidad deseada
                val resultadoFinal = valorEnMetros * conversiones[unidadSalida]!!

                resultado.text = "Resultado: $resultadoFinal $unidadSalida"
            } else {
                Toast.makeText(this, "Ingrese un valor válido", Toast.LENGTH_SHORT).show()
            }
        }

        // Funcionalidad del botón "Borrar Chat"
        btnBorrarChat.setOnClickListener {
            inputValor.text.clear()  // Borra el texto del EditText
            resultado.text = "Resultado: "  // Restablece el TextView
        }

        // Funcionalidad del botón "Volver"
        btnSalir.setOnClickListener {
            finish() // Cierra esta actividad y vuelve a la anterior
        }
    }
}
