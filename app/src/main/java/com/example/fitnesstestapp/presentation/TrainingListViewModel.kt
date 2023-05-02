package com.example.fitnesstestapp.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnesstestapp.domain.GetListOfDayUseCase
import com.example.fitnesstestapp.domain.model.TrainingModel
import kotlinx.coroutines.launch

class TrainingListViewModel(private val getListOfDayUseCase: GetListOfDayUseCase): ViewModel() {


    private var _listOfDay = MutableLiveData<TrainingModel?>()
    val listOfDay: LiveData<TrainingModel?> = _listOfDay

    fun getListOfDay() {
        viewModelScope.launch {
//            try {
                val result = getListOfDayUseCase.getListOfDayUseCase()
                _listOfDay.value = result
                Log.d("TrainingListViewModel", "RESPONSE is $")
//            }
//            catch (e: Exception) {
//                Log.d("Exception", "Something wrooong")
//            }
        }
    }
}