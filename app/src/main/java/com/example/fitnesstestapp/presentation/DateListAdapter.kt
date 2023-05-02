package com.example.fitnesstestapp.presentation

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnesstestapp.R
import com.example.fitnesstestapp.domain.model.TrainingModel
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale

class DateListAdapter(trainingModel: TrainingModel?) :
    RecyclerView.Adapter<DateListAdapter.DayListHolder>() {

    var recyclerView: RecyclerView? = null
    val trainerList = trainingModel?.listOfTrainer
    private lateinit var trainingListAdapter: TrainingListAdapter


    val dayList = trainingModel?.listOfTrainingsByDay?.map { it.key }?.sorted()
    val trainingList = trainingModel?.listOfTrainingsByDay


    class DayListHolder(dayView: View) : RecyclerView.ViewHolder(dayView) {

        val date = dayView.findViewById<TextView>(R.id.tv_date)
        val rvTrainingList = dayView.findViewById<RecyclerView>(R.id.rv_list_of_trainings)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DayListHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_of_days_item, parent, false)

        return DayListHolder(view)
    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: DayListHolder, position: Int) {
        val lessonDate = dayList?.get(position)

        trainingListAdapter = trainingList?.get(lessonDate)?.let { TrainingListAdapter(it, trainerList) }!!
        recyclerView = holder.rvTrainingList

        holder.apply {
            date.text = setDate(lessonDate)
            rvTrainingList.adapter = trainingListAdapter
        }
    }

    override fun getItemCount(): Int {
        return dayList?.size ?: 0
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setDate(lessonDate: String?): String {
        val dateFormat = LocalDate.parse(lessonDate)
        val dayOfWeek = dateFormat.dayOfWeek.getDisplayName(TextStyle.FULL, Locale("ru"))
        val dayOfMonth = dateFormat.dayOfMonth
        val month = dateFormat.month.getDisplayName(TextStyle.FULL, Locale("ru"))

        return "$dayOfWeek, $dayOfMonth $month"
    }
}