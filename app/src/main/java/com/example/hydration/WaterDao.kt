package com.example.hydration

import androidx.room.*
import kotlinx.coroutines.flow.Flow

// room is doing a lot of work for us, figuring out update, insert, delete

@Dao  // data access object
interface WaterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(record: WaterRecord)

    @Update
    suspend fun update(record: WaterRecord)

    @Delete
    suspend fun delete(record: WaterRecord)

    @Query("SELECT * FROM WaterRecord WHERE day = :day LIMIT 1")
    fun getRecordForDay(day: String): Flow<WaterRecord>

    @Query("SELECT * FROM WaterRecord")
    fun getAllRecords(): Flow<List<WaterRecord>>

}