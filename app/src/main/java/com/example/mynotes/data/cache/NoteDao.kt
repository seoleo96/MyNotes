package com.example.mynotes.data.cache

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao{

    @Query("SELECT * FROM note")
    fun getAll(): List<NoteEntity>

    @Query("SELECT * FROM note")
    fun getAllFlow(): Flow<List<NoteEntity>>

    @Insert
    fun insertAll(vararg storage: NoteEntity)

    @Insert
    fun insert(storage: NoteEntity)

    @Delete
    fun delete(storage: NoteEntity)

    @Query("DELETE FROM note")
    suspend fun deleteAll()
}