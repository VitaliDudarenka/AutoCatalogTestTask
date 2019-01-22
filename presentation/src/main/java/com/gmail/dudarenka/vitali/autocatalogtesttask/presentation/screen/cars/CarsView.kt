package com.gmail.dudarenka.vitali.autocatalogtesttask.presentation.screen.cars

import com.gmail.dudarenka.vitali.autocatalogtesttask.domain.entity.Car
import com.gmail.dudarenka.vitali.autocatalogtesttask.presentation.base.BaseView

interface CarsView : BaseView {
    fun showProgressBar()
    fun dismissProgressBar()
    fun showCars(carList: List<Car>)
    fun searchCars(search: String)
    fun sortUpByPrice()
    fun sortDownByPrice()
}