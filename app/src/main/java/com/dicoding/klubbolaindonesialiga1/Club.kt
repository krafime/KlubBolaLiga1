package com.dicoding.klubbolaindonesialiga1

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Club(
    val nameClub: String,
    val fullNameClub : String,
    val photoClub: String,
    val descClub: String
) : Parcelable
