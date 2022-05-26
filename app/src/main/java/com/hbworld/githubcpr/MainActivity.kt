package com.hbworld.githubcpr

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.hbworld.githubcpr.databinding.ActivityMainBinding
import com.hbworld.githubcpr.viewmodel.ParentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var dataBinding: ActivityMainBinding
    private val parentViewModel: ParentViewModel by viewModels ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        dataBinding.lifecycleOwner = this
        dataBinding.viewmodel = parentViewModel

        fetchData()
    }

    private fun fetchData() {
        updateProgressBar(View.VISIBLE)
        parentViewModel.getAllClosedPR().observe(this) { result ->
            handleResult(result)
        }
    }

    private fun handleResult(result: Result<Boolean>) {
        updateProgressBar(View.GONE)
        if (result.isFailure) Toast.makeText(this, R.string.fetch_error, Toast.LENGTH_LONG)
            .show()
    }

    private fun updateProgressBar(visibility: Int) {
        dataBinding.progress.visibility = visibility
    }
}