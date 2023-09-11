package com.example.einfachkochen

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [FactsData::class], version = 1)
abstract class FactsDataBase : RoomDatabase() {

    abstract val dao: FactsDatabaseDao
}

private lateinit var INSTANCE: FactsDataBase

fun getFactsDatabase(context: Context): FactsDataBase {

    synchronized(FactsDataBase::class.java){
        if(!::INSTANCE.isInitialized){
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                FactsDataBase::class.java,
                "item_table"
            ).build()
        }
        return INSTANCE
    }
}