package com.fomichev.companieslist.network

import com.fomichev.companieslist.domain.CompanyItemModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface CompaniesApiService {
    @GET("test.php")
    suspend fun getCompanies(): List<CompanyItemModel>
}

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

object CompaniesNetwork {

    val API_ENDPOINT = "https://lifehack.studio/test_task/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(API_ENDPOINT)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    private var _retrofitService: CompaniesApiService? = null

    val retrofitService: CompaniesApiService
        get() = _retrofitService ?: retrofit.create(CompaniesApiService::class.java)
}