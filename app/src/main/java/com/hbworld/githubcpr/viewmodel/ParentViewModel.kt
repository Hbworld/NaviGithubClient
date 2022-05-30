package com.hbworld.githubcpr.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.hbworld.githubcpr.domain.GithubUseCase
import com.hbworld.githubcpr.domain.model.ClosedPR
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ParentViewModel @Inject constructor(private val githubUseCase: GithubUseCase) :
    ViewModel() {

    val closedPRList = MutableLiveData<List<ClosedPR>>()

    fun getAllClosedPR() : LiveData<Result<List<ClosedPR>>>{
        val result = MutableLiveData<Result<List<ClosedPR>>>()
        viewModelScope.launch(Dispatchers.IO) {
            try {
                result.postValue(githubUseCase.getAllClosedPRs())
            } catch (e: Exception) {
                result.postValue(Result.failure(e))
                Log.e("getAllClosedPR", e.toString())
            }
        }
        return result
    }

}