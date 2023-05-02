package com.example.fitnesstestapp.domain.model

data class TrainingModel(
    val listOfTrainingsByDay: Map<String, List<LessonModel>>,
    val listOfTrainer: List<TrainerModel>
)
