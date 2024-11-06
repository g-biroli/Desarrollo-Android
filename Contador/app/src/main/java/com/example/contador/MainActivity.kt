package com.example.contador

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.contador.databinding.ActivityMainBinding
// Ponendo el metodo de ejecucion de button "OnClickListener"
class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var contador: Int = 0;

    // Asocia grafico y logico "onCreate"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        contador = savedInstanceState?.getInt("contador") ?: 0
        binding.textoContador.text = contador.toString()
        binding.btnIncremento.setOnClickListener(this)
        binding.btnDecremento.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        // Quien ha provocado el evento?
        when(v?.id){
            binding.btnIncremento.id->{
                //el contador se resta
                contador++;
            }
            binding.btnDecremento.id->{
                //el contador se suma
                contador--;
            }
        }
        binding.textoContador.text = contador.toString()
    }

    // Funcion para guardar la variable y no la perder despues de cambiar la pantalla de  direccion.
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("contador", contador)
    }
}