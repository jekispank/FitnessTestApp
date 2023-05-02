package com.example.fitnesstestapp.data

import com.example.fitnesstestapp.data.model.TrainingApiModel
import retrofit2.Response
import retrofit2.http.GET

interface TrainingApiService {
    @GET("schedule/get_v3/?club_id=2")
    suspend fun getListOfTraining(): Response<TrainingApiModel>
}