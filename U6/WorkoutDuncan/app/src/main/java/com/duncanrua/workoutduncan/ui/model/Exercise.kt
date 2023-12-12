package com.duncanrua.workoutduncan.ui.model

data class Exercise(
    val title: String = ""
) {
    companion object{
        fun getData() : List<Exercise>{
            return  listOf(
                Exercise("Flexiones")
            )
        }
    }
}