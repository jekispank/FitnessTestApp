package com.example.fitnesstestapp.data

import android.util.Log
import com.example.fitnesstestapp.data.model.Lesson
import com.example.fitnesstestapp.data.model.Trainer
import com.example.fitnesstestapp.data.model.TrainingApiModel
import com.example.fitnesstestapp.domain.model.LessonModel
import com.example.fitnesstestapp.domain.model.TrainerModel
import com.example.fitnesstestapp.domain.model.TrainingModel

class ModelsMapper {

    fun trainerToTrainerModel(trainer: Trainer): TrainerModel {
        return TrainerModel(
            id = trainer.id,
            full_name = trainer.full_name
        )
    }

    fun lessonToLessonModel(lesson: Lesson, trainer: Trainer): LessonModel {
        return LessonModel(
            date = lesson.date,
            trainingName = lesson.name,
            color = lesson.color,
            startTime = lesson.startTime,
            endTime = lesson.endTime,
            place = lesson.place,
            trainingDuration = lesson.startTime,
            coachName = trainer.full_name
        )
    }

    fun trainingApiModelToTrainingModel(trainingApiModel: TrainingApiModel): TrainingModel {
        val trainerList = trainingApiModel.trainers
        Log.d("SOLUTION", "Current trainer's list is $trainerList")
        return TrainingModel(
            listOfTrainer = trainerList.map { trainerToTrainerModel(it) },
            listOfTrainingsByDay = trainingApiModel.lessons.map {lesson ->
                lessonToLessonModel(lesson, trainerList.first { it.id == lesson.coach_id })
            }.groupBy { it.date },
        )
    }
}
