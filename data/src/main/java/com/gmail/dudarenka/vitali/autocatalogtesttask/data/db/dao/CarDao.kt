package com.gmail.dudarenka.vitali.autocatalogtesttask.data.db.dao

import android.arch.persistence.room.*
import com.gmail.dudarenka.vitali.autocattesttask.data.db.entity.CarDB
import io.reactivex.Flowable


@Dao
interface CarDao {
    @Insert
    fun insert(car: List<CarDB>)

    @Query("SELECT * FROM car ORDER BY id DESC")
    fun getAll(): Flowable<List<CarDB>>

}