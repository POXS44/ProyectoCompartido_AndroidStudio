package com.poxs44.miapp20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.common.collect.Sets

class AgregarClientes : AppCompatActivity() {

    private lateinit var editTextTitulo : EditText
    private lateinit var editTextContenido : EditText
    private lateinit var btnCrearDatos : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_clientes)

        editTextTitulo = findViewById(R.id.editTextTitulo)
        editTextContenido = findViewById(R.id.editTextContenido)
        btnCrearDatos = findViewById(R.id.btnCrearDatos)

        btnCrearDatos.setOnClickListener(new viewOnclickLister )

    }
}