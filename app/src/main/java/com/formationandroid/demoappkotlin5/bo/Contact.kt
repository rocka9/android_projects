package com.formationandroid.demoappkotlin5.bo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Contact(val nom: String, val numero: String) : Parcelable
