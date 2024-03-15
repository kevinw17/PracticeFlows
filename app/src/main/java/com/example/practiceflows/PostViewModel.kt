package com.example.practiceflows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _result = MutableStateFlow<Posts?>(null)
    val result: StateFlow<Posts?> = _result

    init {
//        val queryMap = mapOf(
//            "userId" to "1",
//            "id" to "1"
//        )
//
//        getPostQueryMap(queryMap)

        getPosts()
    }

    fun getPosts(){
        viewModelScope.launch {
            repository.getPosts().collect {
                _result.value = it
            }
        }
    }

    fun getPostQuery(userId: Int) {
        viewModelScope.launch {
            repository.getPostQuery(userId).collect {
                _result.value = it
            }
        }
    }

    fun getPostQueryMap(queryMap: Map<String, String>) {
        viewModelScope.launch {
            repository.getPostQueryMap(queryMap).collect {
                _result.value = it
            }
        }
    }
}