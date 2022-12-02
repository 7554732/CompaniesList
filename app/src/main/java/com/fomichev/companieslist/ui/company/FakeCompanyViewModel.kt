package com.fomichev.companieslist.ui.company

import androidx.lifecycle.MutableLiveData
import com.fomichev.companieslist.domain.CompanyCardModel

class FakeCompanyViewModel : CompanyViewModelApi {
    override val company = MutableLiveData(
        CompanyCardModel(
            id= "1",
            name= "By Park Inn.Ижевск",
            img = "test_images/1.jpg",
            description = "By Park Inn\r\nПриглашаем посетить европейский ресторан, который является украшением международногоотеля Park Inn by Radisson, находящегося на центральной площади столицы Удмуртии.\r\n\r\nЕвропейская кухня порадует гостей города и ценителей гармоничным вкусом и разнообразием выбора. Обширные площади ресторана позволят уютно расположиться большому количеству гостей. Банкетный зал располагает к тому, чтобы организовать официальный прием иностранных делегаций. Привлекательная обстановка доставит удовольствие гармонией стиля, утонченность интерьера усладит взор высоких гостей грациозным изяществом. Живая музыка подарит прекрасное настроение и оставит приятное послевкусие. Для удобства клиентов ресторан предоставляет свободный Wi-Fi. В теплое время открыта для посещения летняя терраса al Café, где вы сможете насладиться прохладительными напитками и яствами.\r\n\r\nОпытный шеф-повар представит все богатство выбора традиционной европейской кухни и нестандартные авторские блюда. Естественная европейская кухня славится широким ансамблем блюд из овощей и мяса с небольшим добавлением приправ и специй. Это способствует достижению оптимально насыщенного и естественного вкуса компонентов. Перед употреблением блюда рекомендуется заказать аперитив – какой-либо спиртной напиток – для повышения аппетита и лучшего усвоения пищи. \r\n\r\nОпределить наше точное местоположение поможет сайт Ижевска. С нетерпением ожидаем появления новых гостей.",
            lat = "56.85152",
            lon = "53.207789",
            www = "www.sparta-fitness.ru",
            phone = "+79875218872"
        )
    )
}
