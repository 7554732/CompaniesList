package com.fomichev.companieslist.repository

import com.fomichev.companieslist.database.CompaniesDatabase
import com.fomichev.companieslist.database.asDomainModel
import com.fomichev.companieslist.domain.CompanyCardModel
import com.fomichev.companieslist.domain.CompanyItemModel
import com.fomichev.companieslist.domain.asDatabaseModel
import com.fomichev.companieslist.network.CompaniesApiService
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CompaniesRepository @Inject constructor(
    private val database: CompaniesDatabase,
    private  val retrofitService: CompaniesApiService
): CompaniesRepositoryApi {

    override val companies = database.companiesDao.getCompanies().map{
        it.map{
            it.asDomainModel()
        }
    }

    override suspend fun refreshCompanies() {
        val responseCompanies = retrofitService.getCompanies()
        database.companiesDao.insertAll(responseCompanies.map{
            it.asDatabaseModel()
        })
    }

    override suspend fun getCompany(id: String): CompanyCardModel {
        return retrofitService.getCompany(id).get(0)
    }
}