package com.example.katas.presentation.profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.viewModels
import com.example.katas.ApplicationMain.Companion.prefs
import com.example.data.model.local.entity.User
import com.example.domain.model.UserDomain
import com.example.domain.usecase.login.LoginUseCase
import com.example.katas.databinding.FragmentPerfilBinding
import com.example.katas.presentation.login.Login
import com.example.katas.presentation.login.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PerfilFragment : Fragment() {

    private var _binding: FragmentPerfilBinding? = null
    private val binding get() = _binding!!
    private val loginViewModel: LoginViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el layout para este fragmento usando ViewBinding
        _binding = FragmentPerfilBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        GetName()


        ButtonLogoutAction()


    }

    private fun ButtonLogoutAction() {
        binding.Buttonlogout.setOnClickListener {
            // Acción a realizar al hacer clic en el botón
            logout()
        }
    }

    private fun GetName() {
        loginViewModel.getUserName { userName ->
            binding.TextNombrePerfil.text = userName ?: "Nombre no disponible "
        }
    }

    fun logout() {
        prefs.clearSession()
        val intent = Intent(requireContext(), Login::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        requireActivity().finish()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Evitar fugas de memoria
    }
}