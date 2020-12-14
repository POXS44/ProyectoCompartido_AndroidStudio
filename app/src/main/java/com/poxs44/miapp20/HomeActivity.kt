package com.poxs44.miapp20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

enum class ProviderType{
        BASIC
    }

class HomeActivity : AppCompatActivity() {

    private lateinit var closeButton: Button
    private lateinit var emailTextView: TextView
    private lateinit var providerTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Setup
        val bundle : Bundle? = intent.extras
        val email : String? = bundle?.getString("email")
        val provider : String? = bundle?.getString("provider")
        setup(email?:"",provider?:"")

    }

    private fun setup (email: String, provider: String){

        title = "Inicio"

        emailTextView = findViewById(R.id.emailTextView)
        providerTextView = findViewById(R.id.providerTextView)
        closeButton = findViewById(R.id.closeButton)

        emailTextView.text = email
        providerTextView.text = provider

        closeButton.setOnClickListener(){
            FirebaseAuth.getInstance().signOut()
            onBackPressed()
        }
    }
}