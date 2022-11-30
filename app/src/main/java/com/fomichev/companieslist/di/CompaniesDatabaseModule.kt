package com.fomichev.companieslist.di

import android.content.Context
import com.fomichev.companieslist.database.CompaniesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object CompaniesDatabaseModule {

    @Provides
    @Singleton
    fun provideRetrofitService(@ApplicationContext appContext: Context): CompaniesDatabase {
        return CompaniesDatabase.getInstance(appContext)
    }
}