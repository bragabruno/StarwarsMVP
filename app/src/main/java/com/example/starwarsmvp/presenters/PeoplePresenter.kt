package com.example.starwarsmvp.presenters

import androidx.lifecycle.LifecycleCoroutineScope
import com.example.starwarsmvp.model.GeneralResponse
import com.example.starwarsmvp.rest.StarWarsRepository
import com.example.starwarsmvp.utils.DataType
import com.example.starwarsmvp.utils.UIState
import kotlinx.coroutines.launch
import javax.inject.Inject

class PeoplePresenter @Inject constructor(
    private val repository: StarWarsRepository
) : PeoplePresenterContract {

    private var peopleViewContract: PeopleViewContract? = null

    override fun initPresenter(viewContract: PeopleViewContract) {
        peopleViewContract = viewContract
    }

    override fun getPeopleData(lifecycleCoroutineScope: LifecycleCoroutineScope) {
        lifecycleCoroutineScope.launch {
            repository.people.collect {
                when (it) {
                    is UIState.LOADING -> { peopleViewContract?.loading() }
                    is UIState.SUCCESS -> { peopleViewContract?.success(it.response) }
                    is UIState.ERROR -> { peopleViewContract?.error(it.e) }
                }
            }
        }

        repository.getData(DataType.PEOPLE)
    }

    override fun destroyPresenter() {
        peopleViewContract = null
    }
}

interface PeopleViewContract {
    fun loading()
    fun success(response: GeneralResponse)
    fun error(e: Exception)
}

interface PeoplePresenterContract {
    fun initPresenter(viewContract: PeopleViewContract)
    fun getPeopleData(lifecycleCoroutineScope: LifecycleCoroutineScope)
    fun destroyPresenter()
}