package com.bounsiarboughazi.dico

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Mot (
    val nom: String,
    val definition: String,
    val image:Int = R.mipmap.ic_launcher,
    val son: Int = R.raw.pet,
    val video: Int? = null
):Parcelable