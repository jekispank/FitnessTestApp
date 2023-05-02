package com.example.fitnesstestapp.data

import com.example.fitnesstestapp.data.model.Lesson
import com.example.fitnesstestapp.data.model.Trainer
import com.example.fitnesstestapp.data.model.TrainingApiModel
import com.example.fitnesstestapp.domain.model.LessonModel
import com.example.fitnesstestapp.domain.model.TrainerModel
import com.example.fitnesstestapp.domain.model.TrainingModel

class ModelsMapper {

    private fun trainerToTrainerModel(trainer: Trainer): TrainerModel {
        return TrainerModel(
            id = trainer.id,
            full_name = trainer.full_name
        )
    }

    private fun lessonToLessonModel(lesson: Lesson): LessonModel {
        return LessonModel(
            date = lesson.date,
            trainingName = lesson.name,
            color = lesson.color,
            startTime = lesson.startTime,
            endTime = lesson.endTime,
            place = lesson.place,
            trainingDuration = lesson.startTime,
            coachName = lesson.coach_id
        )
    }

    fun trainingApiModelToTrainingModel(trainingApiModel: TrainingApiModel): TrainingModel {
        val trainerList = trainingApiModel.trainers
        return TrainingModel(
            listOfTrainer = trainerList.map { trainerToTrainerModel(it) },
            listOfTrainingsByDay = trainingApiModel.lessons.map {
                lessonToLessonModel(it)
            }.groupBy { it.date },
        )
    }
}
