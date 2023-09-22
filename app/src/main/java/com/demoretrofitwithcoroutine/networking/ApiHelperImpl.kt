package com.demoretrofitwithcoroutine.networking


import com.demoretrofitwithcoroutine.model.UserDetails
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: MyRepository) : ApiHelper {
    override suspend fun getUsers(): Response<UserDetails> {
        return apiService.getUserDetails()
    }


}