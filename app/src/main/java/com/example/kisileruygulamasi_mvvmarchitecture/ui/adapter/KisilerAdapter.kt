package com.example.kisileruygulamasi_mvvmarchitecture.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.kisileruygulamasi_mvvmarchitecture.R
import com.example.kisileruygulamasi_mvvmarchitecture.data.entity.Kisiler
import com.example.kisileruygulamasi_mvvmarchitecture.databinding.CardTasarimBinding
import com.example.kisileruygulamasi_mvvmarchitecture.databinding.FragmentAnasayfaBinding
import com.example.kisileruygulamasi_mvvmarchitecture.ui.fragment.AnasayfaFragmentDirections
import com.example.kisileruygulamasi_mvvmarchitecture.ui.viewmodel.AnasayfaViewModel
import com.example.kisileruygulamasi_mvvmarchitecture.util.gecisYap
import com.google.android.material.snackbar.Snackbar

class KisilerAdapter(var mContext: Context,
                     var kisilerListesi: List<Kisiler>,
                     var viewModel: AnasayfaViewModel)
    : RecyclerView.Adapter<KisilerAdapter.cardTasarimTutucu>() {

    inner class cardTasarimTutucu(tasarim:CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root){
        var tasarim: CardTasarimBinding
        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim:CardTasarimBinding = DataBindingUtil.inflate(layoutInflater, R.layout.card_tasarim,parent, false)
        return cardTasarimTutucu(tasarim)
    }

    override fun getItemCount(): Int {
        return kisilerListesi.size
    }

    override fun onBindViewHolder(holder: cardTasarimTutucu, position: Int) {
        val kisi = kisilerListesi.get(position)
        val t = holder.tasarim
        t.kisiNesnesi = kisi

        t.satirCard.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.kisiDetayGecis(kisi = kisi)
            Navigation.gecisYap(it,gecis)
        }

        t.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${kisi.kisi_ad} silinsin mi?",Snackbar.LENGTH_LONG)
                .setAction("Evet"){
                    viewModel.sil(kisi.kisi_id!!)
                }.show()
        }
    }

}