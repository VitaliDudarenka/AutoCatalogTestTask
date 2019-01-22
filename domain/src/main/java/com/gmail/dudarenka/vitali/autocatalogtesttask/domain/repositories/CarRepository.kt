package com.gmail.dudarenka.vitali.autocatalogtesttask.domain.repositories

import com.gmail.dudarenka.vitali.autocatalogtesttask.domain.entity.Car
import com.gmail.dudarenka.vitali.autocatalogtesttask.domain.repositories.BaseRepository
import io.reactivex.Observable

interface CarRepository : BaseRepository {
    fun get(): Observable<List<Car>>

}