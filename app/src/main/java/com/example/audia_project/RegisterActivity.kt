package com.example.audia_project

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class RegisterActivity : AppCompatActivity() {

    lateinit var EDT_Username:EditText
    lateinit var TXT_Register:TextView
    lateinit var EDT_email:EditText
    lateinit var EDT_Password:EditText
    lateinit var  EDT_ConformPassword:EditText
    lateinit var BTN_Register:Button
    lateinit var TXT_account:TextView

    lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        EDT_Username = findViewById(R.id.edtuser)
        TXT_Register = findViewById(R.id.logo)
        EDT_email = findViewById(R.id.emailedit)
        EDT_Password = findViewById(R.id.inputPassword)
        EDT_ConformPassword = findViewById(R.id.inputComformPassword)
        BTN_Register = findViewById(R.id.btnRegister)
        TXT_account = findViewById(R.id.alreadyHaveAccount)


        BTN_Register.setOnClickListener {

            var name = EDT_Username.text.toString().trim()
            var email = EDT_email.text.toString().trim()
            var password = EDT_Password.text.toString().trim()
            var confirm = EDT_ConformPassword.text.toString().trim()
            var time_id = System.currentTimeMillis().toString()

            //progress bar
            var progress = ProgressDialog(this)
            progress.setTitle("Saving Data")
            progress.setMessage("Please Wait")

//validate

            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirm.isEmpty()) {

                Toast.makeText(this, "Cannot Submit an empty field", Toast.LENGTH_SHORT).show()
            }  else {

                var my_child = FirebaseDatabase.getInstance().reference.child("Names/" + time_id)
                var user_data = Users(name, email, password, confirm, time_id)

                //show progress
                progress.show()

                my_child.setValue(user_data).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(this, "Data Uploaded", Toast.LENGTH_SHORT).show()

                        //navigate
                        var gotoview = Intent(this, LoginActivity::class.java)
                        startActivity(gotoview)

                    } else {

                        Toast.makeText(this, "Failed to Upload Data", Toast.LENGTH_SHORT).show()

                    }


                }





            }}}}
