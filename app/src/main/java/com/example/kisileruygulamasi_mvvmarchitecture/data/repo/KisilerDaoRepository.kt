package com.example.kisileruygulamasi_mvvmarchitecture.data.repo

import android.util.Log

class KisilerDaoRepository {

    fun kisiKayit(kisi_ad:String,kisi_tel:String){
        Log.e("Kişi Kayıt","$kisi_ad - $kisi_tel")
    }

    fun kisiGuncelle(kisi_id:Int,kisi_ad:String,kisi_tel:String){
        Log.e("Kişi Güncelle","$kisi_id - $kisi_ad - $kisi_tel")
    }

    fun kisiAra(aramaKelimesi:String){
        Log.e("Kişi Ara",aramaKelimesi)
    }

    fun kisiSil(kisi_id: Int){
        Log.e("Kişi Sil",kisi_id.toString())
    }

}