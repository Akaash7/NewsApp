package com.akash.newsappmm.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SourcesResult(

    @PrimaryKey
    val name : String,
    val link : String,
    val description : String
){
}