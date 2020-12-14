package com.poxs44.miapp20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics


class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

    // Analytics Event
    val analytics:FirebaseAnalytics = FirebaseAnalytics.getInstance(this)
    val bundle = Bundle()
    bundle.putString("message","Integración de Firebase completa")
        analytics.logEvent("InitScreen", bundle)

        //Setup
        setup ()
    }

    private fun setup (){
        title = "Autenticación"



    }

}

