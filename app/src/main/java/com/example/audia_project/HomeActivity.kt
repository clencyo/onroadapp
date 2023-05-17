package com.example.audia_project

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val Sharepreferences = getSharedPreferences("shared_prefs", MODE_PRIVATE)
        val username = Sharepreferences.getString("username", "").toString()
        Toast.makeText(applicationContext, "welcome$username", Toast.LENGTH_SHORT).show()
        val exit = findViewById<CardView>(R.id.cardexit)
        exit.setOnClickListener {
            val editor = Sharepreferences.edit()
            editor.clear()
            editor.apply()
            startActivity(Intent(this@HomeActivity, LoginActivity::class.java))
        }
        val finddoctor = findViewById<CardView>(R.id.cardfinddoctor)
        finddoctor.setOnClickListener {
            startActivity(
                Intent(
                    this@HomeActivity,
                    Majour::class.java
                )
            )
        }
        val labtest = findViewById<CardView>(R.id.cardtest)
        labtest.setOnClickListener {
            startActivity(
                Intent(
                    this@HomeActivity,
                    Interim::class.java
                )
            )
        }
        val orderDetails = findViewById<CardView>(R.id.cardorderdetails)
        orderDetails.setOnClickListener {
            startActivity(
                Intent(
                    this@HomeActivity,
                    Crash::class.java
                )
            )
        }

        val buyMedicine = findViewById<CardView>(R.id.cardbuymedicine)
        buyMedicine.setOnClickListener {
            startActivity(
                Intent(
                    this@HomeActivity,
                   Full::class.java
                )
            )
        }

        val health = findViewById<CardView>(R.id.cardhealthArticles)
        health.setOnClickListener {
            startActivity(
                Intent(
                    this@HomeActivity,
                    Steering::class.java
                )
            )
        }

    }
}