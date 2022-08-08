package com.example.androiddesign

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface Ch1_DAO {

    // 데이터베이스 불러오기
    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun getAll() : LiveData<List<Ch1_Entity>>

    // 데이터 추가
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity : Ch1_Entity)

    // 데이터 전체 삭제
    @Query("DELETE FROM user_table")
    fun deleteAll()

    // 데이터 업데이트
    @Update
    fun update(entity : Ch1_Entity)

    // 데이터 삭제
    @Delete
    fun delete(entity : Ch1_Entity)

}