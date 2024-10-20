package com.enesorhan.contactsapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull


@Entity("kisiler")
data class Persons(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("kisi_id") @NotNull val person_id:Int,

    @ColumnInfo("kisi_ad") @NotNull val person_name:String,

    @ColumnInfo("kisi_tel") @NotNull val person_phone:String
)
