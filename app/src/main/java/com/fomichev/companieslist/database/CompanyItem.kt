package com.fomichev.companieslist.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fomichev.companieslist.domain.CompanyItemModel

@Entity(tableName = "companies_table")
data class CompanyItem constructor(
    @PrimaryKey
    val id: String,
    val name: String,
    val img: String
)

fun CompanyItem.asDomainModel(): CompanyItemModel {
    return CompanyItemModel(
        id = id,
        name = name,
        img = img,
    )
}