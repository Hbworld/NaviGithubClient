package com.hbworld.githubcpr.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.hbworld.githubcpr.domain.GithubRepository
import com.hbworld.githubcpr.domain.model.ClosedPR
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ParentViewModel @Inject constructor(private val githubRepository: GithubRepository) :
    ViewModel() {

    val closedPRList = MutableLiveData<List<ClosedPR>>()

    fun getAllClosedPR() : LiveData<Result<Boolean>>{
        val result = MutableLiveData<Result<Boolean>>()
        viewModelScope.launch(Dispatchers.IO) {
            try {
                closedPRList.postValue(githubRepository.getAllClosedPRs())
                result.postValue(Result.success(true))
            } catch (e: Exception) {
                result.postValue(Result.failure(e))
                Log.e("getAllClosedPR", e.toString())
            }
        }
        return result
    }

}