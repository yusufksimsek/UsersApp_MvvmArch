package com.example.kisileruygulamasi_mvvmarchitecture.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasi_mvvmarchitecture.data.entity.Kisiler
import com.example.kisileruygulamasi_mvvmarchitecture.data.repo.KisilerDaoRepository

class AnasayfaViewModel : ViewModel() {

    val krepo = KisilerDaoRepository()
    var kisilerListesi = MutableLiveData<List<Kisiler>>()

    init {
        kisileriYukle()
        kisilerListesi = krepo.kisileriGetir()
    }

    fun ara(aramaKelimesi:String){
        krepo.kisiAra(aramaKelimesi)
    }

    fun sil(kisi_id: Int){
        krepo.kisiSil(kisi_id)
    }

    fun kisileriYukle(){
        krepo.tumKisileriAl()
    }

}