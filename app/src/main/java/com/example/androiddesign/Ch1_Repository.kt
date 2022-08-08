package com.example.androiddesign

import androidx.lifecycle.LiveData

class Ch1_Repository(mDatabase : Ch1_AppDatabase) {
    private val dao = mDatabase.dao()
    val allUsers : LiveData<List<Ch1_Entity>> = dao.getAll()
    companion object {
        private var sInstance : Ch1_Repository? = null
        fun getInstance(database : Ch1_AppDatabase) : Ch1_Repository {
            return sInstance
                ?: synchronized(this) {
                    val instance = Ch1_Repository(database)
                    sInstance = instance
                    instance
                }
        }
    }

    suspend fun insert(entity : Ch1_Entity) {
        dao.insert(entity)
    }

    suspend fun delete(entity : Ch1_Entity) {
        dao.delete(entity)
    }

}