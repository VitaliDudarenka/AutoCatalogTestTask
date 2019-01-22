package com.gmail.dudarenka.vitali.autocatalogtesttask.presentation.screen.cars

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageButton
import com.gmail.dudarenka.vitali.autocatalogtesttask.R
import com.gmail.dudarenka.vitali.autocatalogtesttask.domain.entity.Car
import com.gmail.dudarenka.vitali.autocatalogtesttask.presentation.base.BaseMvpActivity
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_cars.*


class CarsActivity : BaseMvpActivity<CarsPresenter, CarsRouter>(), CarsView {
    private val adapter = CarListAdapter()

    companion object {
        fun getIntent(context: Context): Intent = Intent(context, CarsActivity.javaClass)
    }

    override fun providePresenter(): CarsPresenter = CarsPresenter(this)

    override fun provideRouter(): CarsRouter = CarsRouter(this)

    override fun provideLayoutId(): Int = R.layout.activity_cars

    override fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    override fun dismissProgressBar() {
        progressBar.visibility = View.GONE
    }

    override fun showCars(carList: List<Car>) {
        adapter.listData = carList.toMutableList()
    }

    override fun searchCars(search: String) {
        adapter.filter(search)
    }

    override fun sortDownByPrice() {
        adapter.sortPriceDown()
    }

    override fun sortUpByPrice() {
        adapter.sortPriceUp()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val recyclerView = findViewById<RecyclerView>(R.id.listRecyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView?.adapter = adapter
        presenter.loadCars()
        RxTextView.textChanges(searchEditText)
                .subscribeBy {
                    presenter.search(it.toString())
                }
        val buttonSortUp = findViewById<ImageButton>(R.id.upImageButton)
        val buttonSortDown = findViewById<ImageButton>(R.id.downImageButton)
        buttonSortUp.setOnClickListener {
            presenter.sortUp()
        }
        buttonSortDown.setOnClickListener {
            presenter.sortDown()
        }
    }
}

