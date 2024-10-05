package com.enesorhan.composition_build

import com.enesorhan.composition_build.entity.Categories
import com.enesorhan.composition_build.entity.Directors
import com.enesorhan.composition_build.entity.Movies
import java.io.File

fun main(){
    val c1 = Categories(1,"Drama")
    val c2 = Categories(1,"Science Fiction")

    val d1 = Directors(1,"Quentin Tarantino")
    val d2 = Directors(2,"Christopher Nolan")

    val movie = Movies(1,"Django",2013,d2,c2)

    println("Movie ID -> ${movie.movie_id}")
    println("Movie Name -> ${movie.movie_name}")
    println("Movie Year -> ${movie.movie_year}")
    println("Movie Director -> ${movie.directors.director_name}")
    println("Movie Category -> ${movie.categories.category_name}")
}