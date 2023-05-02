package com.example.fitnesstestapp.data.model

data class TrainingApiModel(
    val lessons: List<Lesson>,
    val option: Option,
    val tabs: List<Tab>,
    val trainers: List<Trainer>
)