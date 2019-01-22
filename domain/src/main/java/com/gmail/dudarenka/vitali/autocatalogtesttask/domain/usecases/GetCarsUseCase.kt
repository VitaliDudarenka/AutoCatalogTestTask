package com.gmail.dudarenka.vitali.autocatalogtesttask.domain.usecases

import com.gmail.dudarenka.vitali.autocatalogtesttask.domain.entity.Car
import com.gmail.dudarenka.vitali.autocatalogtesttask.domain.executor.PostExecutorThread
import com.gmail.dudarenka.vitali.autocatalogtesttask.domain.repositories.CarRepository
import com.gmail.dudarenka.vitali.autocatalogtesttask.domain.usecases.BaseUseCase
import io.reactivex.Observable
import javax.inject.Inject

class GetCarsUseCase @Inject constructor(postExecutorThread: PostExecutorThread,
                                         private val carRepository: CarRepository) : BaseUseCase(postExecutorThread) {

    fun get(): Observable<List<Car>> {
        return carRepository.get().observeOn(postExecutorThread).subscribeOn(workExecutorThread)
    }

}



