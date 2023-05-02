package com.example.fitnesstestapp.data

import com.example.fitnesstestapp.domain.TrainingRepository
import com.example.fitnesstestapp.domain.model.TrainingModel

class TrainingRepositoryImpl(private val getDataFromNetwork: GetDataFromNetwork) : TrainingRepository {

    private val mapper = ModelsMapper()

    override suspend fun getListOfDay(): TrainingModel? {


        val response = getDataFromNetwork.getDataFromNetwork().body()
            ?.let { mapper.trainingApiModelToTrainingModel(it) }

        return response

    }
}
