package com.fomichev.companieslist.domain

import com.fomichev.companieslist.database.CompanyItem

open class CompanyItemModel  (
    open val id: String = "",
    open val name: String = "",
    open val img: String = ""
)

fun CompanyItemModel.asDatabaseModel(): CompanyItem {
    return CompanyItem(
        id = id,
        name = name,
        img = img,
    )
}