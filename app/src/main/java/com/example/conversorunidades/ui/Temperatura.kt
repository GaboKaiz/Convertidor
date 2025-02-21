package com.example.conversorunidades.ui

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.conversorunidades.R

class Temperatura : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.temperatura)

        val inputValor = findViewById<EditText>(R.id.inputValorTemperatura)
        val spinnerEntrada = findViewById<Spinner>(R.id.spinnerEntradaTemperatura)
        val spinnerSalida = findViewById<Spinner>(R.id.spinnerSalidaTemperatura)
        val btnConvertir = findViewById<Button>(R.id.btnConvertirTemperatura)
        val resultado = findViewById<TextView>(R.id.resultadoTemperatura)
        val btnBorrar = findViewById<Button>(R.id.btnBorrar)
        val btnVolver = findViewById<Button>(R.id.btnVolver)

        val unidades = arrayOf("Celsius", "Fahrenheit", "Kelvin", "Rankine")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, unidades)
        spinnerEntrada.adapter = adapter
        spinnerSalida.adapter = adapter

        btnConvertir.setOnClickListener {
            val valorTexto = inputValor.text.toString()

            if (valorTexto.isEmpty()) {
                Toast.makeText(this, "Ingrese un valor", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val valor = valorTexto.toDouble()
            val unidadEntrada = spinnerEntrada.selectedItem.toString()
            val unidadSalida = spinnerSalida.selectedItem.toString()

            val resultadoConversion = convertirTemperatura(valor, unidadEntrada, unidadSalida)
            resultado.text = "Resultado: $resultadoConversion $unidadSalida"
        }

        btnBorrar.setOnClickListener {
            inputValor.text.clear()
            resultado.text = "Resultado:"
        }

        btnVolver.setOnClickListener {
            finish()
        }
    }

    private fun convertirTemperatura(valor: Double, entrada: String, salida: String): Double {
        val enCelsius = when (entrada) {
            "Celsius" -> valor
            "Fahrenheit" -> (valor - 32) * 5 / 9
            "Kelvin" -> valor - 273.15
            "Rankine" -> (valor - 491.67) * 5 / 9
            else -> valor
        }

        return when (salida) {
            "Celsius" -> enCelsius
            "Fahrenheit" -> enCelsius * 9 / 5 + 32
            "Kelvin" -> enCelsius + 273.15
            "Rankine" -> (enCelsius + 273.15) * 9 / 5
            else -> enCelsius
        }
    }
}
