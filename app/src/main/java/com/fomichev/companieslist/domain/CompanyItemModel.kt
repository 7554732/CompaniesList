package com.fomichev.companieslist.domain

import com.fomichev.companieslist.database.CompanyItem

class CompanyItemModel  (
    val id: String = "",
    val name: String = "",
    val img: String = ""
)

fun CompanyItemModel.asDatabaseModel(): CompanyItem {
    return CompanyItem(
        id = id,
        name = name,
        img = img,
    )
}