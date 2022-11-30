package com.fomichev.companieslist.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface CompaniesDao {

    @Query("select * from companies_table")
    fun getCompanies(): Flow<List<CompanyItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll( companies: List<CompanyItem>)

    @Delete
    fun delete(companies: List<CompanyItem>)
}