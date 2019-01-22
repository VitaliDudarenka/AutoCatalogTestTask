package com.gmail.dudarenka.vitali.autocatalogtesttask.domain.executor

import io.reactivex.Scheduler

interface PostExecutorThread {
    fun getScheduler(): Scheduler
}