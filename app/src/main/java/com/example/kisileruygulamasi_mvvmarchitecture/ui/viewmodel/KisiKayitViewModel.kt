package com.example.kisileruygulamasi_mvvmarchitecture.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasi_mvvmarchitecture.data.repo.KisilerDaoRepository

class KisiKayitViewModel : ViewModel() {

    val krepo = KisilerDaoRepository()

    fun kayit(kisi_ad:String,kisi_tel:String){
        krepo.kisiKayit(kisi_ad,kisi_tel)
    }
}