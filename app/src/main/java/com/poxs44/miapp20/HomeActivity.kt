package com.poxs44.miapp20

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

enum class ProviderType{
        BASIC,
        GOOGLE
    }

class HomeActivity : AppCompatActivity() {

    private lateinit var closeButton: Button
    private lateinit var emailTextView: TextView
    private lateinit var providerTextView: TextView
    private lateinit var saveButton: Button
    private lateinit var getButton: Button
    private lateinit var deleteButton: Button
    private lateinit var addresssTextView: TextView
    private lateinit var phoneTextView: TextView

    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Setup
        val bundle : Bundle? = intent.extras
        val email : String? = bundle?.getString("email")
        val provider : String? = bundle?.getString("provider")
        setup(email?:"",provider?:"")

        // Guardado de datos

        val prefs = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
        prefs.putString("email",email)
        prefs.putString("provider",provider)
        prefs.apply()

    }

    private fun setup (email: String, provider: String){

        title = "Inicio"

        emailTextView = findViewById(R.id.emailTextView)
        providerTextView = findViewById(R.id.providerTextView)
        closeButton = findViewById(R.id.closeButton)
        saveButton = findViewById(R.id.saveButton)
        getButton = findViewById(R.id.getButton)
        deleteButton = findViewById(R.id.deleteButton)
        addresssTextView = findViewById(R.id.addressTextView)
        phoneTextView = findViewById(R.id.phoneTextView)

        emailTextView.text = email
        providerTextView.text = provider

        closeButton.setOnClickListener(){

            // Borrado de datos
            val prefs = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
            prefs.clear()
            prefs.apply()


            FirebaseAuth.getInstance().signOut()
            onBackPressed()
        }

        saveButton.setOnClickListener {

            db.collection("user").document(email).set(
                hashMapOf("provider" to provider,
                "address" to addresssTextView.text.toString(),
                "phone" to phoneTextView.text.toString() )
            )
        }
        getButton.setOnClickListener {

            db.collection("users").document(email).get().addOnSuccessListener {
                addresssTextView.setText(it.get("address") as String?)
                phoneTextView.setText(it.get("phone") as String?)

            }

        }
        deleteButton.setOnClickListener {
            db.collection("users").document(email).delete()
        }
    }
}