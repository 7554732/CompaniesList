package com.fomichev.companieslist.di

import com.fomichev.companieslist.repository.CompaniesRepository
import com.fomichev.companieslist.repository.CompaniesRepositoryApi
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class CompaniesRepositoryModule{

    @Singleton
    @Binds
    abstract fun bindAdgoalRepository(impl: CompaniesRepository): CompaniesRepositoryApi
}