package com.hbworld.githubcpr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hbworld.githubcpr.data.model.FetchCPRResponse
import com.hbworld.githubcpr.data.remote.GithubAPI
import com.hbworld.githubcpr.data.remote.RetrofitClient
import com.hbworld.githubcpr.data.repository.GithubRepository
import com.hbworld.githubcpr.view.PRAdapter
import com.hbworld.githubcpr.viewmodel.CustomViewModelFactory
import com.hbworld.githubcpr.viewmodel.ParentViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var parentViewModel: ParentViewModel
    private lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val customViewModelFactory = CustomViewModelFactory(
            GithubRepository(
                RetrofitClient.get().create(GithubAPI::class.java)
            )
        )

        parentViewModel =
            ViewModelProvider(this, customViewModelFactory)[ParentViewModel::class.java]

        initUI()
        fetchData()

    }

    private fun initUI() {
        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun fetchData() {
        parentViewModel.getAllClosedPR().observe(this) { prList ->
            updatePRAdapter(prList)
        }
    }

    private fun updatePRAdapter(prList: List<FetchCPRResponse>) {
        var adapter = recyclerView.adapter
        if (adapter == null && adapter !is PRAdapter) {
            adapter = PRAdapter(prList)
            recyclerView.adapter = adapter
        } else if (adapter is PRAdapter) {
            adapter.updateList(prList)
        }
    }


}