package com.mnzlabz.iliachallenge.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.mnzlabz.iliachallenge.data.model.AuthRequest
import com.mnzlabz.iliachallenge.databinding.ActivityMainBinding
import com.mnzlabz.iliachallenge.ui.viewmodels.AuthViewModel
import com.mnzlabz.iliachallenge.ui.viewmodels.TeamViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onBackPressed() {
        this.finishAffinity()
        this.finish()
    }

}