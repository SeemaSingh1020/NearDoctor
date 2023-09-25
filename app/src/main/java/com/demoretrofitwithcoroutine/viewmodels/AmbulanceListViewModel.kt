package com.demoretrofitwithcoroutine.viewmodels

import androidx.lifecycle.ViewModel
import com.demoretrofitwithcoroutine.model.NearAmbulanceList
import com.demoretrofitwithcoroutine.model.NearHospitalsList
import com.demoretrofitwithcoroutine.networking.RetrofitHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@HiltViewModel
class AmbulanceListViewModel @Inject constructor() : ViewModel() {


    fun getAmbulanceData(): Flow<List<NearAmbulanceList>> {
        return flow {
            val response = RetrofitHelper.getRepository().getAmbulanceData()
            if (response.isSuccessful) {
                val nearAmbulanceList = response.body()
                emit(nearAmbulanceList!!)
            } else {
                val error = response.errorBody()
            }

        }.flowOn(Dispatchers.IO)
    }
}