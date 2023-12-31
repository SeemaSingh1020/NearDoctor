package com.neardoctor.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.neardoctor.databinding.ActivityDoctorListBinding
import com.neardoctor.model.SharedPreferenceHelper
import com.neardoctor.view.ui.adapters.DoctorListAdapter
import com.neardoctor.viewmodels.DoctorListViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DoctorListActivity : AppCompatActivity() {
    @Inject
    lateinit var sharedPreferenceHelper: SharedPreferenceHelper
    /*private val myViewModel: DoctorListViewModel by lazy {
        ViewModelProvider(this)[DoctorListViewModel::class.java]
    }*/
    private val myViewModel: DoctorListViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDoctorListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        myViewModel.getDoctorData()
        binding.recycleDoctorList.layoutManager= LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        myViewModel.doctorList.observe(this) {
            binding.recycleDoctorList.adapter= DoctorListAdapter(sharedPreferenceHelper,it.doctorList)
        }

    }
}