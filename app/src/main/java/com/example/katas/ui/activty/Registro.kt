package com.example.katas

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Registro : AppCompatActivity() {
    lateinit var inputNombre: EditText
    lateinit var inputCorreo: EditText
    lateinit var inputContrasena: EditText
    lateinit var buttonAceptarRegistro: Button
    private lateinit var  btnRegresarLogin : ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registro)
        inputNombre = findViewById(R.id.inputNombre)
        inputCorreo = findViewById(R.id.inputCorreo)
        inputContrasena = findViewById(R.id.inputContrasena)
        buttonAceptarRegistro = findViewById(R.id.buttonAceptarRegistro)
        btnRegresarLogin = findViewById(R.id.btnRegresarLogin)

        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                validateInputs()
            }

            override fun afterTextChanged(p0: Editable?) {}


        }
        inputNombre.addTextChangedListener(textWatcher)
        inputCorreo.addTextChangedListener(textWatcher)
        inputContrasena.addTextChangedListener(textWatcher)

        buttonAceptarRegistro.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        btnRegresarLogin.setOnClickListener{
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }

    fun validateInputs() {
        val nombre = inputNombre.text
        val correo = inputCorreo.text
        val contrasena = inputContrasena.text

        buttonAceptarRegistro.isEnabled = nombre.isNotEmpty() && correo.isNotEmpty() &&  contrasena.isNotEmpty()

        buttonAceptarRegistro.setBackgroundColor(
            if (buttonAceptarRegistro.isEnabled) getColor(R.color.blackButton) else getColor(
                R.color.grayButton
            )
        )
    }
}