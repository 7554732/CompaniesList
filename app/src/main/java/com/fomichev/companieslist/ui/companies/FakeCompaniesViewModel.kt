package com.fomichev.companieslist.ui.companies


import androidx.lifecycle.MutableLiveData
import com.fomichev.companieslist.domain.CompanyItemModel

class FakeCompaniesViewModel: CompaniesViewModelApi {

    override val companies = MutableLiveData(
        listOf(
            CompanyItemModel(
                "1",
                "By Park Inn.Ижевск",
                "https://lifehack.studio/test_images/1.jpg"
            ),
            CompanyItemModel(
                "2",
                "The James Shark Pub",
                "https://lifehack.studio/test_images/2.jpg"
            )
        )
    )
}