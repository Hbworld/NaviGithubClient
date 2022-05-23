package com.hbworld.githubcpr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.hbworld.githubcpr.data.mapper.ClosedPRMapper
import com.hbworld.githubcpr.data.remote.GithubAPI
import com.hbworld.githubcpr.data.remote.RetrofitClient
import com.hbworld.githubcpr.data.repository.GithubRepositoryImpl
import com.hbworld.githubcpr.domain.GithubRepository
import com.hbworld.githubcpr.databinding.ActivityMainBinding
import com.hbworld.githubcpr.viewmodel.CustomViewModelFactory
import com.hbworld.githubcpr.viewmodel.ParentViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var parentViewModel: ParentViewModel
    private lateinit var dataBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val customViewModelFactory = CustomViewModelFactory(
            GithubRepositoryImpl(
                RetrofitClient.get().create(GithubAPI::class.java),
                ClosedPRMapper()
            )
        )
        parentViewModel =
            ViewModelProvider(this, customViewModelFactory)[ParentViewModel::class.java]
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        dataBinding.lifecycleOwner = this
        dataBinding.viewmodel = parentViewModel

        fetchData()
    }

    private fun fetchData() {
        parentViewModel.getAllClosedPR()
    }
}