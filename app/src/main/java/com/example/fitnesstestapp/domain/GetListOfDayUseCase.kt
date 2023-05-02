package com.example.fitnesstestapp.domain

import com.example.fitnesstestapp.domain.model.TrainingModel

class GetListOfDayUseCase(private val repository: TrainingRepository) {
    suspend fun getListOfDayUseCase(): TrainingModel? {
        return repository.getListOfDay()
    }

}