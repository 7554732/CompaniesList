package com.fomichev.companieslist.di

import com.fomichev.companieslist.network.CompaniesApiService
import com.fomichev.companieslist.network.CompaniesNetwork
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object CompaniesNetworkModule {

    @Provides
    @Singleton
    fun provideRetrofitService(): CompaniesApiService {
        return CompaniesNetwork.retrofitService
    }
}