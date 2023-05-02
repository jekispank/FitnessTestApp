package com.example.fitnesstestapp.domain

import com.example.fitnesstestapp.domain.model.TrainingModel
import retrofit2.Response

interface TrainingRepository {

    suspend fun getListOfDay(): TrainingModel?
}