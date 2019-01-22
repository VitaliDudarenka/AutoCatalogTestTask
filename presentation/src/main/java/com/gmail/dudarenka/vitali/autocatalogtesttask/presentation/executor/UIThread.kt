package com.gmail.dudarenka.vitali.autocatalogtesttask.presentation.executor

import com.gmail.dudarenka.vitali.autocatalogtesttask.domain.executor.PostExecutorThread
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

class UIThread : PostExecutorThread {
    override fun getScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()
    }
}