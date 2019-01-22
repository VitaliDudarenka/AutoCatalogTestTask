package com.gmail.dudarenka.vitali.autocatalogtesttask.presentation.screen.cars

import com.gmail.dudarenka.vitali.autocatalogtesttask.domain.usecases.GetCarsUseCase
import com.gmail.dudarenka.vitali.autocatalogtesttask.presentation.base.BasePresenter
import com.gmail.dudarenka.vitali.autocatalogtesttask.presentation.app.App
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject


class CarsPresenter(view: CarsView) : BasePresenter<CarsRouter, CarsView>(view) {
    @Inject
    lateinit var getCarsUseCase: GetCarsUseCase

    override fun onResume() {
        super.onResume()

    }

    fun search(search: String) {
        view.searchCars(search)
    }

    fun loadCars() {
        App.appComponent.inject(this)
        view.showProgressBar()
        val disposable = getCarsUseCase.get().subscribeBy(
                onNext = {
                    view.showCars(it)
                    view.dismissProgressBar()
                },
                onError = {
                    view.dismissProgressBar()
                    router?.showError(it)
                }
        )
        addToDisposable(disposable)
    }

    fun sortUp() {
        view.sortUpByPrice()
    }

    fun sortDown() {
        view.sortDownByPrice()
    }
}