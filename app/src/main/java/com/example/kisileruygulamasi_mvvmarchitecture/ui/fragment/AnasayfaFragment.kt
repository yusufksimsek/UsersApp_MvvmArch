package com.example.kisileruygulamasi_mvvmarchitecture.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kisileruygulamasi_mvvmarchitecture.R
import com.example.kisileruygulamasi_mvvmarchitecture.data.entity.Kisiler
import com.example.kisileruygulamasi_mvvmarchitecture.databinding.FragmentAnasayfaBinding
import com.example.kisileruygulamasi_mvvmarchitecture.ui.adapter.KisilerAdapter
import com.example.kisileruygulamasi_mvvmarchitecture.ui.viewmodel.AnasayfaViewModel
import com.example.kisileruygulamasi_mvvmarchitecture.ui.viewmodel.KisiKayitViewModel

// change 1

// change 2 deneme

class AnasayfaFragment : Fragment(),SearchView.OnQueryTextListener,
    androidx.appcompat.widget.SearchView.OnQueryTextListener {
        private lateinit var binding: FragmentAnasayfaBinding
        private lateinit var viewModel: AnasayfaViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_anasayfa, container, false)

        binding.anasayfaFragment = this
        binding.anasayfaToolbarBaslik = "Kişiler"

        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarAnasayfa)

        val kisilerListesi = ArrayList<Kisiler>()
        val k1 = Kisiler(1,"Ahmet","1111")
        val k2 = Kisiler(2,"Zeynep","2222")
        val k3 = Kisiler(3,"Beyza","3333")

        kisilerListesi.add(k1)
        kisilerListesi.add(k2)
        kisilerListesi.add(k3)

        val adapter = KisilerAdapter(requireContext(),kisilerListesi,viewModel)
        binding.kisilerAdapter= adapter

        requireActivity().addMenuProvider(object : MenuProvider{

            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu,menu)

                val item = menu.findItem(R.id.action_ara)
                val searchView = item.actionView as androidx.appcompat.widget.SearchView
                searchView.setOnQueryTextListener(this@AnasayfaFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }

        },viewLifecycleOwner,Lifecycle.State.RESUMED)

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : AnasayfaViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun fabTikla(it: View){
        Navigation.findNavController(it).navigate(R.id.kisiKayitGecis)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.ara(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.ara(newText)
        return true
    }

    override fun onResume() {
        super.onResume()
        Log.e("Kişi Anasayfa","Dönüldü")
    }

}