package com.example.fitnesstestapp.di

import com.example.fitnesstestapp.data.GetDataFromNetwork
import com.example.fitnesstestapp.data.GetDataFromNetworkImpl
import com.example.fitnesstestapp.data.TrainingRepositoryImpl
import com.example.fitnesstestapp.data.TrainingApiService
import com.example.fitnesstestapp.domain.GetListOfDayUseCase
import com.example.fitnesstestapp.domain.TrainingRepository
import com.example.fitnesstestapp.presentation.TrainingListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

private const val BASE_URL = "https://olimpia.fitnesskit-admin.ru/"

val mainModule = module {

    single<TrainingApiService> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

    single<GetDataFromNetwork> {
        GetDataFromNetworkImpl(trainingApiService = get())
    }

    single<TrainingRepository> {
        TrainingRepositoryImpl(getDataFromNetwork = get())
    }
    single {
        GetListOfDayUseCase(repository = get())
    }
    viewModel{
        TrainingListViewModel(
            getListOfDayUseCase = get()
        )
    }
}