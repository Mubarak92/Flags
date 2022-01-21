package com.example.flags

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.launch
import java.lang.Exception

class FlagViewModel: ViewModel() {
     val country = MutableLiveData<String>()
     var countryPhotos = MutableLiveData<List<FlagsData>>()

    init {
        flagPhotos()
    }
    private fun flagPhotos(){

        viewModelScope.launch{
            try {
                countryPhotos.value = FlagsApi.retrofitService.getImages().data
                country.value = "Success"

            }catch (e: Exception){
                country.value = "Fail ${e.message}"
            }
        }
    }
}