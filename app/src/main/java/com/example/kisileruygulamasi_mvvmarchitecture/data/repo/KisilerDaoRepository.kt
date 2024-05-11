package com.example.kisileruygulamasi_mvvmarchitecture.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.kisileruygulamasi_mvvmarchitecture.data.entity.Kisiler

class KisilerDaoRepository {

    var kisilerListesi:MutableLiveData<List<Kisiler>>

    init {
        kisilerListesi = MutableLiveData()
    }

    fun kisileriGetir() : MutableLiveData<List<Kisiler>> {
        return kisilerListesi
    }

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

    fun tumKisileriAl(){
        val liste = ArrayList<Kisiler>()
        val k1 = Kisiler(1,"Ahmet","1111")
        val k2 = Kisiler(2,"Zeynep","2222")
        val k3 = Kisiler(3,"Beyza","3333")

        liste.add(k1)
        liste.add(k2)
        liste.add(k3)

        kisilerListesi.value = liste
    }

}