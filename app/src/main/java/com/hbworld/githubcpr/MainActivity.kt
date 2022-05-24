package com.hbworld.githubcpr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
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
        parentViewModel =
            ViewModelProvider(this, getCustomViewModelFactory())[ParentViewModel::class.java]
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        dataBinding.lifecycleOwner = this
        dataBinding.viewmodel = parentViewModel

        fetchData()
    }

    private fun getCustomViewModelFactory(): CustomViewModelFactory {
        return CustomViewModelFactory(
            GithubRepositoryImpl(
                RetrofitClient.get().create(GithubAPI::class.java),
                ClosedPRMapper()
            )
        )
    }

    private fun fetchData() {
        dataBinding.progress.visibility = View.VISIBLE
        parentViewModel.getAllClosedPR().observe(this) { result ->
            dataBinding.progress.visibility = View.GONE
            if (result.isFailure) Toast.makeText(this, R.string.fetch_error, Toast.LENGTH_LONG)
                .show()
        }
    }
}