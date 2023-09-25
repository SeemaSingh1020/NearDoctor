package com.demoretrofitwithcoroutine.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.demoretrofitwithcoroutine.databinding.ActivityNurseAtHomeBinding
import com.demoretrofitwithcoroutine.view.ui.adapters.NurseAtHomeListAdapter
import com.demoretrofitwithcoroutine.viewmodels.NurseAtHomeListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
@AndroidEntryPoint
class NurseAtHomeListActivity : AppCompatActivity() {
    private val nurseAtHomeViewModel: NurseAtHomeListViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNurseAtHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerViewNurseAtHomeList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        lifecycleScope.launch {
            nurseAtHomeViewModel.getNurseAtHomeData().collect{
                binding.recyclerViewNurseAtHomeList.adapter = NurseAtHomeListAdapter(it)
            }
        }
    }
}