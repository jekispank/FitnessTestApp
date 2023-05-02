package com.example.fitnesstestapp.data

import com.example.fitnesstestapp.data.model.TrainingApiModel
import retrofit2.Response

class GetDataFromNetworkImpl( private val trainingApiService: TrainingApiService): GetDataFromNetwork {
    override suspend fun getDataFromNetwork(): Response<TrainingApiModel> {
        return trainingApiService.getListOfTraining()
    }
}