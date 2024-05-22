package com.example.fundatest

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Film(
    val name: String,
    val description: String,
    val photo: Int,
    val rate: String,
    val cast: String
) : Parcelable
