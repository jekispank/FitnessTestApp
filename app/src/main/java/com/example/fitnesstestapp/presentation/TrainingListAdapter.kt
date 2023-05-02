package com.example.fitnesstestapp.presentation

import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.graphics.toColorInt
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnesstestapp.R
import com.example.fitnesstestapp.domain.model.LessonModel
import com.example.fitnesstestapp.domain.model.TrainerModel
import java.time.Duration
import java.time.LocalTime
import kotlin.time.toKotlinDuration

class TrainingListAdapter(
    private var lessonList: List<LessonModel>,
    private val trainerList: List<TrainerModel>?
) :
    RecyclerView.Adapter<TrainingListAdapter.TrainingListHolder>() {

    class TrainingListHolder(trainingView: View) : RecyclerView.ViewHolder(trainingView) {
        val colorLine = trainingView.findViewById<ImageView>(R.id.line)
        val startTime = trainingView.findViewById<TextView>(R.id.tv_training_start_time)
        val finishTime = trainingView.findViewById<TextView>(R.id.tv_training_finish_time)
        val trainingName = trainingView.findViewById<TextView>(R.id.tv_training_name)
        val trainingDuration = trainingView.findViewById<TextView>(R.id.tv_training_duration)
        val personIcon = trainingView.findViewById<ImageView>(R.id.tv_person_icon)
        val countOfSportsmen = trainingView.findViewById<TextView>(R.id.tv_count_of_sportsmen)
        val place = trainingView.findViewById<TextView>(R.id.tv_location)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TrainingListHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.training_item, parent, false)
        return TrainingListHolder(view)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: TrainingListHolder, position: Int) {
        val lesson = lessonList[position]
        holder.apply {
            colorLine.background.setTint(lesson.color.toColorInt())
            startTime.text = lesson.startTime
            finishTime.text = lesson.endTime
            trainingName.text = lesson.trainingName
            trainingDuration.text = setLessonDuration(lesson.startTime, lesson.endTime)
            countOfSportsmen.text = setTrainerName(lesson.coachName)
            place.text = lesson.place
            if (lesson.trainingName == "Персональная тренировка") {
                personIcon.setImageResource(R.drawable.ic_person)
            } else personIcon.setImageResource(R.drawable.ic_persons)
        }
    }

    override fun getItemCount(): Int {
        return lessonList.size
    }

    private fun setTrainerName(coachName: String): String {
        return if (coachName.isEmpty()) ""
        else "${trainerList?.first { it.id == coachName }?.full_name}"
    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun setLessonDuration(startTime: String, endTime: String): String {

        val start = LocalTime.parse(startTime)
        val finish = LocalTime.parse(endTime)
        val newDate = Duration.between(start, finish).toKotlinDuration()

        var time = if (newDate.inWholeMinutes.toInt() > 60) {
            "${newDate.inWholeMinutes.toInt() / 60}ч.${newDate.inWholeMinutes.toInt() - 60}мин."
        } else if (newDate.inWholeMinutes.toInt()%60 == 0) {
            "${newDate.inWholeHours}ч."
        } else "${newDate.inWholeMinutes}мин."

        return time
    }
}