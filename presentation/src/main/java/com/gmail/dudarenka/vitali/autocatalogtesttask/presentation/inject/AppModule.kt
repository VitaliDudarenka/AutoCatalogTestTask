package com.gmail.dudarenka.vitali.autocatalogtesttask.presentation.inject

import android.content.Context
import com.gmail.dudarenka.vitali.autocatalogtesttask.data.db.AppDataBase
import com.gmail.dudarenka.vitali.autocatalogtesttask.data.db.dao.CarDao
import com.gmail.dudarenka.vitali.autocatalogtesttask.data.repositories.CarRepositoryImpl
import com.gmail.dudarenka.vitali.autocatalogtesttask.domain.executor.PostExecutorThread
import com.gmail.dudarenka.vitali.autocatalogtesttask.domain.repositories.CarRepository
import com.gmail.dudarenka.vitali.autocatalogtesttask.presentation.executor.UIThread
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val context: Context) {
    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    fun provideCarRepository(carDao: CarDao): CarRepository = CarRepositoryImpl(carDao)

    @Provides
    fun provideCarDao(appDataBase: AppDataBase): CarDao = appDataBase.getCarDao()

    @Provides
    fun provideAppDataBase(context: Context): AppDataBase = AppDataBase.getInstance(context)

    @Provides
    fun providePostExecutorThread(): PostExecutorThread = UIThread()

}