package com.hbworld.githubcpr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hbworld.githubcpr.data.model.FetchCPRResponse
import com.hbworld.githubcpr.data.remote.GithubAPI
import com.hbworld.githubcpr.data.remote.RetrofitClient
import com.hbworld.githubcpr.data.repository.GithubRepository
import com.hbworld.githubcpr.databinding.ActivityMainBinding
import com.hbworld.githubcpr.databinding.ActivityMainBindingImpl
import com.hbworld.githubcpr.view.PRAdapter
import com.hbworld.githubcpr.viewmodel.CustomViewModelFactory
import com.hbworld.githubcpr.viewmodel.ParentViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var parentViewModel: ParentViewModel
    private lateinit var dataBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        dataBinding.lifecycleOwner = this

        val customViewModelFactory = CustomViewModelFactory(
            GithubRepository(
                RetrofitClient.get().create(GithubAPI::class.java)
            )
        )

        parentViewModel =
            ViewModelProvider(this, customViewModelFactory)[ParentViewModel::class.java]
        dataBinding.viewmodel = parentViewModel

        fetchData()

    }

    private fun fetchData() {
        parentViewModel.getAllClosedPR()
    }


}