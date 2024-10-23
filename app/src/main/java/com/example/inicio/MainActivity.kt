package com.example.inicio

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.inicio.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.botonLogin.setOnClickListener (this) //-> Creando la funcion del boton (BotonLogin)
        binding.botonClear.setOnClickListener (this)



    }
    override fun onClick(v: View?) {
        //Aciones por detras del boton
        lateinit var intent: Intent
        when(v?.id){
            binding.botonLogin.id->{
                //Acion del boton Login
                val intent = Intent(applicationContext, HomeActivity::class.java);
                startActivity(intent)
            }
            binding.botonClear.id->{
                // Acion del boton clear (Salir)
            }
        }
    }
}