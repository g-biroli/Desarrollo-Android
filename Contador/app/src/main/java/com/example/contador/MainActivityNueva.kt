package com.example.contador

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.contador.R
import kotlin.math.*



class MainActivityNueva : AppCompatActivity(), View.OnClickListener {

    private lateinit var display: TextView
    private var expression = "" // Guarda la expresión matemática

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            setContentView(R.layout.activity_main)

            // Inicializa el campo de texto para mostrar la expresión y el resultado
            display = findViewById(R.id.display)

            // Configura los listeners de clic para cada botón
            configurarBotones()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    // Metodo para configurar los listeners de cada botón de la calculadora
    private fun configurarBotones() {
        // Botones de operaciones avanzadas
        findViewById<Button>(R.id.btnSin).setOnClickListener(this)
        findViewById<Button>(R.id.btnCos).setOnClickListener(this)
        findViewById<Button>(R.id.btnTan).setOnClickListener(this)
        findViewById<Button>(R.id.btnLog).setOnClickListener(this)

        // Botones de operaciones basicas
        findViewById<Button>(R.id.btnAdd).setOnClickListener(this)
        findViewById<Button>(R.id.btnSubtract).setOnClickListener(this)
        findViewById<Button>(R.id.btnMultiply).setOnClickListener(this)
        findViewById<Button>(R.id.btnDivide).setOnClickListener(this)

        // Botones numericos
        findViewById<Button>(R.id.btn0).setOnClickListener(this)
        findViewById<Button>(R.id.btn1).setOnClickListener(this)
        findViewById<Button>(R.id.btn2).setOnClickListener(this)
        findViewById<Button>(R.id.btn3).setOnClickListener(this)
        findViewById<Button>(R.id.btn4).setOnClickListener(this)
        findViewById<Button>(R.id.btn5).setOnClickListener(this)
        findViewById<Button>(R.id.btn6).setOnClickListener(this)
        findViewById<Button>(R.id.btn7).setOnClickListener(this)
        findViewById<Button>(R.id.btn8).setOnClickListener(this)
        findViewById<Button>(R.id.btn9).setOnClickListener(this)
        findViewById<Button>(R.id.btnDecimal).setOnClickListener(this)
        findViewById<Button>(R.id.btnClear).setOnClickListener(this)
        findViewById<Button>(R.id.btnEquals).setOnClickListener(this)
    }

    // Metodo que maneja los eventos de clic para cada boton
    override fun onClick(v: View?) {
        when (v?.id) {
            // Operaciones avanzadas
            R.id.btnSin -> agregarAExpresion("sin(")
            R.id.btnCos -> agregarAExpresion("cos(")
            R.id.btnTan -> agregarAExpresion("tan(")
            R.id.btnLog -> agregarAExpresion("log(")

            // Operaciones basicas
            R.id.btnAdd -> agregarAExpresion("+")
            R.id.btnSubtract -> agregarAExpresion("-")
            R.id.btnMultiply -> agregarAExpresion("*")
            R.id.btnDivide -> agregarAExpresion("/")

            // Numeros y punto
            R.id.btn0 -> agregarAExpresion("0")
            R.id.btn1 -> agregarAExpresion("1")
            R.id.btn2 -> agregarAExpresion("2")
            R.id.btn3 -> agregarAExpresion("3")
            R.id.btn4 -> agregarAExpresion("4")
            R.id.btn5 -> agregarAExpresion("5")
            R.id.btn6 -> agregarAExpresion("6")
            R.id.btn7 -> agregarAExpresion("7")
            R.id.btn8 -> agregarAExpresion("8")
            R.id.btn9 -> agregarAExpresion("9")
            R.id.btnDecimal -> agregarAExpresion(".")

            // limpia la expresion
            R.id.btnClear -> {
                expression = ""
                display.text = "0"
            }

            // calcula el resultado de la expresion
            R.id.btnEquals -> calcularResultado()
        }
    }

    // funcion para agregar texto a la expresion y mostrarlo en el campo de texto
    private fun agregarAExpresion(valor: String) {
        expression += valor
        display.text = expression
    }

    // Función para calcular el resultado de la expression
    private fun calcularResultado() {
        try {
            // Evalua la expresion ingresada y muestra el resultado
            val resultado = evaluar(expression)
            display.text = resultado.toString()
            expression = resultado.toString() // actualiza la expresion con el resultado
        } catch (e: Exception) {
            display.text = "Error"
            expression = ""
        }
    }

    // Función simplificada para evaluar expresiones con funciones científicas
    private fun evaluar(expresion: String): Double {
        return when {
            "sin" in expresion -> sin(expresion.removePrefix("sin(").toDouble())
            "cos" in expresion -> cos(expresion.removePrefix("cos(").toDouble())
            "tan" in expresion -> tan(expresion.removePrefix("tan(").toDouble())
            "log" in expresion -> log10(expresion.removePrefix("log(").toDouble())
            else -> expresion.toDouble()
        }
    }
}
