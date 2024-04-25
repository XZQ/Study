package com.xzq.composestudy.view

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class WellnessViewModel : ViewModel() {

    /**
     * Don't expose the mutable list of tasks from outside the ViewModel.
     * Instead define _tasks and tasks. _tasks is internal and mutable inside the ViewModel.
     * tasks is public and read-only.
     */
    private val _tasks = List(100) { i -> WellnessTask(i, "Task # $i") }.toMutableStateList()

    val tasks: List<WellnessTask>
        get() = _tasks

    fun remove(item: WellnessTask) {
        _tasks.remove(item)
    }


    fun changeTaskChecked(item: WellnessTask, checked: Boolean) {
        tasks.find { it.id == item.id }?.let { task ->
            task.checked = checked
        }
    }

}