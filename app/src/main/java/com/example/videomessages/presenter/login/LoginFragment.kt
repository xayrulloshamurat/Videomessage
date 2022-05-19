package com.example.videomessages.presenter.login

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.videomessages.R
import com.example.videomessages.data.model.request.LoginRequest
import com.example.videomessages.databinding.FragmentLoginBinding
import com.example.videomessages.utils.UiState
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel
import uz.example.computerservice.utils.onClick
import uz.example.computerservice.utils.showMessage

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel: LoginViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view).apply {
            btnSignIn.onClick {
                viewModel.userLogin(LoginRequest(etUsername.text.toString(), etPassword.text.toString()))
            }
        }
        setUpObserver()
    }

    private fun setUpObserver() {
        lifecycleScope.launchWhenStarted {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {
                    when (it) {
                        is UiState.Loading -> {
                            setLoading(true)
                        }
                        is UiState.Success<String> -> {
                            setLoading(false)
                            if (it.data == "Успешно вошел!") {
                                showMessage(it.data)
                                findNavController().navigate(R.id.action_fragmentLogin_to_fragmentMain)
                            }

                            if (it.data == "admin not found") {
                                binding.etUsername.setText("")
                                binding.etPassword.setText("")
                                showMessage(it.data)
                            }
                        }
                        is UiState.Error -> {
                            setLoading(false)
                        }
                        is UiState.NetworkError -> {
                            showMessage("Интернет не подключен!")
                        }
                        else -> {
                            setLoading(false)
                        }
                    }
                }
            }
        }
    }

    private fun setLoading(load: Boolean) {
        binding.apply {
            progressBar.isVisible = load
            etUsername.isEnabled = !load
            etPassword.isEnabled = !load
        }
    }
}