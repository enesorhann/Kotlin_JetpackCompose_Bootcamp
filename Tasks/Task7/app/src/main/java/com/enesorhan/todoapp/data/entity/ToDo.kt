package com.enesorhan.todoapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity("todo")
data class ToDo(
    @PrimaryKey(autoGenerate = true) @ColumnInfo("id") @NotNull val id:Int,
    @ColumnInfo("name") @NotNull val name:String
)
