package com.hbworld.githubcpr.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.hbworld.githubcpr.domain.GithubRepository
import com.hbworld.githubcpr.domain.model.ClosedPR
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ParentViewModel(private val githubRepository: GithubRepository) :
    ViewModel() {

    val closedPRList = MutableLiveData<List<ClosedPR>>()

    fun getAllClosedPR(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                closedPRList.postValue(githubRepository.getAllClosedPRs())
            } catch (e: Exception) {
                Log.e("getAllClosedPR", e.toString())
            }
        }

    }

}