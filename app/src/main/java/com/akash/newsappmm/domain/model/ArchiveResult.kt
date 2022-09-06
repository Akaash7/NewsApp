package com.akash.newsappmm.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ArchiveResult(

    @PrimaryKey
    val title : String,
    val description : String,
    val content : String,
    val pubDate : String,
    val imgURL : String,
    val link : String
)

fun ArchiveResult.toResult() : Result{
    return Result(
        title = title,
        description = description,
        link = link
    )
}