package com.example.katas.presentation.signup

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.katas.R
import com.example.data.model.local.AppDatabase
import com.example.data.model.local.entity.User
import com.example.katas.presentation.login.Login
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
@AndroidEntryPoint
class Registro : AppCompatActivity() {
    lateinit var inputNombre: EditText
    lateinit var inputCorreo: EditText
    lateinit var inputContrasena: EditText
    lateinit var buttonAceptarRegistro: Button
    private lateinit var btnRegresarLogin: ImageButton
    private lateinit var signUpViewModel: SignUpViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registro)


        signUpViewModel = ViewModelProvider(this)[SignUpViewModel::class.java]
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

        buttonAceptarRegistro.setOnClickListener {
            val name = inputNombre.text.toString()
            val email = inputCorreo.text.toString()
            val password = inputContrasena.text.toString()
            registerUser(name,email,password)
        }
        btnRegresarLogin.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }


    fun registerUser(name: String, email: String, password: String) {
        signUpViewModel.registerUser(name, email, password, { message ->
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            navigateToMainActivity()
        }, { message -> Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        })
    }


    fun validateInputs() {
        val nombre = inputNombre.text
        val correo = inputCorreo.text
        val contrasena = inputContrasena.text

        buttonAceptarRegistro.isEnabled =
            nombre.isNotEmpty() && correo.isNotEmpty() && contrasena.isNotEmpty()

        buttonAceptarRegistro.setBackgroundColor(
            if (buttonAceptarRegistro.isEnabled) getColor(R.color.blackButton) else getColor(
                R.color.grayButtonAndText
            )
        )
    }

    fun navigateToMainActivity() {
        val intent = Intent(this@Registro, Login::class.java)
        startActivity(intent)
        finish()

    }
}