package com.example.superheroapp.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Hero(


  @StringRes  val nameRes:Int,
    @StringRes val descriptionRes : Int,
   @DrawableRes var imageRes:Int
)
