package com.hbworld.githubcpr.viewmodel

import androidx.lifecycle.*
import com.hbworld.githubcpr.domain.GithubUseCase
import com.hbworld.githubcpr.domain.model.ClosedPR
import com.hbworld.githubcpr.domain.model.Results
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ParentViewModel @Inject constructor(private val githubUseCase: GithubUseCase) :
    ViewModel() {

    val closedPRList = MutableLiveData<List<ClosedPR>>()

    fun getAllClosedPR(): LiveData<Results<List<ClosedPR>>> {
        val results = MutableLiveData<Results<List<ClosedPR>>>()
        results.value = Results.loading()
        viewModelScope.launch(Dispatchers.IO) {
            results.postValue(githubUseCase.getAllClosedPRs())
            closedPRList.postValue(results.value!!.data)
        }
        return results
    }

}