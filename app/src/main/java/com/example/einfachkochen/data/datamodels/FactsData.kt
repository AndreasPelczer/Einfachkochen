package com.example.einfachkochen

import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(tableName = "item_table")
data class FactsData(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,

    val fact: String,
    val length: Int,

    var istLiked: Boolean = false

)