package com.example.androiddesign

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Ch1_MainViewModel(application : Application) : AndroidViewModel(application) {

    val Repository : Ch1_Repository =
        Ch1_Repository(Ch1_AppDatabase.getDatabase(application, viewModelScope))

    var allUsers : LiveData<List<Ch1_Entity>> = Repository.allUsers

    fun insert(entity : Ch1_Entity) = viewModelScope.launch(Dispatchers.IO) {
        Repository.insert(entity)
    }

    fun deleteAll(entity : Ch1_Entity) = viewModelScope.launch(Dispatchers.IO) {
        Repository.delete(entity)
    }

    fun getAll() : LiveData<List<Ch1_Entity>> {
        return allUsers
    }

}