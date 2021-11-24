package com.example.flags

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.launch
import java.lang.Exception

class FlagViewModel: ViewModel() {
    private val _status = MutableLiveData<String>()
    val status: LiveData<String> = _status
    init {
        flagPhotos()
    }
    private fun flagPhotos(){
        viewModelScope.launch{
            try {
                val listResult = FlagsApi.retrofitService.getImages()
                _status.value = "Success ${listResult.data.size}"

            }catch (e: Exception){
                _status.value = "Fail ${e.message}"
            }
        }
    }
}