package com.example.einfachkochen

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface FactsDatabaseDao {

    @Insert
    fun insertAll(facts: FactsData)

    @Update
    fun updateItem(isLiked: FactsData)

    @Delete
    fun deleteItem(facts: FactsData)

    @Query("SELECT * FROM item_table WHERE id = :itemId")
    fun getItemById(itemId:Long):FactsData

    @Query("SELECT * FROM item_table WHERE istLiked =1")
    fun getLiked(): LiveData<List<FactsData>>

    @Query("SELECT * FROM item_table")
    fun getAll(): LiveData<List<FactsData>>
}