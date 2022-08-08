package com.example.androiddesign

import android.content.Context
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope

@Database(entities = [Entity::class], version = 1, exportSchema = false)
abstract class Ch1_AppDatabase : RoomDatabase() {
    abstract fun dao() : Ch1_DAO
    companion object {
        @Volatile
        private var INSTANCE: Ch1_AppDatabase? = null
        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): Ch1_AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    Ch1_AppDatabase::class.java,
                    "database"
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}