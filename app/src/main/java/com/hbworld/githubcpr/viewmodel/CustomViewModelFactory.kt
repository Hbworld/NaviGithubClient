package com.hbworld.githubcpr.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hbworld.githubcpr.data.repository.GithubRepository

class CustomViewModelFactory(private val githubRepository: GithubRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when(modelClass){

            ParentViewModel::class.java -> ParentViewModel(githubRepository)
            else  -> throw Exception("Unknown type for this factory")
        } as T
    }
}