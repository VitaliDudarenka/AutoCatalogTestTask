package com.gmail.dudarenka.vitali.autocatalogtesttask.presentation.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BasePresenter<R : BaseRouter<*>, V : BaseView>(val view: V) {
    protected var router: R? = null

    protected val compositeDisposable: CompositeDisposable by lazy {
        CompositeDisposable()
    }


    public fun addRouter(router: R?) {
        this.router = router
    }

    public fun removeRouter() {
        this.router = null
    }

    protected fun addToDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    public open fun onResume() {
    }

    public open fun onStart() {
    }

    public open fun onStop() {
    }

    public open fun onPause() {
    }

    public open fun onDestroy() {
        compositeDisposable.clear()
    }


}