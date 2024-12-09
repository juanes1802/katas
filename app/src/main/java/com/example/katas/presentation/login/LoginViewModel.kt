package com.example.katas.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.login.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase): ViewModel(){

    fun loginUSer(email: String, password: String,onSuccess: (String) -> Unit, onError: (String) -> Unit){
     viewModelScope.launch {
        val user = loginUseCase.login(email,password,)
         if (user != null){
             loginUseCase.saveSession(
                 email)
             onSuccess("Bienvenido, ${user.name}")
             }else{
             onError("Credenciales incorrectas")

         }


        }


    }

    fun checkSession(onSessionExists: () -> Unit){
        val email = loginUseCase.getSession()
        if(email.isNotEmpty()){
            onSessionExists()
        }

    }

}