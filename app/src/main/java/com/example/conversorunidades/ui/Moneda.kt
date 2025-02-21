package com.example.conversorunidades.ui

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.conversorunidades.R

class Moneda : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.moneda)

        val inputValor = findViewById<EditText>(R.id.inputValorMoneda)
        val spinnerEntrada = findViewById<Spinner>(R.id.spinnerEntradaMoneda)
        val spinnerSalida = findViewById<Spinner>(R.id.spinnerSalidaMoneda)
        val btnConvertir = findViewById<Button>(R.id.btnConvertirMoneda)
        val resultado = findViewById<TextView>(R.id.resultadoMoneda)
        val btnBorrar = findViewById<Button>(R.id.btnBorrarMoneda)
        val btnSalir = findViewById<Button>(R.id.btnSalirMoneda)

        // Lista de monedas y tasas de conversión (basado en 1 USD)
        val monedas = arrayOf(
            "Dólar (USD)", "Euro (EUR)", "Sol (PEN)", "Yen (JPY)", "Libra (GBP)",
            "Peso Mexicano (MXN)", "Real Brasileño (BRL)", "Dólar Canadiense (CAD)", "Dólar Australiano (AUD)", "Franco Suizo (CHF)",
            "Rublo Ruso (RUB)", "Peso Argentino (ARS)", "Won Surcoreano (KRW)", "Rupia India (INR)", "Yuan Chino (CNY)"
        )

        val tasasConversion = mapOf(
            "Dólar (USD)" to 1.0,
            "Euro (EUR)" to 0.92,
            "Sol (PEN)" to 3.70,
            "Yen (JPY)" to 150.0,
            "Libra (GBP)" to 0.79,
            "Peso Mexicano (MXN)" to 17.0,
            "Real Brasileño (BRL)" to 5.2,
            "Dólar Canadiense (CAD)" to 1.35,
            "Dólar Australiano (AUD)" to 1.55,
            "Franco Suizo (CHF)" to 0.91,
            "Rublo Ruso (RUB)" to 90.0,
            "Peso Argentino (ARS)" to 800.0,
            "Won Surcoreano (KRW)" to 1320.0,
            "Rupia India (INR)" to 83.0,
            "Yuan Chino (CNY)" to 7.2
        )

        // Adaptador para los Spinners
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, monedas)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerEntrada.adapter = adapter
        spinnerSalida.adapter = adapter

        btnConvertir.setOnClickListener {
            val valorTexto = inputValor.text.toString()
            if (valorTexto.isNotEmpty()) {
                val valor = valorTexto.toDouble()
                val monedaEntrada = spinnerEntrada.selectedItem.toString()
                val monedaSalida = spinnerSalida.selectedItem.toString()

                // Conversión a dólares
                val valorEnDolares = valor / tasasConversion[monedaEntrada]!!
                // Conversión a la moneda deseada
                val resultadoFinal = valorEnDolares * tasasConversion[monedaSalida]!!

                resultado.text = "Resultado: %.2f $monedaSalida".format(resultadoFinal)
            } else {
                Toast.makeText(this, "Ingrese un valor válido", Toast.LENGTH_SHORT).show()
            }
        }

        // Borrar los campos
        btnBorrar.setOnClickListener {
            inputValor.text.clear()
            resultado.text = "Resultado:"
        }

        // Salir de la actividad
        btnSalir.setOnClickListener {
            finish()
        }
    }
}
