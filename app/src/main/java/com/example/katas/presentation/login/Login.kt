package com.example.katas.presentation.login

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.katas.ApplicationMain.Companion.prefs
import com.example.katas.presentation.MainActivity
import com.example.katas.R
import com.example.katas.presentation.signup.Registro
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class Login : AppCompatActivity() {
    private lateinit var editTextUsuario: EditText
    private lateinit var editTextContrasena: EditText
    private lateinit var ButtonLogin: Button
    private lateinit var LabelInvitado: TextView
    private lateinit var labelRegistrase : TextView
    private lateinit var loginViewModel: LoginViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkSession()
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        editTextUsuario = findViewById(R.id.usuario_input)
        editTextContrasena = findViewById(R.id.contrasena_input)
        ButtonLogin = findViewById(R.id.buttonLogin)
        LabelInvitado = findViewById(R.id.labeInvitado)
        labelRegistrase = findViewById(R.id.labelRegistrase)

        // verificar la sesion existente
        loginViewModel.checkSession {
            navigateToMainActivity()
        }


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
            val email = editTextUsuario.text.toString()
            val password = editTextContrasena.text.toString()
            loginUser(email,password)
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

    fun loginUser(email: String, password: String){
        loginViewModel.loginUSer(email,password,{message ->
            Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
            navigateToMainActivity()
        },{ message ->
            Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
        })

    }

    fun validateInputs() {
        val usuario = editTextUsuario.text.toString()
        val contrasena = editTextContrasena.text.toString()

        ButtonLogin.isEnabled = usuario.isNotEmpty() && contrasena.isNotEmpty()

        ButtonLogin.setBackgroundColor(if (ButtonLogin.isEnabled)getColor(R.color.blackButton) else getColor(
            R.color.grayButtonAndText
        ))


    }
    fun checkSession(){
        val email = prefs.getName()
        if(email.isNotEmpty()){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun navigateToMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()

    }
}