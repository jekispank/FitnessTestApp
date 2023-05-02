package com.example.fitnesstestapp.data

import com.example.fitnesstestapp.data.model.TrainingApiModel
import retrofit2.Response

interface GetDataFromNetwork {
    suspend fun getDataFromNetwork(): Response<TrainingApiModel>
}