package com.example.videomessages

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.videomessages.data.ResourceState
import com.example.videomessages.databinding.FragmentLoginBinding
import com.example.videomessages.di.Settings
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class FragmentLogin: Fragment(R.layout.fragment_login) {
    private lateinit var b: FragmentLoginBinding
    private val viewModel: LoginViewModel by viewModel()
    private val settings: Settings by inject()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        b = FragmentLoginBinding.bind(view)
        b.btnSignIn.setOnClickListener {
            when {
                b.etPassword.text.isEmpty() -> {
                    b.etPassword.error = "Parolni kiriting!"
                }
                b.username.text.isEmpty() -> {
                    b.username.error = "Ismingizni kiriting!"
                }
                else -> {
                    viewModel.loginUser(
                        b.username.text.toString(),
                        b.etPassword.text.toString().toInt()
                    )
                }
            }
        }
        viewModel.login.observe(viewLifecycleOwner) {
            when (it.status) {
                ResourceState.LOADING -> {
                    b.progressBar.isVisible = true
                }
                ResourceState.SUCCESS -> {
                    Toast.makeText(requireContext(), "SUCCESS", Toast.LENGTH_SHORT).show()
                    b.progressBar.isVisible = false
                    settings.isSign = it.data!!.token.toInt()
                }
                ResourceState.ERROR -> {
                    b.progressBar.isVisible = false
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}