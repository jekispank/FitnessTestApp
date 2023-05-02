package com.example.fitnesstestapp.domain

import com.example.fitnesstestapp.domain.model.TrainingModel

interface TrainingRepository {

    suspend fun getListOfDay(): TrainingModel?
}