package com.example.projectwork.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.projectwork.R
import com.example.projectwork.core.adapter.MultiAdapter
import com.example.projectwork.core.model.BaseModel
import com.example.projectwork.databinding.ScreenHomeBinding

class HomeScreen : Fragment(R.layout.screen_home) {

    private val binding by viewBinding(ScreenHomeBinding::bind)
    private val viewModel: HomeViewModel by viewModels()
    private val multiData = ArrayList<BaseModel>()
    private val adapter by lazy { MultiAdapter() }
    var one=false
    var two=false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getFilmsData()
        viewModel.getPopular()
        setAdapter()
        observer()

    }

    private fun adaptertoData() {


        }

    private fun setAdapter() {
        binding.recyclerView.adapter=adapter
        binding.recyclerView.setHasFixedSize(true)
    }

    private fun loadView() {

    }



    private fun observer() {
            viewModel.filmsPopularLiveData.observe(requireActivity()){
multiData.add(it)
                one=true
            }
        viewModel.filmsNowLiveData.observe(viewLifecycleOwner){
            this.data.add()
        }
    }
}