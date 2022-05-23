package com.hbworld.githubcpr.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.hbworld.githubcpr.data.model.FetchCPRResponse
import com.hbworld.githubcpr.data.repository.GithubRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ParentViewModel(private val githubRepository: GithubRepository) :
    ViewModel() {

    val closedPRList = MutableLiveData<List<FetchCPRResponse>>()

    fun getAllClosedPR(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                closedPRList.postValue(githubRepository.getAllClosedPR())
            } catch (e: Exception) {
                Log.e("getAllClosedPR", e.printStackTrace().toString())
            }
        }

    }

}