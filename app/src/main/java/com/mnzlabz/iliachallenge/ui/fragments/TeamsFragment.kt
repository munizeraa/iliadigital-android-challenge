package com.mnzlabz.iliachallenge.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mnzlabz.iliachallenge.R
import com.mnzlabz.iliachallenge.data.model.Team
import com.mnzlabz.iliachallenge.databinding.FragmentTeamsBinding
import com.mnzlabz.iliachallenge.ui.activities.MainActivity
import com.mnzlabz.iliachallenge.ui.adapters.TeamsAdapter
import com.mnzlabz.iliachallenge.ui.viewmodels.AuthViewModel
import com.mnzlabz.iliachallenge.ui.viewmodels.TeamViewModel
import com.mnzlabz.iliachallenge.utils.Notifier

class TeamsFragment : Fragment() {
    private val teamViewModel: TeamViewModel by activityViewModels()
    private val authViewModel: AuthViewModel by activityViewModels()

    private lateinit var binding: FragmentTeamsBinding
    private lateinit var adapter: TeamsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTeamsBinding.inflate(inflater, container, false)
        adapter = TeamsAdapter()
        adapter.setItems(arrayListOf())
        binding.rvTeams.adapter = adapter
        binding.rvTeams.layoutManager = LinearLayoutManager(this.context)

        initializeListeners()
        initializeObservers()
        initializeHeader()

        teamViewModel.getTeams()

        return binding.root
    }

    private fun initializeObservers() {
        teamViewModel.teams.observe(viewLifecycleOwner, Observer {
            it?.let {
                val r = arrayListOf<Team>()
                r.addAll(it)

                adapter.apply {
                   setItems(r)
               }
            }
        })
    }

    private fun initializeHeader() {
        val loggedUser = authViewModel.getLoggedUser()

        with(binding.header) {
            headerUsername.text = "Nome: ${loggedUser.name}"
            headerAge.text = "Idade: ${loggedUser.age}"
            headerGender.text = "Sexo: ${loggedUser.gender}"
        }
    }
    private fun initializeListeners() {
        binding.header.btnLogout.setOnClickListener {
            startActivity(Intent(this.context, MainActivity::class.java))
            activity?.finishAffinity()
            activity?.finish()
        }
    }

}