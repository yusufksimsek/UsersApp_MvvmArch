package com.example.kisileruygulamasi_mvvmarchitecture.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasi_mvvmarchitecture.data.repo.KisilerDaoRepository

class AnasayfaViewModel : ViewModel() {

    val krepo = KisilerDaoRepository()

    fun ara(aramaKelimesi:String){
        krepo.kisiAra(aramaKelimesi)
    }

    fun sil(kisi_id: Int){
        krepo.kisiSil(kisi_id)
    }

}