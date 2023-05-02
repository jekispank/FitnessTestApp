package com.example.fitnesstestapp.domain

import android.util.Log
import com.example.fitnesstestapp.domain.model.TrainingModel

class GetListOfDayUseCase(private val repository: TrainingRepository) {
    suspend fun getListOfDayUseCase(): TrainingModel? {
        return repository.getListOfDay()
    }

}