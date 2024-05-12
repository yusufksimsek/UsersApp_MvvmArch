package com.example.kisileruygulamasi_mvvmarchitecture.util

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.example.kisileruygulamasi_mvvmarchitecture.R

fun Navigation.gecisYap(it:View,id:Int){
    Navigation.findNavController(it).navigate(id)
}

fun Navigation.gecisYap(it:View,id:NavDirections){
    Navigation.findNavController(it).navigate(id)
}