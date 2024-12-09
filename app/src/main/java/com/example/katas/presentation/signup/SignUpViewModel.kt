package com.example.katas.presentation.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.singup.SignUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val signUpUseCase: SignUpUseCase) : ViewModel() {

    fun registerUser(name: String, email: String, password: String, onSuccess: (String) -> Unit, onError: (String) -> Unit){
        if (name.isEmpty() || email.isEmpty() || password.isEmpty()){
            onError("Por favor, complete todos los campos")
            return
        }
        viewModelScope.launch {
            val user = signUpUseCase.registerUser(name, email, password)
            if (user != null){
                onSuccess("Registro exitoso")
            }else{
                onError("Error al registrar")
            }

            }
    }
}