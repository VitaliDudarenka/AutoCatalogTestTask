package com.gmail.dudarenka.vitali.autocatalogtesttask.presentation.inject

import com.gmail.dudarenka.vitali.autocatalogtesttask.presentation.screen.cars.CarsPresenter
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(carsPresenter: CarsPresenter)
}