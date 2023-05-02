package com.example.fitnesstestapp.data

import android.util.Log
import com.example.fitnesstestapp.data.model.TrainingApiModel
import retrofit2.Response

class GetDataFromNetworkImpl( private val trainingApiService: TrainingApiService): GetDataFromNetwork {
    override suspend fun getDataFromNetwork(): Response<TrainingApiModel> {
        Log.d("SOLUTION", "GetDataFromNetworkImpl is started")
        val response = trainingApiService.getListOfTraining()

        Log.d("SOLUTION", "GetDataFromNetworkImpl is $response")
        return response
    }
}