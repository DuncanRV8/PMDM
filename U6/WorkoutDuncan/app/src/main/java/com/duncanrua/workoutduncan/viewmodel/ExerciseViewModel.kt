/**
 *
 * Programa para entrenar en casa con 8 ejercicios y las repeticiones que quieras
 *
 * @author: Duncan Rua Valiente
 * @version: 1.5.6
 *
 */
package com.duncanrua.workoutduncan.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.duncanrua.workoutduncan.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ExerciseViewModel:  ViewModel(){

    /**
     * Live data que vamos a utilizar
     */
    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String> = _userName

    private val _repetitions = MutableLiveData<Int>()
    val repetitions: LiveData<Int> = _repetitions

    private val _isExercising = MutableLiveData<Boolean>()
    val isExercising: LiveData<Boolean> = _isExercising

    private val _currentExercise = MutableLiveData<Int>()
    val currentExercise: LiveData<Int> = _currentExercise

    /**
     * Lista de los gifs
     *
     */
    private val exercisesList = mutableListOf(
        R.drawable.e1,
        R.drawable.e2,
        R.drawable.e3,
        R.drawable.e4,
        R.drawable.e5,
        R.drawable.e6,
        R.drawable.e7,
        R.drawable.e8
    )

    /**
     * Para cambiar el nombre
     *
     * @param _userName
     */
    fun updateUserName(name: String){
        _userName.value = name
    }

    /**
     * Para cambiar las repeticiones
     *
     * @param _repetitions
     */
    fun updatedRepetitions(count: Int){
        _repetitions.value = count
    }

    /**
     * Cada 2 segundos quitara una repetición hasta que llegue a 0 y luego nos devolvera otro ejercicio.
     *
     */
    fun startExercise() {
        _isExercising.value = true
        val initialRepetitions = _repetitions.value ?: 0

        CoroutineScope(Dispatchers.IO).launch {
            _currentExercise.postValue(getRandomExercise())

            while (_isExercising.value == true) {
                delay(2000)

                val currentRep = _repetitions.value ?: initialRepetitions
                if (currentRep > 0) {
                    _repetitions.postValue(currentRep - 1)
                } else {
                    _currentExercise.postValue(getRandomExercise())
                    _repetitions.postValue(initialRepetitions)
                }
            }
        }
    }

    /**
     * Para conseguir un ejercicio random de la lista desordenada.
     */
    private fun getRandomExercise(): Int {
        return exercisesList.shuffled().random()
    }

    /**
     * Para parar el contador de las repeticiones y que empiece de nuevo desde el valor que nos digan.
     */
    fun stopExercise() {
        _isExercising.value = false
    }

    /**
     * Inicializamos los live Data con valores iniciales
     *
     * @param _userName
     * @param _repetitions
     * @param _isExercising
     */
    init {
        viewModelScope.launch(Dispatchers.IO){
            _userName.postValue("")
            _repetitions.postValue(0)
            _isExercising.postValue(false)
        }
    }

}