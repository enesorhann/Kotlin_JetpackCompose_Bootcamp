package com.enesorhan.genomflix.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity("filmler")
data class Movies(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id") @NotNull val movie_id:Int,

    @ColumnInfo("ad") @NotNull val movie_name:String,

    @ColumnInfo("resim") @NotNull val movie_img_name:String,

    @ColumnInfo("fiyat") @NotNull val movie_price:Int
)
