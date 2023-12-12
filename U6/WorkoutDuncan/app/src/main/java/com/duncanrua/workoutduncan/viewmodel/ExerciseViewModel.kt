package com.duncanrua.workoutduncan.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.duncanrua.workoutduncan.ui.model.Exercise

class ExerciseViewModel:  ViewModel(){
    //Ejercicios
    private val _exercises = MutableLiveData<List<Exercise>>()
    val exercises: LiveData<List<Exercise>> = _exercises

    //Nombre de usuarios
    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String> = _userName



}