package com.mnzlabz.iliachallenge.ui.fragments

import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.mnzlabz.iliachallenge.R
import com.mnzlabz.iliachallenge.data.model.AuthRequest
import com.mnzlabz.iliachallenge.databinding.FragmentLoginBinding
import com.mnzlabz.iliachallenge.ui.viewmodels.AuthViewModel
import com.mnzlabz.iliachallenge.utils.Notifier
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private val authViewModel: AuthViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        initializeListeners()
        initializeObservers()

        binding.progress.visibility = View.GONE
        return binding.root
    }

    private fun initializeListeners() {
        with(binding) {
            btnLogin.setOnClickListener {
                binding.btnLogin.isClickable = false
                binding.progress.visibility = View.VISIBLE

                if(!username.text.isNullOrEmpty() && !password.text.isNullOrEmpty()) {
                    var authRequest = AuthRequest(username.text.toString(), password.text.toString())
                    authViewModel.login(authRequest)

                } else {
                    binding.progress.visibility = View.GONE
                    binding.btnLogin.isClickable = true
                    Notifier.notify("Tem campo Vazio ein =(", layoutInflater.context)
                }

            }
        }
    }

    fun initializeObservers() {
        authViewModel.logingStatus.observe(viewLifecycleOwner, Observer {
            if(it.success()) {
                binding.progress.visibility = View.GONE
                this.findNavController().navigate(R.id.action_loginFragment_to_teamsFragment)
                Notifier.notify("Login feito com Sucesso!", layoutInflater.context)
            } else {
                binding.btnLogin.isClickable = true
                binding.progress.visibility = View.GONE
                Notifier.notify(it.failure(), layoutInflater.context)
            }
        })
    }


}