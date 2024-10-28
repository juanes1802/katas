package com.example.katas

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Login : AppCompatActivity() {
    private lateinit var editTextUsuario: EditText
    private lateinit var editTextContrasena: EditText
    private lateinit var ButtonLogin: Button
    private lateinit var LabelInvitado: TextView
    private lateinit var labelRegistrase : TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        editTextUsuario = findViewById(R.id.usuario_input)
        editTextContrasena = findViewById(R.id.contrasena_input)
        ButtonLogin = findViewById(R.id.buttonLogin)
        LabelInvitado = findViewById(R.id.labeInvitado)
        labelRegistrase = findViewById(R.id.labelRegistrase)


        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                validateInputs()
            }

            override fun afterTextChanged(p0: Editable?) {}


        }
        editTextUsuario.addTextChangedListener(textWatcher)
        editTextContrasena.addTextChangedListener(textWatcher)

        ButtonLogin.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        LabelInvitado.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        labelRegistrase.setOnClickListener{
            val intent = Intent(this, Registro::class.java)
            startActivity(intent)
        }


    }

    fun validateInputs() {
        val usuario = editTextUsuario.text.toString()
        val contrasena = editTextContrasena.text.toString()

        ButtonLogin.isEnabled = usuario.isNotEmpty() && contrasena.isNotEmpty()

        ButtonLogin.setBackgroundColor(if (ButtonLogin.isEnabled)getColor(R.color.blackButton ) else getColor(R.color.grayButtonAndText))


    }
}