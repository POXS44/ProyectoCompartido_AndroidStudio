package com.poxs44.miapp20

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AgregarClientes : AppCompatActivity() {

    private lateinit var mEditTextTitulo : EditText
    private lateinit var mEditTextContenido : EditText
    private lateinit var mButtonCrearDatos : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_clientes)

    }


}